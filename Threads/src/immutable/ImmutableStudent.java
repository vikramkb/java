package immutable;

import java.util.*;

final class Address {
    private String houseNumber;
    private String colonyName;
    private String pincode;
    private String state;
    private String country;

    public Address(String houseNumber, String colonyName, String pincode, String state, String country) {
        this.houseNumber = houseNumber;
        this.colonyName = colonyName;
        this.pincode = pincode;
        this.state = state;
        this.country = country;
    }

    public Address updateHouseNumber(String houseNumber) {
        return new Address(houseNumber, colonyName, pincode, state, country);
    }

    @Override
    public String toString() {
        return "Address{" +
                "houseNumber='" + houseNumber + '\'' +
                ", colonyName='" + colonyName + '\'' +
                ", pincode='" + pincode + '\'' +
                ", state='" + state + '\'' +
                ", country='" + country + '\'' +
                '}';
    }
}

//should not be inherited to allow subclass to change the mutability
final class Student {
    //all the properties should be private
    //All immutable types should be private
    private final Date dateOfBirth;
    private String name;
    private final Map<String, Double> marks;
    //address is immutable
    private final Address address;


    //constructor should initialize all the state properly
    Student(Date dateOfBirth, String name, Map<String, Double> marks, Address address) {
        //should assign the copy of the date
        this.dateOfBirth = new Date(dateOfBirth.getTime());
        this.name = name;
        //make use of unmodifiable utilies from collections.
        // Only the references holding by UnmodifiableMap is immutable.
        // The content in this map is still mutable. Care must be taken.
        // In this case, String and Double are mutable classes. No need to worry.
        this.marks = Collections.unmodifiableMap(marks);
        //assign directly as Address is immutable
        this.address = address;
    }

    //modification to any student should create new student object
    public Student addMarks(String subject, Double score) {
        HashMap<String,Double> newMarks = new HashMap(marks);
        newMarks.put(subject, score);
        return new Student(dateOfBirth, name, newMarks, address);
    }

    @Override
    public String toString() {
        return "Student{" +
                "dateOfBirth='" + dateOfBirth + '\'' +
                ", name='" + name + '\'' +
                ", marks ='" + marks + '\'' +
                ", address ='" + address + '\'' +
                '}';

    }
}

public class ImmutableStudent {
    public static void main(String[] args) {
        Address address = new Address("12/1", "house board","nagole", "telangana", "india");
        Map<String, Double> marks = new HashMap<>();
        marks.put("Maths", 99.0);
        marks.put("Physics", 78.0);
        Date dateOfBirth = new GregorianCalendar(2008, 03, 03).getTime();
        Student student = new Student(dateOfBirth, "Vignesh", marks, address);
        System.out.println(student);
        student = student.addMarks("Chemistry", 85.0);
        System.out.println(student);
    }
}
