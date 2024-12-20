// LibraryManagementSystem
import java.util.Scanner;

public class LibraryManagementSystem
{
    // Initialize books with sample data
    public Book[] books =
            {
            new Book(111111111, "T1", "A1",12),
            new Book(122222222, "T2", "A2",12)
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
        while (true)
        {
            // Show main menu
            System.out.println("Library Management System");
            System.out.println("1. Search Book");
            System.out.println("2. Book List");
            System.out.println("3. Add Book");
            System.out.println("4. Edit Book");
            System.out.println("5. Delete Book");
            System.out.println("6. Exit system");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Clean up newlines

            // Switch statement to handle the user's menu choice
            switch (choice)
            {
                case 1:
                    searchBook();
                    break;
                case 2:
                    bookList();
                    break;
                case 3:
                    addBook();
                    break;
                case 4:
                    editBook();
                    break;
                case 5:
                    deleteBook();
                    break;
                case 6:
                    System.out.println("Exiting system. Goodbye!");
                    return;
                default:
                    System.out.println("Invalid option. Please try again."); // Process invalid input
            }
            System.out.println("----------------------");
        }
    }

    // Search books
    public void searchBook()
    {
        System.out.print("Enter the ISBN of the book: ");
        long inputISBN = scanner.nextLong();
        scanner.nextLine();
        boolean found = false;

        // Iterate through the list of books to find a matching ISBN
        for (int i = 0; i < books.length; i++)
        {
            if (books[i].getISBN() == inputISBN)
            {
                System.out.println("Book found: " + books[i]);
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
        if (books.length == 0) // Check if there are no books in the library
        {
            System.out.println("No books available.");
        }
        else
        {
            System.out.println("\nList of Books:");
            for (int i = 0; i < books.length; i++) // Loop through books and display each one
            {
                System.out.println(books[i]);
            }

        }
    }

    // Add a new book to the system
    public void addBook()
    {
        System.out.print("Enter Book ISBN: ");
        long ISBN = scanner.nextLong();
        scanner.nextLine();

        System.out.print("Enter Book Title: ");
        String title = scanner.nextLine();

        System.out.print("Enter Book Author: ");
        String author = scanner.nextLine();

        System.out.print("Enter Book Price: ");
        int price = scanner.nextInt();


        // Verify input data
        if (title.isEmpty() || author.isEmpty())
        {
            System.out.println("Invalid input. Title and Author cannot be empty.");
            return;
        }

        // Create a new array with space for one additional book
        Book[] newBooks = new Book[books.length + 1];

        // Copy elements from the old array to the new array
        for (int i = 0; i < books.length; i++)
        {
            newBooks[i] = books[i];
        }

        // Add the new book
        newBooks[books.length] = new Book(ISBN, title, author,price);

        // Update the original array
        books = newBooks;
        System.out.println("Successfully added book!");
    }

    // Edit the details of an existing book
    public void editBook()
    {
        System.out.print("Enter Book ISBN to edit: ");
        long ISBN = scanner.nextLong();
        scanner.nextLine();

        // Find the book by ISBN
        for (int i = 0; i < books.length; i++)
        {
            if (books[i].getISBN() == ISBN)
            {

                // Allow user to modify book details
                System.out.print("Enter new ISBN: ");
                long newISBN = scanner.nextLong();
                scanner.nextLine();
                books[i].setISBN(newISBN);

                System.out.print("Enter new title: ");
                String newTitle = scanner.nextLine();
                if (!newTitle.isEmpty())
                {
                    books[i].setTitle(newTitle);
                }

                System.out.print("Enter new author: ");
                String newAuthor = scanner.nextLine();
                if (!newAuthor.isEmpty())
                {
                    books[i].setAuthor(newAuthor);
                }

                System.out.print("Enter new price:");
                int newPrice = scanner.nextInt();
                books[i].setPrice(newPrice);

                System.out.println("Book updated successfully!");
                return;
            }
        }

        // If no book is found with the given ISBN
        System.out.println("Book not found.");
    }

    // Delete Books
    public void deleteBook()
    {
        System.out.print("Enter Book ISBN to delete: ");
        long ISBN = scanner.nextLong();
        scanner.nextLine();

        // Check if the book exist
        boolean found = false;
        int deleteIndex = -1;

        // Find specific book to delete
        for (int i = 0; i < books.length; i++)
        {
            if (books[i].getISBN() == ISBN)
            {
                found = true;
                deleteIndex = i; // Find the book and record its index
                break;
            }
        }

        if (found)
        {
            // Create a new array with a size reduced by 1
            Book[] newBooks = new Book[books.length - 1];

            // Copy some of the elements before deletion to a new array
            for (int i = 0, j = 0; i < books.length; i++)
            {
                if (i != deleteIndex)
                {
                    newBooks[j] = books[i];  // Skip the books want to delete and copy the rest
                    j++;
                }
            }

            books = newBooks; // Update book array
            System.out.println("Book with ISBN " + ISBN + " deleted successfully!");
        }
        else
        {
            System.out.println("Book with ISBN " + ISBN + " not found.");
        }
    }
}
