package lv.javaguru.junit.workshop.section0.fizzbuzz;

import lv.javaguru.junit.workshop.section0.FizzBuzz;

public class FizzBuzzImpl implements FizzBuzz {

    public String calculate(int number) {
        if (number % 15 == 0) {
            return "FizzBuzz";
        }
        if (number % 3 == 0) {
            return "Fizz";
        }
        if (number % 5 == 0) {
            return "Buzz";
        }
        return "" + number;
    }

}
