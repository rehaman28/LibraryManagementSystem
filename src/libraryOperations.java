import Exception.BookAlreadyIssuedException;
import Exception.BookNotFoundException;
import Exception.ReturnNotAcceptedException;

public interface libraryOperations {

    void addBooks(Book book) throws IndexOutOfBoundsException;
    void viewBooks() throws BookNotFoundException;
    void issuedOrAvailableBooks();
    void issueBooks(int bookId, int userId) throws BookAlreadyIssuedException;
    void returnBook(int bookId) throws ReturnNotAcceptedException ;
}