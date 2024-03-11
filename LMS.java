import java.io.FileNotFoundException;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LMS {
    public static void main(String[] args) throws FileNotFoundException {
        int i = 0;
        List<Books> inventory = new ArrayList<>();

        Scanner scan = new Scanner(System.in);
        System.out.print("Enter the name of the file: ");
        String fileName = scan.nextLine();
        File bookInventory = new File(fileName);

        BookFile.fileRead(bookInventory, inventory);


        while(i != 5) {

            Books.listBooks(inventory);

            System.out.println("Press 1 to add a book.");
            System.out.println("Press 2 to remove a book.");
            System.out.println("Press 3 to check-out a book using its title.");
            System.out.println("Press 4 to check-in a book using its title.");
            System.out.println("Press 5 to save the book collection and exit the program.");
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
                    Books.checkoutTitle(inventory);
                    break;

                case 4:
                    Books.checkInTitle(inventory);
                    break;

                case 5:
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
