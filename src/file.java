import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class file {
    public static HashMap<String, Integer> read(File f) throws FileNotFoundException {
        // Open file
        HashMap<String, Integer> txtContents = new HashMap<>();

        Scanner scanner = new Scanner(f);
        while (scanner.hasNextLine()) {
            // Read line
            String line = scanner.nextLine();

            // Check if line has content
            if (!line.equals("")) {
                // Split up name and value
                String[] splits = line.split("=");
                String name = splits[0];
                int value = Integer.parseInt(splits[1]);

                txtContents.put(name, value);
            }
        }
        return txtContents;
    }

    public static void save(HashMap<String, Integer> hash, File f) throws IOException {
        String newSave = "";

        for (Map.Entry<String, Integer> str : hash.entrySet()) {
                newSave += str + "\n";
        }

        Files.write(f.toPath(), Collections.singleton(newSave), StandardCharsets.UTF_8);
    }
}
