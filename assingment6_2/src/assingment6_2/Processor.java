
package assingment6_2;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Processor {
    public static void main(String[] args) {
        StudentList studentList = new StudentList();
        Scanner scanner = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        while (true) {
            System.out.println("1. Add new student");
            System.out.println("2. Update student by id");
            System.out.println("3. Delete student by id");
            System.out.println("4. Display all students");
            System.out.println("5. Find student with highest GPA");
            System.out.println("6. Display scholarship students");
            System.out.println("7. Display total tuition of all students");
            System.out.println("8. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter ID: ");
                    String id = scanner.nextLine();
                    System.out.print("Enter full name: ");
                    String fullName = scanner.nextLine();
                    System.out.print("Enter date of birth (dd/MM/yyyy): ");
                    String dobStr = scanner.nextLine();
                    Date dob;
                    try {
                        dob = sdf.parse(dobStr);
                    } catch (Exception e) {
                        System.out.println("Invalid date format. Please try again.");
                        break;
                    }
                    System.out.print("Enter GPA: ");
                    float gpa = scanner.nextFloat();
                    scanner.nextLine();
                    System.out.print("Enter major: ");
                    String major = scanner.nextLine();

                    Student student = new Student(id, fullName, dob, gpa, major);
                    studentList.addStudent(student);
                    break;
                case 2:
                    System.out.print("Enter student ID to update: ");
                    String updateId = scanner.nextLine();
                    Student updateStudent = studentList.findStudentById(updateId);
                    if (updateStudent != null) {
                        System.out.print("Enter new full name: ");
                        String newFullName = scanner.nextLine();
                        System.out.print("Enter new GPA: ");
                        float newGpa = scanner.nextFloat();
                        scanner.nextLine(); 
                        System.out.print("Enter new major: ");
                        String newMajor = scanner.nextLine();

                        updateStudent.setFullName(newFullName);
                        updateStudent.setGpa(newGpa);
                        updateStudent.setMajor(newMajor);
                    } else {
                        System.out.println("Student not found!");
                    }
                    break;
                case 3:
                    System.out.print("Enter student ID to delete: ");
                    String deleteId = scanner.nextLine();
                    studentList.deleteStudentById(deleteId);
                    break;
                case 4:
                    studentList.displayAllStudents();
                    break;
                case 5:
                    Student topStudent = studentList.findTopStudent();
                    if (topStudent != null) {
                        System.out.println("Student with highest GPA:");
                        topStudent.displayInfo();
                    } else {
                        System.out.println("No students found.");
                    }
                    break;
                case 6:
                    System.out.println("Scholarship students:");
                    for (Student scholarshipStudent : studentList.findScholarshipStudents()) {
                        scholarshipStudent.displayInfo();
                    }
                    break;
                case 7:
                    double totalTuition = studentList.calculateTuitionOfAllStudents();
                    System.out.println("Total tuition of all students: " + totalTuition);
                    break;
                case 8:
                    System.out.println("Exiting...");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}