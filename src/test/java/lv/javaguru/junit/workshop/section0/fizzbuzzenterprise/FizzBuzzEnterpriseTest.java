package lv.javaguru.junit.workshop.section0.fizzbuzzenterprise;

import lv.javaguru.junit.workshop.section0.fizzbuzzenterprise.rules.DivideBy15Rule;
import lv.javaguru.junit.workshop.section0.fizzbuzzenterprise.rules.DivideBy3Rule;
import lv.javaguru.junit.workshop.section0.fizzbuzzenterprise.rules.DivideBy5Rule;
import lv.javaguru.junit.workshop.section0.fizzbuzzenterprise.rules.NumberRule;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class FizzBuzzEnterpriseTest {

    @Test
    public void divideBy15() {
        FizzBuzzEnterprise fizzBuzz = new FizzBuzzEnterprise(
                new DivideBy15Rule(),
                new NumberRule()
        );
        String result = fizzBuzz.getResult(15);
        assertThat(result, is("FizzBuzz"));
    }

    @Test
    public void divideBy3() {
        FizzBuzzEnterprise fizzBuzz = new FizzBuzzEnterprise(
                new DivideBy15Rule(),
                new DivideBy3Rule(),
                new NumberRule()
        );
        String result = fizzBuzz.getResult(3);
        assertThat(result, is("Fizz"));
    }

    @Test
    public void divideBy5() {
        FizzBuzzEnterprise fizzBuzz = new FizzBuzzEnterprise(
                new DivideBy15Rule(),
                new DivideBy3Rule(),
                new DivideBy5Rule(),
                new NumberRule()
        );
        String result = fizzBuzz.getResult(5);
        assertThat(result, is("Buzz"));
    }

}
