import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

public class TestFibonacci {

    @Test(expected = IndexOutOfBoundsException.class)
    public void calculateFibonacci_NegativeAsInput_ThrowsException() {
        Fibonacci.calculateFibonacci(-3);
    }

    @Test
    public void calculateFibonacci_ZeroAsInput_ReturnsZero() {
        assertEquals(0, Fibonacci.calculateFibonacci(0));
    }

    @Test
    public void calculateFibonacci_OneAsInput_ReturnsOne() {
        assertEquals(1, Fibonacci.calculateFibonacci(1));
    }

    @Test
    public void calculateFibonacci_TwoAsInput_ReturnsOne() {
        assertEquals(1, Fibonacci.calculateFibonacci(2));
    }

    @Test
    public void calculateFibonacci_RandomNumberAsInput_ReturnsElement() {
        assertEquals(21, Fibonacci.calculateFibonacci(8));
    }
}
