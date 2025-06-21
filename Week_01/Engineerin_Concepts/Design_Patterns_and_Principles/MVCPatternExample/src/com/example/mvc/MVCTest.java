package com.example.mvc;

public class MVCTest {
    public static void main(String[] args) {
        // Create Model and View
        Student model = new Student("Sachin Kukkar", "STU101", "A");
        StudentView view = new StudentView();

        // Connect using Controller
        StudentController controller = new StudentController(model, view);

        // Initial display
        controller.updateView();

        // Update model through controller
        controller.setStudentName("Anjali Sharma");
        controller.setStudentGrade("A+");

        // Display again
        controller.updateView();
    }
}
