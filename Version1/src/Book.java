// Define Book Class 
public class Book
{
    public long ISBN; // Book ISBN 
    public String title; // Book title
    public String author; // Book author
    public int price; // Book price

    // Constructor to initialize book information
    public Book(long isbn, String title, String author, int price)
    {
        this.ISBN = isbn;
        this.title = title;
        this.author = author;
        this.price = price;
    }

    // Getters for each field
    public long getISBN()
    {
        return ISBN;
    }

    public String getTitle()
    {
        return title;
    }

    public String getAuthor()
    {
        return author;
    }

    public int getPrice()
    {
        return price;
    }

    // Return detailed book information
    public String toString()
    {
        return "ISBN: " + getISBN() + ", Title: " + getTitle() + ", Author: " + getAuthor() + ", Price: " + getPrice();
    }
}
