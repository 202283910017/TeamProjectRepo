import org.junit.Test;
public class LibraryManagementSystemTest

{

    @Test
    public void testLibraryInitialization()
    {
        LibraryManagementSystem libraryManagementSystem = new LibraryManagementSystem();
        libraryManagementSystem.loadBooksFromTxt();

        System.out.println("Library initialized with books:");
        for (int i = 0; i < libraryManagementSystem.books.length; i++)
        {
            System.out.println(libraryManagementSystem.books[i]);
        }
    }

    @Test
    public void testFindHighestPriceBook()
    {
        LibraryManagementSystem libraryManagementSystem = new LibraryManagementSystem();
        libraryManagementSystem.loadBooksFromTxt();

        System.out.println("Finding the highest priced book:");
        libraryManagementSystem.findHighestPriceBook();
    }

    @Test
    public void testFindLowestPriceBook()
    {
        LibraryManagementSystem libraryManagementSystem = new LibraryManagementSystem();
        libraryManagementSystem.loadBooksFromTxt();

        System.out.println("Finding the lowest priced book:");
        libraryManagementSystem.findLowestPriceBook();
    }
}
