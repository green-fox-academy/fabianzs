package fabian.zsofia.hellobeanworld;

import fabian.zsofia.hellobeanworld.models.MyColor;
import fabian.zsofia.hellobeanworld.models.Printer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HellobeanworldApplication implements CommandLineRunner {

    private MyColor color;

    @Autowired
    public HellobeanworldApplication(@Qualifier("red") MyColor color) {
        this.color = color;
    }

    public static void main(String[] args) {
        SpringApplication.run(HellobeanworldApplication.class, args);

    }

    @Override
    public void run(String... args) throws Exception {
        color.printcolor();
    }
}
