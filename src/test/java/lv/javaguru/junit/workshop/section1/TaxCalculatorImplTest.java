package lv.javaguru.junit.workshop.section1;

import org.junit.Test;
import org.mockito.ArgumentMatcher;
import org.mockito.InOrder;
import org.mockito.Mockito;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.argThat;

public class TaxCalculatorImplTest {

    private TaxRateFinder taxRateFinder;
    private EmailSender emailSender;

    private double invokeProductionCode(int year, double income) {
        emailSender = Mockito.mock(EmailSender.class);
        taxRateFinder = Mockito.mock(TaxRateFinder.class);
        Mockito.when(taxRateFinder.getTaxRate(year)).thenReturn(0.25);

        TaxCalculatorImpl taxCalculator =
                new TaxCalculatorImpl(taxRateFinder, emailSender);
        return taxCalculator.calculateTax(year, income);
    }

    @Test
    public void shouldSendEmailWhenIncomeIsMoreThen20k() {
        invokeProductionCode(2010, 30000.0);

        InOrder inOrder = Mockito.inOrder(emailSender, taxRateFinder);
        inOrder.verify(emailSender).sendEmail(
                argThat(new EmailInfoMatcher(2010, 30000.0)));
        inOrder.verify(taxRateFinder).getTaxRate(2010);
    }

    class EmailInfoMatcher extends ArgumentMatcher<EmailInfo> {

        private int year;
        private double income;

        public EmailInfoMatcher(int year, double income) {
            this.year = year;
            this.income = income;
        }

        @Override
        public boolean matches(Object argument) {
            EmailInfo emailInfo = (EmailInfo) argument;
            return emailInfo.getIncome() == income
                    && emailInfo.getYear() == year;
        }
    }


    @Test
    public void shouldReturn25PercentOfTaxIfIncomeIsLessThen20k() {
        double tax = invokeProductionCode(2010, 10000.0);
        assertEquals(2500.0, tax, 0.001);
    }

    @Test
    public void shouldReturn25PercentOfTaxIfIncomeIs20k() {
        double tax = invokeProductionCode(2010, 20000.0);
        assertEquals(tax, 5000.0, 0.001);
    }

    @Test
    public void shouldReturnZeroTaxIfIncomeIsZero() {
        double tax = invokeProductionCode(2010, 0.0);
        assertEquals(tax, 0.0, 0.001);
    }

}