package lv.javaguru.junit.workshop.section0.fizzbuzzenterprise.rules;

import lv.javaguru.junit.workshop.section0.fizzbuzzenterprise.FizzBuzzRule;

public class DivideBy15Rule implements FizzBuzzRule {

    @Override
    public boolean isSatisfied(int number) {
        return number % 15 == 0;
    }

    @Override
    public String produceResult(int number) {
        return "FizzBuzz";
    }
}
