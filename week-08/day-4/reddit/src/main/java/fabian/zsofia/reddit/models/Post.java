package fabian.zsofia.reddit.models;


import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Entity
@Table(name = "reddit_post")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    String title;
    String url;
    long score;
    private String dateOfCreation;


    public Post() {
        this.score = 0;
        this.dateOfCreation = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy. MMMM. dd."));
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public long getScore() {
        return score;
    }

    public void setScore(long score) {
        this.score = score;
    }

    public long getId() {
        return id;
    }

    public String getDateOfCreation() {
        return dateOfCreation;
    }
}
