package lv.javaguru.junit.workshop.section0;

public class FizzBuzzImpl implements FizzBuzz{
    @Override
    public String calculate(int number) {
        if (isDevidedBy15(number)) {
            return "FizzBuzz";
        }
        if (isDevidedBy3(number)) {
            return "Fizz";
        }
        if (isDevidedBy5(number)) {
            return "Buzz";
        }
        return "" + number;
    }

    private boolean isDevidedBy5(int number) {
        return number % 5 == 0;
    }

    private boolean isDevidedBy3(int number) {
        return number % 3 == 0;
    }

    private boolean isDevidedBy15(int number) {
        return isDevidedBy3(number) && isDevidedBy5(number);
    }


}
