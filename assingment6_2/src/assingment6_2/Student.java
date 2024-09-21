/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assingment6_2;

import java.util.Date;
import java.text.SimpleDateFormat;

public class Student extends Person implements IPerson {
    private float gpa;
    private String major;
    private double tuition;
    private boolean scholarship;

    public static final double BASE_TUITION = 10000000;

    public Student(String id, String fullName, Date dateOfBirth, float gpa, String major) {
        super(id, fullName, dateOfBirth);
        this.gpa = gpa;
        this.major = major;
        this.scholarship = gpa >= 9;
        this.tuition = calculateTuition();
    }

    public double calculateTuition() {
        if (scholarship) {
            return BASE_TUITION / 2; 
        }
        return BASE_TUITION;
    }

    
    public float getGpa() {
        return gpa;
    }

    public void setGpa(float gpa) {
        this.gpa = gpa;
        this.scholarship = gpa >= 9;
        this.tuition = calculateTuition();
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public double getTuition() {
        return tuition;
    }

    public boolean isScholarship() {
        return scholarship;
    }

    
    @Override
    public void displayInfo() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        System.out.println("ID: " + id);
        System.out.println("Full Name: " + fullName);
        System.out.println("Date of Birth: " + sdf.format(dateOfBirth));
        System.out.println("GPA: " + gpa);
        System.out.println("Major: " + major);
        System.out.println("Tuition: " + tuition);
        System.out.println("Scholarship: " + (scholarship ? "Yes" : "No"));
    }
}