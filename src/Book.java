public class Book {
    
    private int bookId;
    private String title;
    private String author;
    private boolean isIssued;


    Book(int  id, String title, String author, boolean issued){
        this.bookId =id;
        this.author = author;
        this.title = title;
        this.isIssued = issued;
    }
    Book(int  id, String title, String author){
        this.bookId =id;
        this.author = author;
        this.title = title;
        this.isIssued = false;
    }


    public int getBookId() {
        return bookId;
    }


    public void setBookId(int bookId) {
        this.bookId = bookId;
    }


    public String getTitle() {
        return title;
    }


    public void setTitle(String title) {
        this.title = title;
    }


    public String getAuthor() {
        return author;
    }


    public void setAuthor(String author) {
        this.author = author;
    }


    public boolean isIssued() {
        return isIssued;
    }


    public void setIssued(boolean isIssued) {
        this.isIssued = isIssued;
    }


    @Override
    public String toString() {
        return "Book [bookId=" + bookId + ", title=" + title + ", author=" + author + ", isIssued=" + isIssued + "]";
    }

    
    
}
