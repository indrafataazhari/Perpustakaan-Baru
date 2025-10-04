package Praktikum3;

public class Library {
    private Book[] books;
    private int count;

    public Library() {
        books = new Book[100]; // kapasitas max 100
        count = 0;
    }

    public boolean addBook(Book b) {
        if (count >= books.length) return false;
        books[count++] = b;
        return true;
    }

    public int getCount() {
        return count;
    }

    public void listAllBooks() {
        if (count == 0) {
            System.out.println("Belum ada buku.");
            return;
        }
        for (int i = 0; i < count; i++) {
            System.out.println((i+1) + ". " + books[i]);
        }
    }

    public Book searchByTitle(String keyword) throws BookNotFoundException {
        for (int i = 0; i < count; i++) {
            if (books[i].getTitle().toLowerCase().contains(keyword.toLowerCase())) {
                return books[i];
            }
        }
        throw new BookNotFoundException("Buku dengan judul mengandung '" + keyword + "' tidak ditemukan.");
    }

    public boolean borrowBook(String isbn) throws BookNotFoundException {
        for (int i = 0; i < count; i++) {
            if (books[i].getIsbn().equals(isbn)) {
                if (!books[i].isBorrowed()) {
                    books[i].setBorrowed(true);
                    return true;
                }
                return false;
            }
        }
        throw new BookNotFoundException("ISBN " + isbn + " tidak ditemukan.");
    }

    public boolean returnBook(String isbn) throws BookNotFoundException {
        for (int i = 0; i < count; i++) {
            if (books[i].getIsbn().equals(isbn)) {
                if (books[i].isBorrowed()) {
                    books[i].setBorrowed(false);
                    return true;
                }
                return false;
            }
        }
        throw new BookNotFoundException("ISBN " + isbn + " tidak ditemukan.");
    }
}
