/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assignment6_3;

import java.text.ParseException;

public class Student extends Person implements IPerson {
    private float gpa;
    private String major;

    public Student(String id, String fullName, String dateOfBirth, float gpa, String major) throws ParseException {
        super(id, fullName, dateOfBirth);
        this.gpa = gpa;
        this.major = major;
    }

    public float getGpa() {
        return gpa;
    }

    public void setGpa(float gpa) {
        this.gpa = gpa;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public void addStudent() {
        
    }

    public void updateStudent(String id) {
      
    }

    @Override
    public void displayInfo() {
        System.out.println("Student ID: " + getId() + ", Name: " + getFullName() + ", Date of Birth: " + getDateOfBirth() + ", GPA: " + gpa + ", Major: " + major);
    }
}