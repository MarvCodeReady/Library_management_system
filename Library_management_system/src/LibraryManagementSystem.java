// User interface class
import java.util.Date;
import java.util.Scanner;


public class LibraryManagementSystem {
    private static Library library = new Library();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // Implement the main menu
        int choice;
        do {
            System.out.println("Library Management System");
            System.out.println("1. Add Book");
            System.out.println("2. Remove Book");
            System.out.println("3. Register Patron");
            System.out.println("4. Remove Patron");
            System.out.println("5. Checkout Book");
            System.out.println("6. Return Book");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            switch (choice) {
                case 1:
                    addBook();
                    break;
                case 2:
                    removeBook();
                    break;
                case 3:
                    registerPatron();
                    break;
                case 4:
                    removePatron();
                    break;
                case 5:
                    checkoutBook();
                    break;
                case 6:
                    returnBook();
                    break;
                case 7:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 7.");
            }
        } while (choice != 7);
    }

    private static void addBook() {
        // Implement adding a book
        // Prompt user for book details and create a Book object
        System.out.print("Enter ISBN: ");
        String ISBN = scanner.nextLine();
        System.out.print("Enter title: ");
        String title = scanner.nextLine();
        System.out.print("Enter author: ");
        String author = scanner.nextLine();
        System.out.print("Enter genre: ");
        String genre = scanner.nextLine();

        Book book = new Book(ISBN, title, author, genre);
        library.addBook(book);
        System.out.println("Book added successfully.");
    }

    private static void removeBook() {
        // Implement removing a book
        // Prompt user for ISBN of the book to remove
        System.out.print("Enter ISBN of the book to remove: ");
        String ISBN = scanner.nextLine();

        // Find the book in the library and remove it
        boolean found = false;
        for (Book book : library.getBooks()) {
            if (book.getISBN().equals(ISBN)) {
                library.removeBook(book);
                found = true;
                break;
            }
        }

        if (found) {
            System.out.println("Book removed successfully.");
        } else {
            System.out.println("Book not found in the library.");
        }
    }
    
    private static void registerPatron() {
        // Implement registering a patron
        // Prompt user for patron details and create a Patron object
        System.out.print("Enter ID: ");
        int ID = scanner.nextInt();
        scanner.nextLine(); // Consume newline character
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        System.out.print("Enter contact information: ");
        String contactInfo = scanner.nextLine();

        Patron patron = new Patron(ID, name, contactInfo);
        library.registerPatron(patron);
        System.out.println("Patron registered successfully.");
    }

    private static void removePatron() {
        // Implement removing a patron
        // Prompt user for ID of the patron to remove
        System.out.print("Enter ID of the patron to remove: ");
        int ID = scanner.nextInt();
        scanner.nextLine(); // Consume newline character

        // Find the patron in the library and remove them
        boolean found = false;
        for (Patron patron : library.getPatrons()) {
            if (patron.getID() == ID) {
                library.removePatron(patron);
                found = true;
                break;
            }
        }

        if (found) {
            System.out.println("Patron removed successfully.");
        } else {
            System.out.println("Patron not found in the library.");
        }
    }

    private static void checkoutBook() {
        // Implement checking out a book
        // Prompt user for details
        System.out.print("Enter ISBN of the book to checkout: ");
        String ISBN = scanner.nextLine();

        // Find the book in the library
        Book foundBook = null;
        for (Book book : library.getBooks()) {
            if (book.getISBN().equals(ISBN)) {
                foundBook = book;
                break;
            }
        }

        // If the book is found, prompt user for patron details and perform checkout
        if (foundBook != null) {
            System.out.print("Enter patron ID: ");
            int patronID = scanner.nextInt();
            scanner.nextLine(); // Consume newline character
            Patron patron = null;

            // Find the patron in the library
            for (Patron p : library.getPatrons()) {
                if (p.getID() == patronID) {
                    patron = p;
                    break;
                }
            }

            // If the patron is found, perform checkout
            if (patron != null) {
                library.checkoutBook(foundBook, patron, new Date());
            } else {
                System.out.println("Patron with ID " + patronID + " not found.");
            }
        } else {
            System.out.println("Book with ISBN " + ISBN + " not found.");
        }
    }

    private static void returnBook() {
        // Implement returning a book
        // Prompt user for details
        System.out.print("Enter ISBN of the book to return: ");
        String ISBN = scanner.nextLine();

        // Find the book in the library
        Book foundBook = null;
        for (Book book : library.getBooks()) {
            if (book.getISBN().equals(ISBN)) {
                foundBook = book;
                break;
            }
        }

        // If the book is found, perform return
        if (foundBook != null) {
            library.returnBook(foundBook, new Date());
        } else {
            System.out.println("Book with ISBN " + ISBN + " not found.");
        }
    }



}
        		
        		