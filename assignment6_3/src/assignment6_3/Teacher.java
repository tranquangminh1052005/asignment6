
package assignment6_3;

import java.text.ParseException;

public class Teacher extends Person implements IPerson {
    private String department;
    private String teachingSubject;

    public Teacher(String id, String fullName, String dateOfBirth, String department, String teachingSubject) throws ParseException {
        super(id, fullName, dateOfBirth);
        this.department = department;
        this.teachingSubject = teachingSubject;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getTeachingSubject() {
        return teachingSubject;
    }

    public void setTeachingSubject(String teachingSubject) {
        this.teachingSubject = teachingSubject;
    }

    public void addTeacher() {
       
    }

    public void updateTeacher(String id) {
       
    }

    @Override
    public void displayInfo() {
        System.out.println("Teacher ID: " + getId() + ", Name: " + getFullName() + ", Date of Birth: " + getDateOfBirth() + ", Department: " + department + ", Teaching Subject: " + teachingSubject);
    }
}
