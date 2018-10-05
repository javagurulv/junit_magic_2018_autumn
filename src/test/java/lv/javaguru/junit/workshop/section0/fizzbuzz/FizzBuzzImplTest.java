package lv.javaguru.junit.workshop.section0.fizzbuzz;

import lv.javaguru.junit.workshop.section0.FizzBuzz;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FizzBuzzImplTest {

    private FizzBuzz fizzBuzz = new FizzBuzzImpl();

    @Test
    public void test1() {
        String result = fizzBuzz.calculate(3);
        assertEquals(result, "Fizz");
    }

    @Test
    public void test2() {
        String result = fizzBuzz.calculate(5);
        assertEquals(result, "Buzz");
    }

    @Test
    public void test3() {
        String result = fizzBuzz.calculate(15);
        assertEquals(result, "FizzBuzz");
    }

    @Test
    public void test4() {
        String result = fizzBuzz.calculate(1);
        assertEquals(result, "1");
    }

}