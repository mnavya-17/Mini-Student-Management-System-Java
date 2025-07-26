import java.io.Serializable;//enables object serialization

public class Student implements Serializable {
    //private access modifier used to achieve encapsulation
    //restricting direct access to class fields from outside classes
    private int rollNo;
    private String name;
    private double marks;

    //constructor to initialise Student object
    public Student(int rollNo, String name, double marks) {
        this.rollNo = rollNo;
        this.name = name;
        this.marks = marks;
    }

    //getter method
    public int getRollNo() { return rollNo; }
    public String getName() { return name; }
    public double getMarks() { return marks; }

    //setter method
    public void setName(String name) { this.name = name; }
    public void setMarks(double marks) { this.marks = marks; }

    //overriding toString to provide custom String representation
    @Override
    public String toString() {
        return "Roll No: " + rollNo + ", Name: " + name + ", Marks: " + marks;
    }
}