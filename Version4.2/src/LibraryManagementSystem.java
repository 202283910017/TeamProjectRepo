// LibraryManagementSystem
import java.util.Scanner;

public class LibraryManagementSystem
{
    // Initialize books with sample data
    public Book[] books =
            {
                    new Book(1111111, "T1", "A1",12),
                    new Book(2222222, "T2", "A2",10),
                    new Book(3333333, "T3", "A3",8)
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
        System.out.println("Library Management System");
        System.out.println("Choose the color of the menu (1-7):");
        System.out.println("1. Red");
        System.out.println("2. Green");
        System.out.println("3. Yellow");
        System.out.println("4. Blue");
        System.out.println("5. Magenta");
        System.out.println("6. Cyan");
        System.out.println("7. White");

        int colorChoice = getValidIntInput("Choose a color between 1-7: ", 1, 7);
        String chosenColor = MenuColor.getColorByChoice(colorChoice);


        while (true)
        {
            // Show main menu
            System.out.println(chosenColor + "1. Search Book");
            System.out.println("2. Search Book (Vaguely match author or title)");
            System.out.println("3. Book List");
            System.out.println("4. Add Book");
            System.out.println("5. Edit Book");
            System.out.println("6. Delete Book");
            System.out.println("7. Find Highest Price Book");
            System.out.println("8. Find Lowest Price Book");
            System.out.println("9. Total Price of All Books");
            System.out.println("10. Exit System");
            System.out.println(MenuColor.RESET);


            int choice = getValidIntInput("Choose an option between 1-10: ", 1, 10);

            // Switch statement to handle the user's menu choice
            switch (choice)
            {
                case 1:
                    searchBook();
                    break;
                case 2:
                    searchBookAT();
                    break;
                case 3:
                    bookList();
                    break;
                case 4:
                    addBook();
                    break;
                case 5:
                    editBook();
                    break;
                case 6:
                    deleteBook();
                    break;
                case 7:
                    findHighestPriceBook();
                    break;
                case 8:
                    findLowestPriceBook();
                    break;
                case 9:
                    totalPriceOfBooks();
                    break;
                case 10:
                    System.out.println("Exiting system. Goodbye!");
                    return;
                default:
                    System.out.println("Invalid option. Please try again."); // Process invalid input
            }
            System.out.println("----------------------");
        }
    }


    // Find the book with the highest price
    public void findHighestPriceBook()
    {
        if (books.length == 0)
        {
            System.out.println("No books available.");
            return;
        }

        Book highestPriceBook = books[0];

        // Loop through all books to find the one with the highest price
        for (int i = 1; i < books.length; i++)
        {
            if (books[i].getPrice() > highestPriceBook.getPrice())
            {
                highestPriceBook = books[i];
            }
        }

        System.out.println("The book with the highest price is: " + highestPriceBook);
    }


    // Find the book with the lowest price
    public void findLowestPriceBook()
    {
        if (books.length == 0)
        {
            System.out.println("No books available.");
            return;
        }

        Book lowestPriceBook = books[0];

        // Loop through all books to find the one with the lowest price
        for (int i = 1; i < books.length; i++)
        {
            if (books[i].getPrice() < lowestPriceBook.getPrice())
            {
                lowestPriceBook = books[i];
            }
        }

        System.out.println("The book with the lowest price is: " + lowestPriceBook);
    }

    // Calculate the total price of all books
    public void totalPriceOfBooks()
    {
        int totalPrice = 0;

        // Loop through all books and accumulate their prices
        for (int i = 0; i < books.length; i++)
        {
            totalPrice += books[i].getPrice();
        }

        System.out.println("The total price of all books is: " + totalPrice);
    }

    // Search books
    public void searchBook()
    {
        System.out.print("Enter the ISBN of the book: ");
        long inputISBN = getValidLongInput("Enter valid ISBN: ");

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
            System.out.println("Book with ISBN: " + inputISBN + " not found.");
        }
    }

    // Search for a book by partially matching ISBN
    public void searchBookAT()
    {
        // Prompt the user to enter a partial ISBN for the search
        System.out.print("Enter part of ISBN to search: ");
        String query = scanner.nextLine().toLowerCase();  // Convert the input to lowercase

        boolean found = false; // Flag to check if any book is found

        // Loop through all the books in the array
        for (int i = 0; i < books.length; i++)
        {
            // Convert the ISBN to a string and check if it contains the query
            if (String.valueOf(books[i].getISBN()).contains(query))
            {
                System.out.println("Book found: " + books[i]);
                found = true;
            }
        }

        if (!found)
        {
            System.out.println("No book found with the given partial ISBN.");
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
        long ISBN = getValidLongInput("Enter valid ISBN: ");
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

        // Add new books
       newBooks[books.length] = new Book(ISBN,title,author,price);

        // Update the original array
        books = newBooks;
        System.out.println("Successfully added the book!");
    }

    // Edit the details of an existing book
    public void editBook()
    {
        long ISBN = getValidLongInput("Enter valid ISBN: ");
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
        long ISBN = getValidLongInput("Enter valid ISBN: ");
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
                    newBooks[j] = books[i]; // Skip the books want to delete and copy the rest
                    j++;
                }
            }
            books = newBooks;// Update book array
            System.out.println("Book with ISBN " + ISBN + " deleted successfully!");
        }
        else
        {
            System.out.println("Book with ISBN " + ISBN + " not found.");
        }
    }


    // Get a valid integer input within the specified range
    public int getValidIntInput(String prompt, int min, int max)
    {
        int input ; // Initialize input, meaning no valid input received yet
        while (true)
        {
            System.out.print(prompt);

            if (scanner.hasNextInt()) // Check if the input is a valid integer
            {
                input = scanner.nextInt();
                scanner.nextLine();  // Consume the newline character left by nextInt()

                // Check if the input is within the specified range
                if (input >= min && input <= max)
                {
                    break;
                }
                else
                {
                    System.out.println("Invalid input. Please enter a number between " + min + " and " + max + ".");
                }
            }
            else
            {
                // If the input is not a valid integer, prompt the user to try again
                System.out.println("Invalid input. Please enter a valid number between " + min + " and " + max + ".");
                scanner.nextLine(); // Consume the invalid input
            }
        }
        return input;
    }


    // Get a valid long input
    public long getValidLongInput(String prompt)
    {
        long input ;  // Initialize input, meaning no valid input received yet
        while (true)
        {
            System.out.print(prompt);

            // Check if the next input is a valid long
            if (scanner.hasNextLong())
            {
                input = scanner.nextLong();
                break;
            }
            else
            {
                System.out.println("Invalid input. Please enter a valid number.");
            }
            scanner.nextLine();
        }
        return input;
    }
}
