import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;
public class Books {
    int ID;
    String title;
    String author;
    String genre;
    String status;
    String dueDate;

    public Books(int bookID, String bookTitle, String bookAuthor, String bookGenre,
                 String bookStatus, String bookDate) {
        ID = bookID;
        title = bookTitle;
        author = bookAuthor;
        genre = bookGenre;
        status = bookStatus;
        dueDate = bookDate;
    }

    public Books() {

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
            System.out.print(books.title + " " + books.author + " ");
            System.out.println(books.genre + " " + books.status + " " + books.dueDate);
        }
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
        String bookGenre;
        String bookStatus;
        String bookDate;
        Scanner scan = new Scanner(System.in);

        System.out.print("Enter the book's ID number: ");
        bookID = Integer.parseInt(scan.nextLine());

        System.out.println("\n");
        System.out.print("Enter the book's title: ");
        bookTitle = scan.nextLine();

        System.out.print("\n");
        System.out.print("Enter the book's author: ");
        bookAuthor = scan.nextLine();

        System.out.print("\n");
        System.out.print("Enter the book's genre: ");
        bookGenre = scan.nextLine();

        bookStatus = "No";
        bookDate = null;

        Books newBook = new Books(bookID, bookTitle, bookAuthor, bookGenre,
                bookStatus, bookDate);

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

    public static void checkoutID(List<Books> bookList) {
        int checkID;
        int i;
        int found = 0;
        Scanner scan = new Scanner(System.in);

        System.out.print("Enter the ID number of the book to be checked-out: ");
        checkID = scan.nextInt();

        for(i = 0; i < bookList.size() && found == 0; i++) {
            int listID;
            listID = bookList.get(i).ID;

            if(listID == checkID && Objects.equals(bookList.get(i).status, "No")) {
                Books checkedBook = new Books();

                LocalDate currentDate = LocalDate.now();
                LocalDate due = currentDate.plusDays(28);
                DateTimeFormatter formatPattern = DateTimeFormatter.ofPattern("MM-dd-yyyy");
                String formatDue = due.format(formatPattern);

                checkedBook.ID = bookList.get(i).ID;
                checkedBook.title = bookList.get(i).title;
                checkedBook.author = bookList.get(i).author;
                checkedBook.genre = bookList.get(i).genre;
                checkedBook.status = "Yes";
                checkedBook.dueDate = formatDue;

                bookList.set(i, checkedBook);

                found = 1;
                System.out.println("Checked-Out book");
            }

            if(listID == checkID && Objects.equals(bookList.get(i).status, "Yes")) {
                System.out.println("Book Already checked out.");
            }

        }
        if (found == 0) {
            System.out.println("Book not found.");
        }

    }

    public static void checkoutTitle(List<Books> bookList) {
        String checkTitle;
        int i;
        int copyCount = 0;
        int freeCopy = -1;
        int freeCopyCount = 0;
        String listTitle;

        Scanner scan = new Scanner(System.in);

        System.out.print("Enter the title of the book to be checked-out: ");
        checkTitle = scan.nextLine();
        System.out.println("\n");

        for(i = 0; i < bookList.size(); i++) {
            listTitle = bookList.get(i).title;

            if(Objects.equals(listTitle, checkTitle)) {
                copyCount++;
                if(Objects.equals(bookList.get(i).status, "No")) {
                    freeCopy = i;
                    freeCopyCount++;
                }
            }

        }
        if(freeCopy == -1 && copyCount > 0) {
            System.out.println("All available books checked-out");
        }

if(freeCopyCount == 1) {

            Books checkedBook = new Books();

            LocalDate currentDate = LocalDate.now();
            LocalDate due = currentDate.plusDays(28);
            DateTimeFormatter formatPattern = DateTimeFormatter.ofPattern("MM-dd-yyyy");
            String formatDue = due.format(formatPattern);

            checkedBook.ID = bookList.get(freeCopy).ID;
            checkedBook.title = bookList.get(freeCopy).title;
            checkedBook.author = bookList.get(freeCopy).author;
            checkedBook.genre = bookList.get(freeCopy).genre;
            checkedBook.status = "Yes";
            checkedBook.dueDate = formatDue;

            bookList.set(freeCopy, checkedBook);

            System.out.println("Checked-Out book");
        }

if(freeCopyCount > 1) {
    System.out.println("Multiple checked-in copies found.");
    Books.checkoutID(bookList);
}


        if (copyCount == 0) {
            System.out.println("Book not found.");
        }

    }

    public static void checkInTitle(List<Books> bookList) {
        String checkTitle;
        int i;
        int copyCount = 0;
        int outCopy = -1;
        int outCopyCount = 0;
        String listTitle;

        Scanner scan = new Scanner(System.in);

        System.out.print("Enter the title of the book to be checked-in: ");
        checkTitle = scan.nextLine();
        System.out.println("\n");

        for(i = 0; i < bookList.size(); i++) {
            listTitle = bookList.get(i).title;

            if(Objects.equals(listTitle, checkTitle)) {
                copyCount++;
                if(Objects.equals(bookList.get(i).status, "Yes")) {
                    outCopy = i;
                    outCopyCount++;
                }
            }

        }

        if(outCopy == -1 && copyCount > 0) {
            System.out.println("All available books checked-in");
        }

        if(outCopyCount == 1) {

            Books checkedBook = new Books();


            checkedBook.ID = bookList.get(outCopy).ID;
            checkedBook.title = bookList.get(outCopy).title;
            checkedBook.author = bookList.get(outCopy).author;
            checkedBook.genre = bookList.get(outCopy).genre;
            checkedBook.status = "No";
            checkedBook.dueDate = null;

            bookList.set(outCopy, checkedBook);

            System.out.println("Checked-In book");
        }

        if(outCopyCount > 1) {
            System.out.println("Multiple checked-out copies found.");
            Books.checkInID(bookList);
        }


        if (copyCount == 0) {
            System.out.println("Book not found.");
        }


    }

    public static void checkInID(List<Books> bookList) {
        int checkID;
        int i;
        int found = 0;
        Scanner scan = new Scanner(System.in);

        System.out.print("Enter the ID number of the book to be checked-in: ");
        checkID = scan.nextInt();

        for(i = 0; i < bookList.size() && found == 0; i++) {
            int listID;
            listID = bookList.get(i).ID;

            if(listID == checkID && Objects.equals(bookList.get(i).status, "Yes")) {
                Books checkedBook = new Books();


                checkedBook.ID = bookList.get(i).ID;
                checkedBook.title = bookList.get(i).title;
                checkedBook.author = bookList.get(i).author;
                checkedBook.genre = bookList.get(i).genre;
                checkedBook.status = "No";
                checkedBook.dueDate = null;

                bookList.set(i, checkedBook);

                found = 1;
                System.out.println("Checked-in book");
            }

            if(listID == checkID && Objects.equals(bookList.get(i).status, "No")) {
                System.out.println("Book already checked in.");
            }

        }
        if (found == 0) {
            System.out.println("Book not found.");
        }

    }

}
