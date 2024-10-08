import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
   Name: Bryan Mitchell
   Course: CEN 3024C Software Development I 15339
   Date: 9/8/24

   Class name: LMS
   Class function: This class serves as the main class and allows the user to interact with
   the program.
   Main objective: The goal of the program is to read in books from a file,
   add books, remove books, or list the books in the collection.
   When the user is done, the contents of the collection are saved and the program stops.
    */

public class LMS {
    public static void main(String[] args) throws FileNotFoundException {

        Scanner scan = new Scanner(System.in);

        System.out.print("Enter the file path for the input file: ");
        File bookInventory = new File(scan.nextLine());

        int i = 0;

        List<Books> inventory = new ArrayList<>();
        BookFile.fileRead(bookInventory, inventory);

        while(i != 3) {
            Books.listBooks(inventory);


            System.out.println("Press 1 to add a book.");
            System.out.println("Press 2 to remove a book.");
            System.out.println("Press 3 to save the book collection and exit the program.");
            System.out.print("What would you like to do?: ");
            i = scan.nextInt();

            switch (i) {
                case 1:
                    Books.addBook(inventory);
                    break;

                case 2:
                    Books.removeBook(inventory);
                    break;

                case 3:
                    BookFile.fileUpdate(bookInventory, inventory);
                    break;


                default:
                    System.out.println("Invalid input, please try again.");
                    break;
            }
            System.out.println();
        }


    }
}
