
package Assignment6;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Processor {
    public static void main(String[] args) {
        StudentList studentList = new StudentList();
        Scanner key = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        while (true) {
            System.out.println("1. Add Student");
            System.out.println("2. Update");
            System.out.println("3. Display All Students");
            System.out.println("4. Find Student by ID");
            System.out.println("5. Delete Student by ID");
            System.out.println("6. Find Top Student");
            System.out.println("7. Exit");
            System.out.print("Choose: ");
            int choice = key.nextInt();
            key.nextLine();

            switch (choice) {
                case 1:
                    try {
                        System.out.print("Enter ID: ");
                        String id = key.nextLine();

                        System.out.print("Enter Full Name: ");
                        String fullName = key.nextLine();

                        System.out.print("Enter Date of Birth (dd/MM/yyyy): ");
                        String dobString = key.nextLine();
                        Date dob = sdf.parse(dobString);

                        System.out.print("Enter GPA: ");
                        float gpa = key.nextFloat();

                        key.nextLine();
                        System.out.print("Enter Major: ");
                        String major = key.nextLine();

                        Student student = new Student(id, fullName, dob, gpa, major);
                        studentList.addStudent(student);
                    } catch (ParseException e) {
                        System.out.println("Invalid date format.");
                    }
                    break;
                case 2:
                    System.out.print("Enter student ID to update: ");
                   String updateId = key.nextLine();
                   
                   System.out.print("Enter new full name: ");
                   String newName = key.nextLine();
                   
                   System.out.print("Enter new GPA: ");
                   float newGpa = key.nextFloat();
                   key.nextLine();
                   
                   System.out.print("Enter new major: ");
                   String newMajor = key.nextLine();
                   
                   studentList.updateStudentById(updateId, newName, newGpa, newMajor);
                   break;

                case 3:
                    studentList.displayAllStudents();
                    break;

                case 4:
                    System.out.print("Enter ID to find: ");
                    String idToFind = key.nextLine();
                    Student fStudent = studentList.findStudentByID(idToFind);
                    if (fStudent != null) {
                        fStudent.displayInfo();
                    } else {
                        System.out.println("Student not found.");
                    }
                    break;

                case 5:
                    System.out.print("Enter ID to delete: ");
                    String delete = key.nextLine();
                    studentList.deleteStudentById(delete);
                    System.out.println("Deleted stuent with ID: " + delete);
                    break;

                case 6:
                    Student topStudent = studentList.findTopStudent();
                    if (topStudent != null) {
                        System.out.println("Top student:");
                        topStudent.displayInfo();
                    } else {
                        System.out.println("No students available.");
                    }
                    break;

                case 7:
                    System.out.println("Exiting...");
                    key.close();
                    return;

                default:
                    System.out.println("Choose error. Try again.");
                    break;
            }
        }
    }
}