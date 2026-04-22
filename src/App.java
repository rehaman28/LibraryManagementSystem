import java.util.Scanner;

import Exception.BookAlreadyIssuedException;
import Exception.BookNotFoundException;
import Exception.ReturnNotAcceptedException;

public class App {
    public static void main(String[] args) throws Exception {
        // System.out.println("Hello, World!");
        libraryService libraryService = new libraryService();
        try (Scanner sc = new Scanner(System.in)) {
            while (true) {
                System.out.println("enter your choise");
                System.out.println("\n1. Add Book");
                System.out.println("2. View Books");
                System.out.println("3. Issue Book");
                System.out.println("4. Return Book");
                System.out.println("5. View Issued or Available Books");
                System.out.println("6. Exit");

                int choice = sc.nextInt();
                switch (choice) {
                    case 1:
                        System.out.print("Enter ID: ");
                        int id = sc.nextInt();
                        sc.nextLine();
                        System.out.print("Enter Title: ");
                        String title = sc.nextLine();
                        System.out.print("Enter Author: ");
                        String author = sc.nextLine();
                        try {
                            libraryService.addBooks((new Book(id, title, author, false)));
                        } catch (IndexOutOfBoundsException e) {
                            System.out.println(e.getMessage());
                        }
                        break;
                    case 2:
                       try {
                         libraryService.viewBooks();
                       } catch (BookNotFoundException e) {
                            System.out.println(e.getMessage());
                       }
                       break;
                    case 3:
                        System.out.print("Enter Book ID: ");
                        int bId = sc.nextInt();
                        System.out.print("Enter User ID: ");
                        int uId = sc.nextInt();
                       try 
                       {
                            libraryService.issueBooks(bId, uId);
                       } catch (BookAlreadyIssuedException e) {
                            System.out.println(e.getMessage());
                       }
                        break;
                    case 4:
                        System.out.print("Enter Book ID: ");
                        int returnid = sc.nextInt();
                        try {
                            libraryService.returnBook(returnid);
                        } catch (ReturnNotAcceptedException e) {
                           System.out.println(e.getMessage());
                        }
                        
                        break;
                    case 5: 
                       try 
                       {
                         libraryService.issuedOrAvailableBooks();
                       }catch (BookNotFoundException e) {
                        System.out.println(e.getMessage());
                       }
                        break;
                    case 6:
                        System.exit(0);

                    default:
                        System.out.println("Invalid Choice");
                }

            }
        }
    }
}
