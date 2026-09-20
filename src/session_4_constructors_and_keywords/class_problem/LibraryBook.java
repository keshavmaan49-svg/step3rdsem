public class LibraryBook {
    private String title;
    private String author;
    private String isbn;

    public LibraryBook(String title, String author, String isbn) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
    }

    public LibraryBook(String title, String author) {
        this(title, author, "PENDING");
    }

    public void displayBook() {
        System.out.printf("Title: %s | Author: %s | ISBN: %s%n", title, author, isbn);
    }

    public static void main(String[] args) {
        LibraryBook b1 = new LibraryBook("Clean Code", "Robert C. Martin", "978-0132350884");
        LibraryBook b2 = new LibraryBook("Java Fundamentals", "Herbert Schildt");

        b1.displayBook();
        b2.displayBook();
    }
}
