package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Admin {
    private final List<Student> registeredStudents;

    public Admin() {
        this.registeredStudents = new ArrayList<>();
    }

    public void menuAdmin() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("=== Admin Menu ===");
            System.out.println("1. Tambahkan Mahasiswa");
            System.out.println("2. List Mahasiswa yang terdaftar");
            System.out.println("3. Keluar");
            System.out.print("Choose option (1-3): ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    displayRegisteredStudents();
                    break;
                case 3:
                    System.out.println("Logging out from admin account.");
                    Main.isAdminLoggedIn = false;
                    return;
                default:
                    System.out.println("Invalid option, please choose a number between 1 and 3.");
            }
        }
    }

    public void addStudent() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Masukkan Nama: ");
        String name = scanner.nextLine();
        String nim;
        do {
            System.out.print("Masukkan NIM: ");
            nim = scanner.nextLine();
            if (nim.length() != 15) {
                System.out.println("NIM harus terdiri dari 15 digit.");
            }
        } while (nim.length() != 15);

        System.out.print("Masukkan fakultas mahasiswa: ");
        String faculty = scanner.nextLine();
        System.out.print("Masukkan program studi mahasiswa: ");
        String program = scanner.nextLine(); // Menyimpan input program studi ke dalam variabel program

        Student newStudent = new Student(nim, name, faculty, program); // Menambahkan program studi ke konstruktor
        registeredStudents.add(newStudent);

        System.out.println("Mahasiswa berhasil terdaftar.");
    }


    public void displayRegisteredStudents() {
        if (registeredStudents.isEmpty()) {
            System.out.println("Tidak ada mahasiswa yang terdaftar.");
            return;
        }

        System.out.println("List mahasiswa yang terdaftar:");
        System.out.println("=============================================");
        System.out.printf("| %-15s | %-30s | %-30s | %-15s |%n", "NIM", "Nama", "Fakultas", "Program Studi");
        System.out.println("=============================================");
        for (Student student : registeredStudents) {
            System.out.printf("| %-15s | %-30s | %-30s | %-15s |%n", student.getNim(), student.getName(), student.getFaculty(), student.getProgram());
        }
        System.out.println("=============================================");
    }
}
