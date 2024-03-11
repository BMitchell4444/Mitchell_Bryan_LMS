import java.io.*;
import java.util.List;
import java.util.Scanner;
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
        String readGenre;
        String readStatus;
        String readDate;
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
            i++;

            readGenre = readLineArray[i];
            i++;

            readStatus = readLineArray[i];
            i++;

            readDate = readLineArray[i];

            Books readBook = new Books(readID, readTitle, readAuthor, readGenre, readStatus, readDate);
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
                    + "," + bookList.get(i).author + "," + bookList.get(i).genre
                    + "," + bookList.get(i).status +
                    "," + bookList.get(i).dueDate);
        }
        fileOutput.close();
    }
}
