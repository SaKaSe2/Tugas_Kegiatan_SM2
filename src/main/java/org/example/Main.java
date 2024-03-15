package org.example;

import java.util.Scanner;

@SuppressWarnings("ALL")
public class Main {
    public static boolean isStudentLoggedIn = false;
    public static boolean isAdminLoggedIn = false;
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        do menu();
        while (true);
    }

    private static void menu() {
        System.out.println("Menu sistem");
        System.out.println("1. Login untuk Mahasiswa");
        System.out.println("2. Login untuk Admin");
        System.out.println("3. Keluar");
        System.out.print("Pilih menu (1-3): ");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                loginAsStudent();
                break;
            case 2:
                loginAsAdmin();
                break;
            case 3:
                System.out.println("Selamat tinggal");
                System.exit(0);
                break;
            default:
                System.out.println("Tidak ada pilihan, hanya ada pilihan 1-3");
        }
    }

    private static void loginAsStudent() {
        if (isStudentLoggedIn) {
            System.out.println("Kamu berhasil masuk sebagai Mahasiswa.");
            return;
        }

        System.out.print("Masukkan NIM kamu (Masukkan 99 untuk kembali): ");
        String nim = scanner.next();
        if ("99".equals(nim)) {
            return;
        }

        Student student = checkNim(nim);
        if (student != null) {
            System.out.println("Berhasil masuk sebagai Mahasiswa");
            isStudentLoggedIn = true;
            student.menuStudent();
        } else {
            System.out.println("User tidak ada");
        }
    }

    private static Student checkNim(String nim) {
        // Dummy implementation to simulate user data lookup
        // You may replace this with actual database or file handling logic
        if ("202310370311265".equals(nim)) {
            return new Student("202310370311265", "Rikza Ahmad", "Teknik", "Informatika");
        }
        return null;
    }


    private static void loginAsAdmin() {
        if (isAdminLoggedIn) {
            System.out.println("You are already logged in as an admin.");
            return;
        }

        System.out.print("Masukkan nama kamu (admin): ");
        String username = scanner.next();
        System.out.print("Masukkan password kamu (admin): ");
        String password = scanner.next();

        if ("rikza".equals(username) && "12345".equals(password)) {
            System.out.println("Successful Login as Admin");
            isAdminLoggedIn = true;
            Admin loggedInAdmin = new Admin();
            loggedInAdmin.menuAdmin();
        } else {
            System.out.println("Admin User Not Found!!");
        }
    }
}
