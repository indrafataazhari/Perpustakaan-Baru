package Praktikum3;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Library lib = new Library(); 
        lib.addBook(new Book("978-1", "Pemrograman Java Untuk Pemula", "Andi Budiman", 2019));
        lib.addBook(new Book("978-2", "Struktur Data & Algoritma", "Rina Setia", 2020));
        lib.addBook(new Book("978-3", "Dasar Basis Data", "Budi Santoso", 2018));

        Scanner sc = new Scanner(System.in);
        User user = new User("U001", "Indra");

        boolean running = true;
        while (running) {
            System.out.println("\n=== SISTEM PERPUSTAKAAN SEDERHANA ===");
            System.out.println("User: " + user);
            System.out.println("Total buku: " + lib.getCount());
            System.out.println("Pilih menu:");
            System.out.println("1. List buku");
            System.out.println("2. Cari buku (by title)");
            System.out.println("3. Pinjam buku (by ISBN)");
            System.out.println("4. Kembalikan buku (by ISBN)");
            System.out.println("5. Tambah buku");
            System.out.println("0. Keluar");
            System.out.print("Masukkan pilihan: ");

            String choice = sc.nextLine().trim();
            switch (choice) {
                case "1":
                    lib.listAllBooks();
                    break;
                case "2":
                    System.out.print("Masukkan kata kunci judul: ");
                    String q = sc.nextLine();
                    try {
                        Book found = lib.searchByTitle(q);
                        System.out.println("Ditemukan: " + found);
                        System.out.println("Short: " + found.shortDisplay());
                    } catch (BookNotFoundException e) {
                        System.out.println("ERROR: " + e.getMessage());
                    }
                    break;
                case "3":
                    System.out.print("Masukkan ISBN untuk dipinjam: ");
                    String isbnBorrow = sc.nextLine();
                    try {
                        boolean ok = lib.borrowBook(isbnBorrow);
                        if (ok) System.out.println("Berhasil meminjam buku.");
                        else System.out.println("Buku sudah dipinjam sebelumnya.");
                    } catch (BookNotFoundException e) {
                        System.out.println("ERROR: " + e.getMessage());
                    }
                    break;
                case "4":
                    System.out.print("Masukkan ISBN untuk dikembalikan: ");
                    String isbnReturn = sc.nextLine();
                    try {
                        boolean ok = lib.returnBook(isbnReturn);
                        if (ok) System.out.println("Terima kasih, buku dikembalikan.");
                        else System.out.println("Buku belum dipinjam atau sudah dikembalikan.");
                    } catch (BookNotFoundException e) {
                        System.out.println("ERROR: " + e.getMessage());
                    }
                    break;
                case "5":
                    System.out.print("ISBN baru: ");
                    String nisbn = sc.nextLine();
                    System.out.print("Judul: ");
                    String ntitle = sc.nextLine();
                    System.out.print("Pengarang: ");
                    String nauthor = sc.nextLine();
                    System.out.print("Tahun: ");
                    int nyear = 0;
                    try {
                        nyear = Integer.parseInt(sc.nextLine());
                    } catch (NumberFormatException ex) {
                        nyear = 2025; 
                    }
                    boolean added = lib.addBook(new Book(nisbn, ntitle, nauthor, nyear));
                    System.out.println(added ? "Buku ditambahkan." : "Gagal menambahkan buku (kapasitas penuh).");
                    break;
                case "0":
                    running = false;
                    break;
                default:
                    System.out.println("Pilihan tidak valid, coba lagi.");
            }
        }

        sc.close();
        System.out.println("Terima kasih. Program berakhir.");
    }
}
