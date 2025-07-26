import javax.swing.*; //swing components
import java.awt.*; //layout and graphics
import java.awt.event.*; //event handling
import java.io.*; //for serialization
import java.util.*; //for ArrayList and Comparator

public class StudentApp extends JFrame {
    private ArrayList<Student> studentList; //stores Student records
    private JTextArea displayArea; //area to display data
    private final String FILE_NAME = "students.dat"; //file for storing serialized Student data

    //constructor: sets up UI components and loads saved data
    public StudentApp() {
        super("Student Management System"); //title of the window

        studentList = loadStudentData(); //loads data from file if exists

        // UI Buttons
        JButton addButton = new JButton("Add");
        JButton viewButton = new JButton("View");
        JButton deleteButton = new JButton("Delete");
        JButton searchRollButton = new JButton("Search by Roll");
        JButton searchNameButton = new JButton("Search by Name");
        JButton editButton = new JButton("Edit");

        //display area setup with scroll and formatting
        displayArea = new JTextArea(14, 50); //14 rows and 50 columns
        displayArea.setEditable(false); //user can't type here
        displayArea.setFont(new Font("Monospaced", Font.PLAIN, 14)); //readable font
        JScrollPane scrollPane = new JScrollPane(displayArea); //scroll if content exceeds

        //creating panel to hold buttons in rows and columns with spacing
        JPanel buttonPanel = new JPanel(new GridLayout(2, 3, 10, 10));
        buttonPanel.add(addButton);
        buttonPanel.add(viewButton);
        buttonPanel.add(deleteButton);
        buttonPanel.add(searchRollButton);
        buttonPanel.add(searchNameButton);
        buttonPanel.add(editButton);

        //setting layout of main frame
        setLayout(new BorderLayout(10, 10));
        add(buttonPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);

        //adding functionality to buttons using lambda expressions
        addButton.addActionListener(e -> addStudent());
        viewButton.addActionListener(e -> displayAllStudents());
        deleteButton.addActionListener(e -> deleteStudent());
        searchRollButton.addActionListener(e -> searchStudentByRoll());
        searchNameButton.addActionListener(e -> searchStudentByName());
        editButton.addActionListener(e -> editStudent());

        //JFrame configuration
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    //method to add new Student to studentList and update the data file
    private void addStudent() {
        try {
            int rollNo = Integer.parseInt(JOptionPane.showInputDialog(this, "Enter Roll No:"));
            if (findStudentByRoll(rollNo) != null) {
                JOptionPane.showMessageDialog(this, "Roll No already exists!");
                return;
            }
            String name = JOptionPane.showInputDialog(this, "Enter Name:");
            double marks = Double.parseDouble(JOptionPane.showInputDialog(this, "Enter Marks:"));

            studentList.add(new Student(rollNo, name, marks));
            sortStudents();
            saveStudentData();
            displayAllStudents();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Invalid input.");
        }
    }

    //method to display all students records in display area
    private void displayAllStudents() {
        StringBuilder sb = new StringBuilder("📋 Student Records:\n\n");
        for (Student s : studentList) {
            sb.append(s).append("\n");
        }
        displayArea.setText(sb.toString());
    }

    //method to delete student based on roll number
    private void deleteStudent() {
        try {
            int rollNo = Integer.parseInt(JOptionPane.showInputDialog(this, "Enter Roll No to Delete:"));
            Student s = findStudentByRoll(rollNo);
            if (s != null) {
                studentList.remove(s);
                saveStudentData();
                displayAllStudents();
            } else {
                JOptionPane.showMessageDialog(this, "Student not found.");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Invalid input.");
        }
    }

    //method to find student by roll number and display
    private void searchStudentByRoll() {
        try {
            int rollNo = Integer.parseInt(JOptionPane.showInputDialog(this, "Enter Roll No to Search:"));
            Student s = findStudentByRoll(rollNo);
            if (s != null) {
                displayArea.setText("✅ Student Found:\n\n" + s.toString());
            } else {
                JOptionPane.showMessageDialog(this, "Student not found.");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Invalid input.");
        }
    }

    //method to find student by name(case insensitive)
    private void searchStudentByName() {
        String name = JOptionPane.showInputDialog(this, "Enter Name to Search:");
        boolean found = false;
        StringBuilder sb = new StringBuilder("🔍 Search Results:\n\n");

        for (Student s : studentList) {
            if (s.getName().equalsIgnoreCase(name.trim())) {
                sb.append(s).append("\n");
                found = true;
            }
        }

        if (found) {
            displayArea.setText(sb.toString());
        } else {
            JOptionPane.showMessageDialog(this, "Student not found.");
        }
    }

    //method to edit student name and marks
    private void editStudent() {
        try {
            int rollNo = Integer.parseInt(JOptionPane.showInputDialog(this, "Enter Roll No to Edit:"));
            Student s = findStudentByRoll(rollNo);
            if (s != null) {
                String newName = JOptionPane.showInputDialog(this, "Enter New Name:", s.getName());
                double newMarks = Double.parseDouble(JOptionPane.showInputDialog(this, "Enter New Marks:", s.getMarks()));
                s.setName(newName);
                s.setMarks(newMarks);
                saveStudentData();
                displayAllStudents();
            } else {
                JOptionPane.showMessageDialog(this, "Student not found.");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Invalid input.");
        }
    }

    //utility method to find a student from the list using roll number
    private Student findStudentByRoll(int rollNo) {
        for (Student s : studentList) {
            if (s.getRollNo() == rollNo)
                return s;
        }
        return null;
    }

    //sorts the list of students by roll number using comparator
    private void sortStudents() {
        studentList.sort(Comparator.comparingInt(Student::getRollNo));
    }

    //saves student list to file using serialization
    private void saveStudentData() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(studentList);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //loads student list from file or creates empty list if file not found
    private ArrayList<Student> loadStudentData() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            return (ArrayList<Student>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            return new ArrayList<>();
        }
    }

    //Main Method
    public static void main(String[] args) {
        SwingUtilities.invokeLater(StudentApp::new);
    }
}

