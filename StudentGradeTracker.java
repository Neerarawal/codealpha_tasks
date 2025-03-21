import java.util.ArrayList;
import java.util.Scanner;

class Student {
    String name;
    double grade;

    public Student(String name, double grade) {
        this.name = name;
        this.grade = grade;
    }
}

public class StudentGradeTracker {
    public static void main(String[] args) {
        ArrayList<Student> students = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Enter number of students: ");
        int n = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        
        for (int i = 0; i < n; i++) {
            System.out.println("Enter student name: ");
            String name = scanner.nextLine();
            System.out.println("Enter student grade: ");
            double grade = scanner.nextDouble();
            scanner.nextLine(); // Consume newline
            students.add(new Student(name, grade));
        }
        
        double sum = 0, highest = Double.MIN_VALUE, lowest = Double.MAX_VALUE;
        for (Student student : students) {
            sum += student.grade;
            if (student.grade > highest) highest = student.grade;
            if (student.grade < lowest) lowest = student.grade;
        }
        
        double average = sum / students.size();
        
        System.out.println("\nStudent Grades:");
        for (Student student : students) {
            System.out.println(student.name + " - " + student.grade);
        }
        
        System.out.println("\nAverage Grade: " + average);
        System.out.println("Highest Grade: " + highest);
        System.out.println("Lowest Grade: " + lowest);
        
        scanner.close();
    }
}
