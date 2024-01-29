import java.io.*;
import java.util.List;
import java.util.Scanner;

/*
   Name: Bryan Mitchell
   Course: CEN 3024C Software Development I 24667
   Date: 1/28/24

   Class name: BookFile
   Class function: This class contains the functions that handle file reading
   and writing.
 */

public class BookFile {

    /*
   Method name: fileRead
   Method purpose: This method reads the book collection from the input file.
   Arguments: This method accepts the input file and the book list as arguments.
   Return value: None.
    */

    public static void fileRead(File inventoryFile, List<Books>bookList) throws FileNotFoundException {
        int readID;
        String readTitle;
        String readAuthor;
        Scanner scan = new Scanner(inventoryFile);

        String readLine;

        while(scan.hasNextLine()) {
            readLine = scan.nextLine();

            String[] readLineArray = readLine.split(",");

            int i = 0;

            readID = Integer.parseInt(readLineArray[i]);
            i++;
            readTitle = readLineArray[i];
            i++;
            readAuthor = readLineArray[i];

            Books readBook = new Books(readID, readTitle, readAuthor);
            bookList.add(readBook);
        }


    }

    /*
   Method name: fileUpdate
   Method purpose: This method copies the book collection to the input file.
   Arguments: This method accepts the input file and the book list as arguments.
   Return value: None.
    */

    public static void fileUpdate(File inventoryFile, List<Books>bookList) throws FileNotFoundException {
        PrintWriter fileOutput = new PrintWriter(inventoryFile);

        for (int i = 0; i < bookList.size(); i++) {
            fileOutput.println(bookList.get(i).ID + "," + bookList.get(i).title
            + "," + bookList.get(i).author);
        }
        fileOutput.close();
    }
}