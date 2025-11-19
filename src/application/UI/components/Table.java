package application.UI.components;

import javafx.collections.ObservableList;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;
import java.util.function.Consumer;
import javafx.scene.shape.Circle;

public class Table<T> extends TableView<T> {
    private ObservableList<T> data;

    // Constructor: Pass data, classification property name (e.g., "course" or "major"), and action callbacks
    public Table(ObservableList<T> data, String classificationProperty, Consumer<T> onDelete, Consumer<T> onEdit, Consumer<T> onView) {
        this.data = data;
        this.setItems(data);
        this.setPrefSize(600, 560);
        this.setStyle("-fx-border-color: #D1D5DB; -fx-border-width: 1; -fx-background-color: #FFFFFF;");
        this.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        // Column 1: Profile (Image)
        TableColumn<T, Void> profileCol = new TableColumn<>("Profile");
        profileCol.setCellFactory(new Callback<TableColumn<T, Void>, TableCell<T, Void>>() {
            @Override
            public TableCell<T, Void> call(TableColumn<T, Void> param) {
                return new TableCell<T, Void>() {
                    private final ImageView imageView = new ImageView();
                    private final Label nameLabel = new Label();
                    private final Label ageLabel = new Label();
                    private final VBox vbox = new VBox(5, imageView, nameLabel, ageLabel); // Vertical layout

                    {
                        imageView.setFitWidth(40);
                        imageView.setFitHeight(40);

                        Circle clip = new Circle(20, 20, 20);
                        imageView.setClip(clip);

                        nameLabel.setStyle("-fx-font-size: 10px; -fx-text-fill: black;");
                        ageLabel.setStyle("-fx-font-size: 10px; -fx-text-fill: black;");
                        setGraphic(vbox);
                    }

                    @Override
                    protected void updateItem(Void item, boolean empty) {
                        super.updateItem(item, empty);
                        if (empty || getTableRow() == null || getTableRow().getItem() == null) {
                            imageView.setImage(null);
                            nameLabel.setText("");
                            ageLabel.setText("");
                        } else {
                            try {
                                // Get image path
                                String imagePath = (String) getTableRow().getItem().getClass().getMethod("getImagePath").invoke(getTableRow().getItem());
                                if (imagePath != null && !imagePath.isEmpty()) {
                                    imageView.setImage(new Image("file:" + imagePath));
                                } else {
                                    imageView.setImage(new Image("file:default_profile.png"));
                                }

                                // Get name and age
                                String firstName = (String) getTableRow().getItem().getClass().getMethod("getFirstName").invoke(getTableRow().getItem());
                                String lastName = (String) getTableRow().getItem().getClass().getMethod("getLastName").invoke(getTableRow().getItem());
                                String age = (String) getTableRow().getItem().getClass().getMethod("getAge").invoke(getTableRow().getItem());

                                nameLabel.setText(firstName + " " + lastName);
                                ageLabel.setText("Age: " + age);
                            } catch (Exception e) {
                                imageView.setImage(null);
                                nameLabel.setText("");
                                ageLabel.setText("");
                            }
                        }
                    }
                };
            }
        });
        profileCol.setPrefWidth(150); // Increase width to accommodate text

        // Column 2: Classification (Configurable label, e.g., "Course")
        String label = classificationProperty.equals("course") ? "Course" : "Major";
        TableColumn<T, String> classificationCol = new TableColumn<>(label);
        classificationCol.setCellValueFactory(new PropertyValueFactory<>(classificationProperty)); // Use the passed property name
        classificationCol.setPrefWidth(150);

        // Column 3: Email
        TableColumn<T, String> emailCol = new TableColumn<>("Email");
        emailCol.setCellValueFactory(new PropertyValueFactory<>("email"));
        emailCol.setPrefWidth(200);

        // Column 4: Options (Buttons for Delete, Edit, View)
        TableColumn<T, Void> optionsCol = new TableColumn<>("Options");
        optionsCol.setCellFactory(new Callback<TableColumn<T, Void>, TableCell<T, Void>>() {
            @Override
            public TableCell<T, Void> call(TableColumn<T, Void> param) {
                return new TableCell<T, Void>() {
                    private final Button deleteBtn = new Button("Delete");
                    private final Button editBtn = new Button("Edit");
                    private final Button viewBtn = new Button("View");
                    private final HBox hbox = new HBox(5, viewBtn, editBtn, deleteBtn);

                    {
                        deleteBtn.setStyle("-fx-background-color: #E52949; -fx-text-fill: white;");
                        editBtn.setStyle("-fx-background-color: #FFA500; -fx-text-fill: white;");
                        viewBtn.setStyle("-fx-background-color: #4CAF50; -fx-text-fill: white;");

                        deleteBtn.setOnAction(e -> {
                            T item = getTableRow().getItem();
                            if (item != null && onDelete != null) {
                                onDelete.accept(item); // Trigger delete action
                                // Do not remove from data here, let the controller handle it
                            }
                        });

                        editBtn.setOnAction(e -> {
                            T item = getTableRow().getItem();
                            if (item != null && onEdit != null) {
                                onEdit.accept(item); // Trigger edit action (e.g., open edit dialog)
                            }
                        });

                        viewBtn.setOnAction(e -> {
                            T item = getTableRow().getItem();
                            if (item != null && onView != null) {
                                onView.accept(item); // Trigger view action (e.g., open view dialog)
                            }
                        });

                        setGraphic(hbox);
                    }

                    @Override
                    protected void updateItem(Void item, boolean empty) {
                        super.updateItem(item, empty);
                        setGraphic(empty ? null : hbox);
                    }
                };
            }
        });
        optionsCol.setPrefWidth(150);

        // Add columns to table
        this.getColumns().addAll(profileCol, classificationCol, emailCol, optionsCol);
    }

    // Method to refresh data
    public void refreshData() {
        this.refresh();
    }
}