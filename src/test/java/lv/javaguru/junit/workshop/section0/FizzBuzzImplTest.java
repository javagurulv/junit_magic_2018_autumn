package lv.javaguru.junit.workshop.section0;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FizzBuzzImplTest {

    private FizzBuzzImpl fizzBuzz;

    @Before
    public void init() {
        fizzBuzz = new FizzBuzzImpl();
    }


    @Test
    public void test1() {
        assertEquals("Fizz", fizzBuzz.calculate(3));
    }

    @Test
    public void test2() {
        assertEquals("Buzz", fizzBuzz.calculate(5));
    }

    @Test
    public void test3() {
        assertEquals("FizzBuzz", fizzBuzz.calculate(15));
    }

    @Test
    public void test4() {
        assertEquals("4", fizzBuzz.calculate(4));
    }

    @Test
    public void test5() {
        assertEquals("Fizz", fizzBuzz.calculate(9));
    }

    @Test
    public void test6() {
        assertEquals("Buzz", fizzBuzz.calculate(10));
    }

}