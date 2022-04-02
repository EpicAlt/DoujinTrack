import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class openFile {
    public static ArrayList<String> readComics(File f) throws FileNotFoundException {
        // Open file
        ArrayList<String>  txtContents = new ArrayList<>();

        Scanner scanner = new Scanner(f);
        while (scanner.hasNextLine()) {
            // Read line
            String line = scanner.nextLine();

            // Check if line has content
            if (!line.equals("")) {
                txtContents.add(line);
            }
        }
        return txtContents;
    }
}
