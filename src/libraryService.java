
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import Exception.BookAlreadyIssuedException;
import Exception.BookNotFoundException;
import Exception.ReturnNotAcceptedException;

public class libraryService implements libraryOperations {
    
    private List<Book> bookList = new ArrayList<>();
    private Map<Integer,Integer> issuedBooks = new HashMap<>();
    private Integer Max_storage = 7;

    //Key- BookId;
    //Value- UserId;

    public libraryService() {
        bookList.add(new Book(101, "Clean Code", "Robert Martin", false));
        bookList.add(new Book(102, "Effective Java", " Joshua Bloch", true));
        bookList.add(new Book(103, "Spring in Action", " Craig Walls", false));
        bookList.add(new Book(104, "Microservices Patterns", " Chris Richardson", false));
    }

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
            throw new IndexOutOfBoundsException("Books Index is Full , can't add new one");            
        }
        
    }
    //Find Book Method  need to be implemented
    public void findBook(int id) throws BookNotFoundException {
        Optional<Book> book = bookList.stream().filter(b -> b.getBookId() == id).findFirst();
        Book foundBook = book.orElseThrow(() -> new BookNotFoundException("Book with ID " + id + " not found"));
        System.out.println("Book Found: " + foundBook.getTittle());
    }

    public void viewBooks() throws BookNotFoundException
    {
        if(!bookList.isEmpty())
        {
            bookList.forEach((b) -> System.out.println(b.getBookId() + " " + b.getTittle()));
        }
        else
            throw new BookNotFoundException(" Book are Empty");
    }

    public void issuedOrAvailableBooks() throws BookNotFoundException
    {
        if(bookList.isEmpty()) {
            throw new BookNotFoundException("No books available");
        }
        else
        {
            bookList.forEach(entry-> System.out.println("Book:" + entry.getTittle() +(entry.isIssued()?" (Issued) ": " (Available)")));
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
        }
        throw new BookAlreadyIssuedException("Book not Available to issue");
    }

    //return books
    public void returnBook(int bookId) throws ReturnNotAcceptedException
    {
        for( Book book: bookList){
            if( book.getBookId() == bookId && book.isIssued())
            {
                book.setIssued(false);
                issuedBooks.remove(bookId);
                System.out.println("Book returned Sucessfully");
                return;
            }
        }
        throw new ReturnNotAcceptedException("Book Not Found or not issued");
    }
}
