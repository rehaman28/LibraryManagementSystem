public class Book {
    
    private int bookId;
    private String tittle;
    private String author;
    private boolean isIssued;


    Book(int  id, String title, String author, Boolean issued){
        this.bookId =id;
        this.author = author;
        this.tittle = title;
        this.isIssued = issued;
    }
    Book(int  id, String title, String author){
        this.bookId =id;
        this.author = author;
        this.tittle = title;
        
    }


    public int getBookId() {
        return bookId;
    }


    public void setBookId(int bookId) {
        this.bookId = bookId;
    }


    public String getTittle() {
        return tittle;
    }


    public void setTittle(String tittle) {
        this.tittle = tittle;
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
        return "Book [bookId=" + bookId + ", tittle=" + tittle + ", author=" + author + ", isIssued=" + isIssued + "]";
    }

    
    
}
