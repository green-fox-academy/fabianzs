import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

public class TestFibonacci {

    @Test(expected = IndexOutOfBoundsException.class)
    public void calculateFibonacci_NegativeAsInput_ThrowsException() {
        Fibonacci fibonacci = new Fibonacci();
        fibonacci.calculateFibonacci(-3);
    }

    @Test
    public void calculateFibonacci_ZeroAsInput_ReturnsZero() {
        Fibonacci fibonacci = new Fibonacci();
        assertEquals(0, fibonacci.calculateFibonacci(0));
    }

    @Test
    public void calculateFibonacci_OneAsInput_ReturnsOne() {
        Fibonacci fibonacci = new Fibonacci();
        assertEquals(1, fibonacci.calculateFibonacci(1));
    }

    @Test
    public void calculateFibonacci_TwoAsInput_ReturnsOne() {
        Fibonacci fibonacci = new Fibonacci();
        assertEquals(1, fibonacci.calculateFibonacci(2));
    }

    @Test
    public void calculateFibonacci_RandomNumberAsInput_ReturnsElement() {
        Fibonacci fibonacci = new Fibonacci();
        assertEquals(21, fibonacci.calculateFibonacci(8));
    }
}
