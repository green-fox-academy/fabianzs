package fabian.zsofia.reddit.models;


import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@Entity
@Table(name = "reddit_post")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String title;
    private String url;
    private long score;
    private String dateOfCreation;

    @ManyToOne (cascade = CascadeType.ALL)
    private User user;

    public Post() {
        this.score = 0;
        this.dateOfCreation = new SimpleDateFormat("yyyy. MMMM dd.").format(new Date());
    }

    public Post(String title, String url, User user) {
        this.title = title;
        this.url = url;
        this.score = 0;
        this.dateOfCreation = new SimpleDateFormat("yyyy. MMMM dd.").format(new Date());
        this.user = user;
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

    public void setDateOfCreation(String dateOfCreation) {
        this.dateOfCreation = dateOfCreation;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
