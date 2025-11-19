# TODO: Fix Data Submission Reflection in Table

## Step 1: Modify Controllers to Load Data from masterfile.txt
- [ ] Update AddStudentController to load existing students from masterfile.txt on initialization.
- [ ] Update AddFacultyController to load existing faculty from masterfile.txt on initialization.

## Step 2: Update Save Logic in Controllers
- [ ] Fix AddStudentController save logic to include all fields (year, section, age) in masterfile.txt.
- [ ] Fix AddFacultyController save logic to include all fields (level, college) in masterfile.txt.

## Step 3: Update Scenes to Add New Records to ObservableList
- [ ] In UGScene, after successful submission, add the new Student to studentData ObservableList.
- [ ] In FacultyScene, after successful submission, add the new Faculty to facultyData ObservableList.

## Step 4: Update Table Component
- [ ] Modify Table.java to accept a classification property name dynamically instead of hardcoding "course".

## Step 5: Update Scene Instantiations
- [ ] Update UGScene to pass "course" as the classification property for Table.
- [ ] Update FacultyScene to pass "major" as the classification property for Table.
