package lv.javaguru.junit.workshop.section1;

import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentMatcher;
import org.mockito.InOrder;
import org.mockito.Mockito;

import static org.junit.Assert.assertEquals;

public class HumanTaxCalculatorImplTest {

    private TaxRateDB taxRateDB;
    private EmailSender emailSender;
    private HumanTaxCalculator calculator;

    @Before
    public void init() {
        taxRateDB = Mockito.mock(TaxRateDB.class);
        emailSender = Mockito.mock(EmailSender.class);
        calculator = new HumanTaxCalculatorImpl(taxRateDB, emailSender);
    }

    @Test
    public void shouldReturnZeroIfIncomeIsZero() {
        TaxRate taxRate1 = new TaxRate(1900, 0.25, 0.40);
        Mockito.when(taxRateDB.getTaxRate(1900)).thenReturn(taxRate1);

        double tax = calculator.calculateTax(0.0, 1900);
        assertEquals(tax, 0.0, 0.00000001);
        Mockito.verifyZeroInteractions(emailSender);
    }

    @Test
    public void shouldReturn25ProcIfIncomeIsLessThen20k() {
        TaxRate taxRate1 = new TaxRate(1900, 0.25, 0.40);
        Mockito.when(taxRateDB.getTaxRate(1900)).thenReturn(taxRate1);

        double tax = calculator.calculateTax(10000.0, 1900);
        assertEquals(tax, 2500.0, 0.00000001);
    }

    @Test
    public void shouldReturnCorrectTaxIfIncomeMoreThen20k() {
        TaxRate taxRate1 = new TaxRate(1900, 0.25, 0.40);
        Mockito.when(taxRateDB.getTaxRate(1900)).thenReturn(taxRate1);

        double tax = calculator.calculateTax(30000.0, 1900);
        assertEquals(tax, 9000.0, 0.00000001);
        Mockito.verify(emailSender).sendEmail(Mockito.any(IncomeInfo.class));

        Mockito.verify(emailSender).sendEmail(
                Mockito.argThat(new IncomeInfoMatcher(1900)));

        InOrder inOrder = Mockito.inOrder(taxRateDB, emailSender);
        inOrder.verify(taxRateDB).getTaxRate(1900);
        inOrder.verify(emailSender).sendEmail(Mockito.any(IncomeInfo.class));

    }


    class IncomeInfoMatcher extends ArgumentMatcher<IncomeInfo> {

        private int year;

        public IncomeInfoMatcher(int year) {
            this.year = year;
        }

        @Override
        public boolean matches(Object argument) {
            IncomeInfo incomeInfo = (IncomeInfo) argument;
            return incomeInfo.getYear() == year;
        }
    }

}