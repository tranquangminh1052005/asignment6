
package Assignment6;

import java.util.ArrayList;

public class StudentList {
    private ArrayList<Student> studentList;

    public StudentList() {
        studentList = new ArrayList<>();
    }

    public void addStudent(Student student) {
        studentList.add(student);
    }

    public void deleteStudentById(String id) {
        studentList.removeIf(student -> student.id.equals(id));
    }

    public Student findStudentByID(String id) {
        for (Student student : studentList) {
            if (student.id.equals(id)) {
                return student;
            }
        }
        return null;
    }

    public void displayAllStudents() {
        for (Student student : studentList) {
            student.displayInfo();
            System.out.println("-------------------------");
        }
    }

    public Student findTopStudent() {
        if (studentList.isEmpty()) {
            return null;
        }
        Student topStudent = studentList.get(0);
        for (Student student : studentList) {
            if (student.getGpa() > topStudent.getGpa()) {
                topStudent = student;
            }
        }
        return topStudent;
    }
    public void updateStudentById(String id, String newName, float newGpa, String newMajor) {
        Student student = findStudentByID(id);
        if (student != null) {
            student.fullName = newName;
            student.setGpa(newGpa);
            student.setMajor(newMajor);
            System.out.println("Student information updated successfully!");
        } else {
            System.out.println("Student not found.");
        }
    }
    
}