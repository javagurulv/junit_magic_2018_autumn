package lv.javaguru.junit.workshop.section0.fizzbuzzenterprise.rules;

import lv.javaguru.junit.workshop.section0.fizzbuzzenterprise.FizzBuzzRule;

public class NumberRule implements FizzBuzzRule {

    @Override
    public boolean isSatisfied(int number) {
        return true;
    }

    @Override
    public String produceResult(int number) {
        return "" + number;
    }
}
