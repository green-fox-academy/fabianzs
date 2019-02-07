import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

public class TestSharpie {

    @Test(expected = IllegalArgumentException.class)
    public void useSharpie_NegativeAsInput_ThrowsException() {
        Sharpie sharpie = new Sharpie("orange", 0.8);
        sharpie.use(-4);
    }

    @Test
    public void useSharpie_NormalNumberAsInput_ReturnDecreasedInkAmount() {
        Sharpie sharpie = new Sharpie("orange", 0.8);
        sharpie.use(6);
        assertEquals(88, sharpie.inkAmount, 0.1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void useSharpie_HugeNumberAsInput_ThrowsException() {
        Sharpie sharpie = new Sharpie("orange", 0.8);
        sharpie.use(1000);
    }

    @Test(expected = IllegalArgumentException.class)
    public void useSharpie_ZeroInkAmount_ThrowsException() {
        Sharpie sharpie = new Sharpie("orange", 0.8);
        sharpie.setInkAmount(0);
        sharpie.use(6);
    }

}
