package fabian.zsofia.exampleexam.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Random;
import java.util.concurrent.atomic.AtomicLong;

@Entity
public class Alias {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String url;
    private String urlAlias;
    private AtomicLong hitCount;
    private String  secretCode;

    public Alias(String urlAlias, String url) {
        this.urlAlias = urlAlias;
        this.url = url;
        this.hitCount = new AtomicLong(0);
        this.secretCode= String.format("%04d", new Random().nextInt(10000));
    }

    public Alias() {
        this.hitCount = new AtomicLong(0);
        this.secretCode= String.format("%04d", new Random().nextInt(10000));
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUrlAlias() {
        return urlAlias;
    }

    public void setUrlAlias(String urlAlias) {
        this.urlAlias = urlAlias;
    }

    public AtomicLong getHitCount() {
        return hitCount;
    }

    public void setHitCount(AtomicLong hitCount) {
        this.hitCount = hitCount;
    }

    public String getSecretCode() {
        return secretCode;
    }

}
