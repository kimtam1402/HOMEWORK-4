package javabt;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class StudentManager {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhap so sinh vien: ");
        int n = scanner.nextInt();
        List<Student> students = new ArrayList<>();

        
        for (int i = 0; i < n; i++) {
            System.out.println("Nhap thong tin cho sinh vien " + (i + 1) + ":");
            System.out.print("Ma sinh vien: ");
            int studentID = scanner.nextInt();
            System.out.print("Ho va Ten: ");
            String fullName = scanner.next();
            System.out.print("Gioi tinh: ");
            String gender = scanner.next();
            System.out.print("Diem Python : ");
            double pythonScore = scanner.nextDouble();
            System.out.print("Diem Java : ");
            double javaScore = scanner.nextDouble();
            students.add(new Student(studentID, fullName, gender, pythonScore, javaScore));
        }

       
        System.out.println("\nThong tin sinh vien:");
        for (Student student : students) {
            System.out.println(student);
        }

    
        Collections.sort(students, Comparator.comparingDouble((Student s) -> s.averageScore).reversed());

        
        try (PrintWriter writer = new PrintWriter(new FileWriter("sorted_students.txt"))) {
            for (Student student : students) {
                writer.println(student);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        
        System.out.print("\nNhap ten day du cua hoc sinh can tim : ");
        String searchName = scanner.next();
        boolean found = false;
        System.out.println("Matching students:");
        for (Student student : students) {
            if (student.fullName.equalsIgnoreCase(searchName)) {
                System.out.println(student);
                found = true;
            }
        }
        if (!found) {
            System.out.println("khong tim thay.");
        }

     
        System.out.println("\nPassed Students:");
        for (Student student : students) {
            if (student.result.equals("Pass")) {
                System.out.println(student);
            }
        }
        System.out.println("\nFailed Students:");
        for (Student student : students) {
            if (student.result.equals("Fail")) {
                System.out.println(student);
            }
        }
    }
}