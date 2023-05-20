package main.java.com.example.tesparser1;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter

public class Post {

    private String title;
    private String link;
    private String dateOfCreate;
    private String timeOfCreate;
    private String author;

    @Override
    public String toString() {
        return "Статья: " +
                 title  +
                ", " + link +
                ", " + author +
                ", " + dateOfCreate +
                ", " + timeOfCreate;
    }
}
