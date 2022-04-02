import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;

public class scrape {
    public static ArrayList<String> getTags(String url) throws IOException {
        // Get website
        Document doc = Jsoup.connect(url).get();

        // Get tags
        ArrayList<String> newTags = new ArrayList<>();
        Elements div = doc.select("#tags > div:nth-child(3) > span");
        for (Element elm : div.get(0).getElementsByClass("name")) {
            newTags.add(elm.text());
        }

        return newTags;
    }
}
