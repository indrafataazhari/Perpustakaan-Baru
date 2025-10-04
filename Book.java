package Praktikum3;

public class Book {
    private String isbn;
    private String title;
    private String author;
    private int year;
    private boolean borrowed;

    public Book(String isbn, String title, String author, int year) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.year = year;
        this.borrowed = false;
    }

    public String getIsbn() { return isbn; }
    public String getTitle() { return title; }
    public boolean isBorrowed() { return borrowed; }

    public void setBorrowed(boolean borrowed) {
        this.borrowed = borrowed;
    }

    public String shortDisplay() {
        return "[" + isbn + "] " + title;
    }

    @Override
    public String toString() {
        return "Book{" +
                "ISBN='" + isbn + '\'' +
                ", Judul='" + title + '\'' +
                ", Pengarang='" + author + '\'' +
                ", Tahun=" + year +
                ", Status=" + (borrowed ? "Dipinjam" : "Tersedia") +
                '}';
    }
}
