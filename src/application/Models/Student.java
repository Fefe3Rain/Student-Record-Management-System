package application.Models;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;

public class Student {
    private String id;
    private String firstName;
    private String lastName;
    private String middleInitial;
    private String email;
    private String contactNumber;
    private String course;
    private String year;
    private String section;
    private String age;
    private String sex;
    private String birthday;
    private String nationality;
    private String address;
    private String imagePath;
    private String password;

    public Student() {
        this.id = "";
        this.firstName = "";
        this.lastName = "";
        this.middleInitial = "";
        this.email = "";
        this.contactNumber = "";
        this.course = "";
        this.year = "";
        this.section = "";
        this.age = "";
        this.sex = "";
        this.birthday = "";
        this.nationality = "";
        this.address = "";
        this.imagePath = "";
        this.password = "";
    }

    public Student (String id, String firstName, String lastName, String middleInitial, String email, String contactNumber, 
                    String course, String year, String section, String age, String sex, String birthday, String nationality,String address, String imagePath, String password) {
        this.id = GenerateId();
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleInitial = middleInitial;
        this.email = email;
        this.contactNumber = contactNumber;
        this.course = course;
        this.year = year;
        this.section = section;
        this.age = age;
        this.sex = sex;
        this.birthday = birthday;
        this.nationality = nationality;
        this.address = address;
        this.imagePath = imagePath;
        this.password = GeneratePass();
    }

    public String GeneratePass() {
        if (birthday == null || birthday.trim().isEmpty()) {
            return ""; 
        }
        String[] parts = birthday.trim().split("\\s+"); 
        if (parts.length < 3) {
            return "";
        }
        String month = parts[0];  
        String dayWithComma = parts[1];  
        String year = parts[2];  

        String day = dayWithComma.replace(",", "");

        try {
            int dayInt = Integer.parseInt(day);
            day = String.valueOf(dayInt);
        } catch (NumberFormatException e) {
            return "";  // Invalid day
        }

        return month + day + year;
    }

    public String GenerateId() {
        String counterFile = "id_counter.txt";
        int IdNumber = 1;

        try (BufferedReader reader = new BufferedReader(new FileReader(counterFile))) {
            String line = reader.readLine();
            if (line != null && !line.trim().isEmpty()) {
                IdNumber = Integer.parseInt(line.trim()) + 1;
            }
        } catch (IOException | NumberFormatException e) {
            IdNumber = 1;
        }

        int currentYear = LocalDate.now().getYear() % 100;

        String FormattedId = String.format("TUPM-%02d-%04d", currentYear, IdNumber);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(counterFile))) {
            writer.write(String.valueOf(IdNumber));
        } catch (IOException e) {
            System.err.println("Error updating ID counter: " + e.getMessage());
        }

        return FormattedId;
    }

    public String getId() { return id; }
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public String getMiddleInitial() { return middleInitial; }
    public String getEmail() { return email; }
    public String getContactNumber() { return contactNumber; }
    public String getCourse() { return course; }
    public String getYear() { return year; }
    public String getSection() { return section; }
    public String getAge() { return age; }
    public String getSex() { return sex; }
    public String getBirthday() { return birthday; }
    public String getNationality() { return nationality; }
    public String getAddress() { return address; }
    public String getImagePath() { return imagePath; }

    public void setId(String id) { this.id = id; }
    public void setFirstName(String firstName) { this.firstName = firstName; }
    public void setLastName(String lastName) { this.lastName = lastName; }
    public void setMiddleInitial(String middleInitial) { this.middleInitial = middleInitial; }
    public void setEmail(String email) { this.email = email; }
    public void setContactNumber(String contactNumber) { this.contactNumber = contactNumber; }
    public void setCourse(String course) { this.course = course; }
    public void setYear(String year) { this.year = year; }
    public void setSection(String section) { this.section = section; }
    public void setAge(String age) { this.age = age; }
    public void setSex(String sex) { this.sex = sex; }
    public void setBirthday(String birthday) { this.birthday = birthday; }
    public void setNationality(String nationality) { this.nationality = nationality; }
    public void setAddress(String address) { this.address = address; }
    public void setImagePath(String imagePath) { this.imagePath = imagePath; }

    @Override
    public String toString() {
        return "Student{" +
                "id='" + id + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", middleInitial='" + middleInitial + '\'' +
                ", email='" + email + '\'' +
                ", contactNumber='" + contactNumber + '\'' +
                ", course='" + course + '\'' +
                ", year='" + year + '\'' +
                ", section='" + section + '\'' +
                ", age='" + age + '\'' +
                ", sex='" + sex + '\'' +
                ", birthday='" + birthday + '\'' +
                ", nationality='" + nationality + '\'' +
                ", address='" + address + '\'' +
                ", imagePath='" + imagePath + '\'' +
                '}';
    }  
}