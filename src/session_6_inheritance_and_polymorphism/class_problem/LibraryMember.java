public class LibraryMember {
    protected String memberId;
    protected String name;
    protected int booksBorrowed;

    public LibraryMember(String memberId, String name) {
        this.memberId = memberId;
        this.name = name;
        this.booksBorrowed = 0;
    }

    public void borrowBook() {
        this.booksBorrowed++;
        System.out.printf("%s borrowed a book. Total: %d%n", name, booksBorrowed);
    }

    public int getBooksBorrowed() {
        return booksBorrowed;
    }

    public void displayProfile() {
        System.out.printf("[%s] Member: %s | Books Borrowed: %d%n", memberId, name, booksBorrowed);
    }
}
