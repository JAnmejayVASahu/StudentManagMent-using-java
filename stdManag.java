import java.util.Scanner;

class Student {
    String name;
    int[] grades;

    public Student(String name, int[] grades) {
        this.name = name;
        this.grades = grades;
    }

    public double calculateAverage() {
        int sum = 0;
        for (int grade : grades) {
            sum += grade;
        }
        return (double) sum / grades.length;
    }
}

public class stdManag {
    static Scanner scanner = new Scanner(System.in);
    static Student[] students;
    static int numberOfStudents = 0; // Initialize to 0

    public static void main(String[] args) {
        System.out.println("Welcome to the Student Grade Management System!");

        // Initialize the array to store students
        System.out.print("Enter the number of students: ");
        int totalStudents = scanner.nextInt();
        students = new Student[totalStudents];

        // Menu loop
        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Add Student");
            System.out.println("2. Update Student Grades");
            System.out.println("3. View Student Information");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    updateGrades();
                    break;
                case 3:
                    viewStudentInfo();
                    break;
                case 4:
                    System.out.println("Exiting the program. Goodbye!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    static void addStudent() {
        if (numberOfStudents < students.length) {
            System.out.print("Enter student name: ");
            String name = scanner.next();

            int[] grades = new int[3]; // Assuming three grades for simplicity
            for (int i = 0; i < 3; i++) {
                System.out.print("Enter grade " + (i + 1) + ": ");
                grades[i] = scanner.nextInt();
            }

            students[numberOfStudents] = new Student(name, grades);
            numberOfStudents++;
            System.out.println("Student added successfully!");
        } else {
            System.out.println("Cannot add more students. Array is full.");
        }
    }

    static void updateGrades() {
        System.out.print("Enter the student name to update grades: ");
        String name = scanner.next();

        boolean found = false;
        for (int i = 0; i < numberOfStudents; i++) {
            if (students[i].name.equals(name)) {
                System.out.println("Enter new grades for " + name + ":");
                for (int j = 0; j < 3; j++) {
                    System.out.print("Enter new grade " + (j + 1) + ": ");
                    students[i].grades[j] = scanner.nextInt();
                }
                found = true;
                System.out.println("Grades updated successfully!");
                break;
            }
        }

        if (!found) {
            System.out.println("Student not found!");
        }
    }

    static void viewStudentInfo() {
        System.out.print("Enter the student name to view information: ");
        String name = scanner.next();

        boolean found = false;
        for (int i = 0; i < numberOfStudents; i++) {
            if (students[i].name.equals(name)) {
                System.out.println("Student Information:");
                System.out.println("Name: " + students[i].name);
                System.out.println("Grades: " + students[i].grades[0] + ", " +
                        students[i].grades[1] + ", " + students[i].grades[2]);
                System.out.println("Average: " + students[i].calculateAverage());
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Student not found!");
        }
    }
}
