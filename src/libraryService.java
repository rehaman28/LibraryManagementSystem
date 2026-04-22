import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Exception.BookAlreadyIssuedException;
import Exception.BookNotFoundException;
import Exception.ReturnNotAcceptedException;

public class libraryService implements libraryOperations {
    
    private List<Book> bookList = new ArrayList<>();
    private Map<Integer,Integer> issuedBooks = new HashMap<>();
    private Integer Max_storage = 7;
    //Key- BookId;
    //Value- UserId;

    // public libraryService() {
    //     bookList.add(new Book(101, "Clean Code", "Robert Martin", false));
    //     bookList.add(new Book(102, "Effective Java", " Joshua Bloch", true));
    //     bookList.add(new Book(103, "Spring in Action", " Craig Walls", false));
    //     bookList.add(new Book(104, "Microservices Patterns", " Chris Richardson", false));
    // }

    public void addBooks(Book book) throws IndexOutOfBoundsException
    {
        if (bookList.size() < Max_storage) 
        {
            bookList.add(book);
            System.out.println("sucessfully Added the book");
            System.out.println("All Books:");
            bookList.stream().forEach(System.out::println);
        }
        else{
            throw new IndexOutOfBoundsException();            
        }
        
    }

    public void viewBooks() throws BookNotFoundException
    {
        if(!bookList.isEmpty())
        {
            bookList.forEach((entry) -> System.out.println(entry.getBookId() + " " + entry.getTittle()));
        }
        else{
            throw new BookNotFoundException(" Book are Empty");
        }
        
    }
    
    public void issuedOrAvailableBooks()
    {
        boolean foundIssued = false;
        for(Book book : bookList){
            if(book.isIssued()) {
                System.out.println("Book: " + book.getTittle() + " (Issued)");
                foundIssued = true;
            }
        }
        if(!foundIssued) {
            System.out.println("No issued books found");
        }
    }

    //Issue Books
    public void issueBooks( int bookId, int userId) throws BookAlreadyIssuedException
    {
        for(Book book : bookList)
        {
            if(book.getBookId()== bookId && !book.isIssued())
            {
                book.setIssued(true);
                issuedBooks.put(bookId, userId);
                System.out.println("Book Issued Succesfully ");
                return;
            }
            else{
                throw new BookAlreadyIssuedException("Book not Available to issue");
            }
        }
    }

    //return books
    public void returnBook(int bookId) throws ReturnNotAcceptedException
    {
        for( Book book: bookList){
            if( book.getBookId() == bookId && book.isIssued())
            {
                book.setIssued(false);
                issuedBooks.remove(bookId);
                System.out.println("Book removed Sucessfully");
                return;
            }
            else{
                throw new ReturnNotAcceptedException("Book Not Found or not issued");
            }
        }
    }
}
