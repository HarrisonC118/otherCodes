package learn.jsoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * @author: HatcherCheung
 * @Date: 2021/12/20
 * @Description:
 */
public class Jsoup01 {
    public static void main(String[] args) throws Exception {
        Document document = Jsoup.parse(new URL("https://blog.csdn.net/"), 300000);
        document.select("ul.select-option-list");
        System.out.println(document);
    }
}
