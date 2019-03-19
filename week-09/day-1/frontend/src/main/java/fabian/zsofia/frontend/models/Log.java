package fabian.zsofia.frontend.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
public class Log {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String createdAt;
    private String endpoint;
    private String data;

    public Log() {
    }

    public Log(String endpoint, String data) {
        this.endpoint = endpoint;
        this.data = data;
        this.createdAt = new SimpleDateFormat("yyyy. MM dd. hh:mm:ss").format(new Date());
    }

    public long getId() {
        return id;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public String getEndpoint() {
        return endpoint;
    }

    public void setEndpoint(String endpoint) {
        this.endpoint = endpoint;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
