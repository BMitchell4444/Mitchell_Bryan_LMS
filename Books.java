import java.util.List;
import java.util.Scanner;

/*
   Name: Bryan Mitchell
   Course: CEN 3024C Software Development I 15339
   Date: 9/8/24

   Class name: Books
   Class function: This class contains the functions that allow the user to add books,
   remove books, or list the books in the collection.
 */

public class Books {
    int ID;
    String title;
    String author;

    public Books(int bookID, String bookTitle, String bookAuthor) {
        ID = bookID;
        title = bookTitle;
        author = bookAuthor;
    }

    /*
   Method name: listBooks
   Method purpose: This method lists the books in the collection.
   Arguments: This method accepts the book list as an argument.
   Return value: None.
    */

    public static void listBooks(List<Books> bookList) {
        for (Books books : bookList) {
            System.out.print(books.ID + " ");
            System.out.println(books.title + " " + books.author);
        }
        System.out.println();
    }

    /*
   Method name: addBook
   Method purpose: This method allows the user to add a book to the collection.
   Arguments: This method accepts the book list as an argument.
   Return value: None.
    */

    public static void addBook(List<Books> bookList) {
        int bookID;
        String bookTitle;
        String bookAuthor;
        Scanner scan = new Scanner(System.in);

        System.out.print("Enter the book's ID number: ");
        bookID = Integer.parseInt(scan.nextLine());

        System.out.println("\n");
        System.out.print("Enter the book's title: ");
        bookTitle = scan.nextLine();

        System.out.print("\n");
        System.out.print("Enter the book's author: ");
        bookAuthor = scan.nextLine();

        Books newBook = new Books(bookID, bookTitle, bookAuthor);

        bookList.add(newBook);

    }

    /*
   Method name: removeBook
   Method purpose: This method allows the user to enter the ID number of the book they want removed.
   Arguments: This method accepts the book list as an argument.
   Return value: None.
    */

    public static void removeBook(List<Books> bookList) {
        int bookID;
        int i;
        int found = 0;
        Scanner scan = new Scanner(System.in);

        System.out.print("Enter the ID number of the book to be removed: ");
        bookID = scan.nextInt();

        for(i = 0; i < bookList.size() && found == 0; i++) {
            int listID;
            listID = bookList.get(i).ID;

            if(listID == bookID) {
                bookList.remove(i);
                found = 1;
                System.out.println("Removed book");
            }
        }
        if (found == 0) {
            System.out.println("Book not found.");
        }

    }

}
