# 📚 Mini Student Management System (Java Swing)

![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)

## 📑 Table of Contents

- [📖 About](#-about)
  
- [🚀 Features](#-features)
  
- [🛠️ Technologies Used](#-technologies-used)
  
- [📂 Project Structure](#-project-structure)
  
- [💻 How to Run](#-how-to-run)
  
- [📝 License](#-license)

- [📚 What I Learned](#-what-i-learned)
  
- [📈 Future Improvements](#-future-improvements)

---

## 📖 About

A beginner-friendly Java Swing GUI application to manage student records with features to Add, Edit, Delete, View, and Search students by name or roll number. The data is saved and loaded using file serialization.

---
## ✨ Features

- 🔐 Add Student – Enter roll number, name, and marks.

- 📝 Edit Student – Update name and marks using roll number.

- ❌ Delete Student – Remove student entry by roll number.

- 👁️ View All Students – Display all saved student records.

- 🔍 Search by Roll Number – Find a student by their roll number.

- 🔎 Search by Name – Find students with a matching name.

- 💾 Data Persistence – Uses file storage (students.dat) with Java Serialization.

- 🖥️ User Interface with Swing(JFrame, JtextArea, Buttons etc.,).

- 🔢 Sorted Records by Roll Number.

---

## 🧰 Technologies Used

💻 Java

🖼️ Java Swing – for GUI

💾 Serialization – for file-based data saving/loading

👩‍💻 IntelliJ IDEA

---

## 📁 Project Structure

Mini-Student-Management-System-Java/

├── src/

│   ├── Student.java          # Data model for student records

│   └── StudentApp.java       # GUI and application logic

├── .gitignore                # IDE and build folder exclusions

└── README.md                 # Project documentation

---

## 🚀 How to Run

1. Clone this repository:
git clone https://github.com/mnavya-17/Mini-Student-Management-System-Java.git
cd Mini-Student-Management-System-Java

2. Compile the code:
javac src/*.java

3. Run the app:
java src.StudentApp

 ✅ Make sure you have Java installed and javac/java available in your system path.

---

## 📄 License

This project is licensed under the [MIT License](LICENSE).

---

## 📚 What I Learned

- *Object-Oriented Programming (OOP)*
  - Encapsulation using private fields and public getters/setters
  - Abstraction through class design
  - Constructor overloading
  - Method overriding (toString())
  - Object interaction and real-world modeling

- *Java Core Concepts*
  - Classes, objects, constructors, methods, access modifiers
  - this keyword
  - Overriding toString() method

- *Java Collections*
  - Storing and managing data using ArrayList
  - Searching and sorting with Comparator and Collections.sort()

- *GUI with Java Swing*
  - Creating windows using JFrame
  - Handling events with ActionListener
  - User interaction using JTextField, JLabel, JButton, and JOptionPane

- *File Handling*
  - Saving and loading data with ObjectOutputStream and ObjectInputStream
  - Implementing Serializable interface

- *Version Control*
  - Using Git in IntelliJ
  - Creating a GitHub repository and pushing code
  - Writing meaningful commit messages
  - Managing .gitignore to exclude unnecessary files (like .idea/)

---

## 🚧 Future Improvements

-> Export/import to CSV

-> Partial name search

-> Enhanced UI with colors or themes

-> Database support with MySQL

---

Made with ❤️ in Java.

---

### 🙌 Author

Navya M 

✨ Aspiring Software Developer | ECE Engineer
