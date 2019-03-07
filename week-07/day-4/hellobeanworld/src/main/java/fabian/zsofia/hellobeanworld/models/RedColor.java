package fabian.zsofia.hellobeanworld.models;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

/*@Primary*/
@Service
@Qualifier("red")
public class RedColor implements MyColor {

    Printer printer;

    @Autowired
    public RedColor(Printer printer) {
        this.printer = printer;
    }

    @Override
    public void printcolor() {
        printer.log("It is red in color...");
    }
}
