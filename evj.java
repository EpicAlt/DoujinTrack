import java.io.File;
import java.io.IOException;
import java.util.*;


public class evj {
    public static void main(String args[]) throws IOException {
        // Load comics
        File txt = new File("D:\\Games\\Projects\\nh\\src\\assets\\english_comics.txt"); // Replace this with the comics you want to use
        ArrayList<String> comics = openFile.readComics(txt);

        // Go through each comic
        for (String str : comics) {
            try {
                File save = new File("D:\\Games\\Projects\\nh\\src\\newTags.txt"); // Replace this with where you want it to save (file might have to already exist)
                ArrayList<String> tags = scrape.getTags("https://nhentai.net/g/" + str);

                // Open file
                HashMap<String, Integer> f = file.read(save);

                System.out.println("Before: " + f);

                // Add or increase tags
                for (String tag : tags) {
                    // Add number if it is there
                    if (f.containsKey(tag)) {
                        int count = f.get(tag);
                        f.put(tag, count+1);
                        System.out.println("Added one to " + tag);
                    } else {
                        f.put(tag, 1);
                        System.out.println("Added new tag " + tag);
                    }
                }

                System.out.println("After: " + f);

                file.save(f, save);
            } catch (Exception e) {e.printStackTrace();}
        }
    }
}
