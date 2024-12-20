// LibraryManagementSystem
import java.util.Scanner;

public class LibraryManagementSystem
{

    // Initialize books with sample data
    public Book[] books =
            {
                    new Book(111111111, "T1", "A1",12),
                    new Book(122222222, "T2", "A2",12),
            };

    // Initialize scanner for user input
    public Scanner scanner = new Scanner(System.in);

    public static void main(String[] args)
    {
        LibraryManagementSystem system = new LibraryManagementSystem(); // Create system object
        system.run(); // Start the system
    }

    // Main loop of the system, displays menu and handles user input
    public void run()
    {
        // Show the main menu
        System.out.println("Library Management System");
        System.out.println("1. View Book");
        System.out.println("2. Book List");
        System.out.print("Choose an option: ");

        int choice = scanner.nextInt();
        scanner.nextLine(); // Clean up newlines

        // Switch statement to handle the user's menu choice
        switch (choice)
        {
            case 1:
                viewBook();
                break;
            case 2:
                bookList();
                break;
        }
    }

    // View details of a specific book based on ISBN
    public void viewBook()
    {
        System.out.print("Enter the ISBN of the book: ");
        long inputISBN = scanner.nextLong();
        scanner.nextLine();
        boolean found = false;

        // Iterate through the list of books to find a matching ISBN
        for (int i = 0; i < books.length; i++)
        {
            Book book = books[i];
            if (book.getISBN() == inputISBN)
            {
                System.out.println("Book found: " + book);
                found = true;
                break;
            }
        }

        // If no book is found
        if (!found)
        {
            System.out.println("Book with ISBN " + inputISBN + " not found.");
        }
    }

    // Display the list of all available books
    public void bookList()
    {
        if (books.length == 0)  // Check if there are no books in the library
        {
            System.out.println("No books available.");
        }
        else
        {
            System.out.println("\nList of Books:");
            for (int i = 0; i < books.length; i++)  // Loop through books and display each one
            {
                System.out.println(books[i]);  
            }

        }
    }
}
