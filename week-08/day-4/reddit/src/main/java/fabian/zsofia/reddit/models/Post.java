package fabian.zsofia.reddit.models;


import javax.persistence.*;

@Entity
@Table(name = "reddit_post")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    String title;
    String url;
    long voting;

    public Post() {
        this.voting = 0;
    }

    public Post(String title, String url) {
        this.title = title;
        this.url = url;
        this.voting = 0;
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

    public long getVoting() {
        return voting;
    }

    public void setVoting(long voting) {
        this.voting = voting;
    }

    public long getId() {
        return id;
    }
}
