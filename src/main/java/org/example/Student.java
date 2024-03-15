package org.example;

import java.util.ArrayList;
import java.util.List;

public class Student {
    private final String nim;
    private final String name;
    private final String faculty;
    private final String program;
    private final List<String> borrowedBooks;

    public Student(String nim, String name, String faculty, String program) {
        this.nim = nim;
        this.name = name;
        this.faculty = faculty;
        this.program = program; // Inisialisasi nilai program
        this.borrowedBooks = new ArrayList<>();
    }

    public String getNim() {
        return nim;
    }

    public String getName() {
        return name;
    }

    public String getFaculty() {
        return faculty;
    }

    public String getProgram() {
        return program;
    }

    public void displayBooks() {
        System.out.println("==================================================================================================");
        System.out.println("|| No.    || Id buku        || Nama Buku               || Author   || Category   || Stock       ||");
        System.out.println("==================================================================================================");
        System.out.println("|| 1      || 388c-e681-9152 || title                   || author   || Sejarah    || 4           ||");
        System.out.println("|| 2      || d95e-0c4a-9523 || title                   || author   || Sejarah    || 0           ||");
        System.out.println("|| 3      || ed90-be30-5cdb || title                   || author   || Sejarah    || 2           ||");
        System.out.println("==================================================================================================");
    }

    public void borrowBook() {
        // Dummy implementation to simulate borrowing a book
        // You may replace this with actual borrowing logic
        System.out.println("Masukkan nomor buku untuk meminjam: ");
        String bookId = Main.scanner.next();
        borrowedBooks.add(bookId);
        System.out.println("Meminjam buku berhasil.");
    }

    public void displayBorrowedBooks() {
        if (borrowedBooks.isEmpty()) {
            System.out.println("No books borrowed.");
        } else {
            System.out.println("List of Borrowed Books:");
            for (String bookId : borrowedBooks) {
                // Implement logic to display details of borrowed books
                System.out.println(STR."Book ID: \{bookId}");
            }
        }
    }

    public void menuStudent() {
        while (true) {
            System.out.println("=== Student Menu ===");
            System.out.println("1. List buku");
            System.out.println("2. Meminjam buku");
            System.out.println("3. List buku yang terpinjam");
            System.out.println("4. Keluar");
            System.out.print("Choose option (1-4): ");
            int choice = Main.scanner.nextInt();

            switch (choice) {
                case 1:
                    displayBooks();
                    break;
                case 2:
                    borrowBook();
                    break;
                case 3:
                    displayBorrowedBooks();
                    break;
                case 4:
                    System.out.println("System logout...");
                    Main.isStudentLoggedIn = false;
                    return;
                default:
                    System.out.println("Invalid option, please choose a number between 1 and 4.");
            }
        }
    }
}
