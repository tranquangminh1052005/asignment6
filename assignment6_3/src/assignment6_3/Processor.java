/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assignment6_3;

import java.text.ParseException;
import java.util.Scanner;

public class Processor {
    public static void main(String[] args) throws ParseException {
        PersonList personList = new PersonList();
        Scanner scanner = new Scanner(System.in);
        int option;

        do {
            System.out.println("1. Add a new student");
            System.out.println("2. Add a new teacher");
            System.out.println("3. Update ");
            System.out.println("4. Delete person by id");
            System.out.println("5. Find person by id");
            System.out.println("6. Display all students and teachers");
            System.out.println("7. Find the student with the highest GPA");
            System.out.println("8. Find a teacher by department");
            System.out.println("9. Exit");
            option = scanner.nextInt();

            switch (option) {
                case 1:
                    System.out.print("Enter student ID: ");
                    String studentId = scanner.next();
                    System.out.print("Enter full name: ");
                    String studentName = scanner.next();
                    System.out.print("Enter date of birth (dd/MM/yyyy): ");
                    String studentDob = scanner.next();
                    System.out.print("Enter GPA: ");
                    float gpa = scanner.nextFloat();
                    System.out.print("Enter major: ");
                    String major = scanner.next();
                    Student student = new Student(studentId, studentName, studentDob, gpa, major);
                    personList.addStudent(student);
                    break;
                case 2:
                    System.out.print("Enter teacher ID: ");
                    String teacherId = scanner.next();
                    System.out.print("Enter full name: ");
                    String teacherName = scanner.next();
                    System.out.print("Enter date of birth (dd/MM/yyyy): ");
                    String teacherDob = scanner.next();
                    System.out.print("Enter department: ");
                    String department = scanner.next();
                    System.out.print("Enter teaching subject: ");
                    String subject = scanner.next();
                    Teacher teacher = new Teacher(teacherId, teacherName, teacherDob, department, subject);
                    personList.addTeacher(teacher);
                    break;
                case 3:
                    // Logic for updating person (similar process)
                    break;
                case 4:
                    System.out.print("Enter person ID to delete: ");
                    String deleteId = scanner.next();
                    personList.deletePersonById(deleteId);
                    break;
                case 5:
                    System.out.print("Enter person ID to find: ");
                    String findId = scanner.next();
                    Person person = personList.findPersonById(findId);
                    if (person != null) {
                        person.displayInfo();
                    } else {
                        System.out.println("Person not found");
                    }
                    break;
                case 6:
                    personList.displayEveryone();
                    break;
                case 7:
                    Student topStudent = personList.findTopStudent();
                    if (topStudent != null) {
                        topStudent.displayInfo();
                    } else {
                        System.out.println("No students found");
                    }
                    break;
                case 8:
                    System.out.print("Enter department to search: ");
                    String searchDept = scanner.next();
                    Teacher deptTeacher = personList.findTeacherByDepartment(searchDept);
                    if (deptTeacher != null) {
                        deptTeacher.displayInfo();
                    } else {
                        System.out.println("No teacher found in that department");
                    }
                    break;
            }
        } while (option != 9);

        scanner.close();
    }
}
