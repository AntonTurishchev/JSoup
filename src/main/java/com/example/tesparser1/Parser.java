package main.java.com.example.tesparser1;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Parser {
    public static void main(String[] args) throws IOException {
        List<Post> posts = new ArrayList<Post>();
        Document doc = Jsoup.connect("https://4pda.to/").get();
        System.out.println(doc.title());
        System.out.println("Подключаюсь к основной странице сайта...");
        Elements postTitleElements = doc.getElementsByAttributeValue("itemprop", "url");

        //postTitleElements.forEach(postTitleElement -> System.out.println(postTitleElement.attr("title") + " | " + postTitleElement.attr("href")));

        for (Element postTitleElement : postTitleElements) {
              Post post = new Post();
              Document postItself = Jsoup.connect(postTitleElement.attr("href")).get();
              System.out.println("Собираю данные с " + postTitleElement.attr("href"));
              post.setLink(postTitleElement.attr("href"));
              post.setTitle(postTitleElement.attr("title"));
              post.setDateOfCreate(postTitleElement.getElementsByClass("date").text());

              try {
                  post.setAuthor(postItself.getElementsByClass("name").first().child(0).text());
                  post.setTimeOfCreate(postItself.getElementsByClass("date").first().text());
              } catch (NullPointerException e) {
                  post.setAuthor("Не удалось распарсить автора");
                  post.setDateOfCreate("Не удалось распарсить дату создания статьи");
              }
              posts.add(post);
        }

        posts.forEach(System.out::println);

    }
}

