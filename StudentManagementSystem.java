import java.util.ArrayList;
import java.util.Scanner;

class Student {
    int roll;
    String name;
    String course;

    Student(int roll, String name, String course) {
        this.roll = roll;
        this.name = name;
        this.course = course;
    }
}

public class StudentManagementSystem {

    static ArrayList<Student> students = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void addStudent() {
        System.out.print("Enter Roll Number: ");
        int roll = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Course: ");
        String course = sc.nextLine();

        students.add(new Student(roll, name, course));
        System.out.println("Student Added Successfully!");
    }

    public static void displayStudents() {
        if(students.isEmpty()) {
            System.out.println("No students found!");
            return;
        }

        for(Student s : students) {
            System.out.println("\nRoll: " + s.roll);
            System.out.println("Name: " + s.name);
            System.out.println("Course: " + s.course);
        }
    }

    public static void searchStudent() {
        System.out.print("Enter Name to search: ");
        String name = sc.nextLine();

        for(Student s : students) {
            if(name.equals(s.name)) {
                System.out.println("Student Found!");
                System.out.println("Roll No: " + s.roll);
                System.out.println("Name: " + s.name);
                System.out.println("Course: " + s.course);
                return;
            }
        }

        System.out.println("Student not found!");
    }

    public static void deleteStudent() {
        System.out.print("Enter Roll Number to delete: ");
        int roll = sc.nextInt();

        for(Student s : students) {
            if(s.roll == roll) {
                students.remove(s);
                System.out.println("Student Deleted!");
                return;
            }
        }

        System.out.println("Student not found!");
    }

    public static void main(String[] args) {

        while(true) {
            System.out.println("\n--- Student Management System ---");
            System.out.println("1. Add Student");
            System.out.println("2. Display Students");
            System.out.println("3. Search Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Exit");

            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch(choice) {
                case 1: addStudent(); break;
                case 2: displayStudents(); break;
                case 3: searchStudent(); break;
                case 4: deleteStudent(); break;
                case 5: System.exit(0);
                default: System.out.println("Invalid Choice!");
            }
        }
    }
}