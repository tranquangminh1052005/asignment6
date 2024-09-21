
package assignment6_3;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class Person implements IPerson{
    private String id;
    private String fullName;
    private Date dateOfBirth;

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

    public Person(String id, String fullName, String dateOfBirth) throws ParseException {
        this.id = id;
        this.fullName = fullName;
        this.dateOfBirth = dateFormat.parse(dateOfBirth); // Parse date string
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getDateOfBirth() {
        return dateFormat.format(dateOfBirth); // Format date to dd/MM/yyyy
    }

    public void setDateOfBirth(String dateOfBirth) throws ParseException {
        this.dateOfBirth = dateFormat.parse(dateOfBirth); // Parse date string
    }

    public abstract void displayInfo();
}
