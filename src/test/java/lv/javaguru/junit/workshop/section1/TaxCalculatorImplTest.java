package lv.javaguru.junit.workshop.section1;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.assertEquals;

public class TaxCalculatorImplTest {

    private EmailSender emailSender;
    private TaxBarrierProvider taxBarrierProvider;
    private TaxCalculator calculator;

    @Before
    public void init() {
        emailSender = Mockito.mock(EmailSender.class);
        taxBarrierProvider = Mockito.mock(TaxBarrierProvider.class);
        Mockito.when(taxBarrierProvider.getBarrier(2017))
                .thenReturn(20000.0);
        Mockito.when(taxBarrierProvider.getBarrier(2018))
                .thenReturn(20000.0);
        calculator = new TaxCalculatorImpl(taxBarrierProvider, emailSender);
    }

    @Test
    public void shouldReturnZeroIfIncomeIsZero() {
        double tax = calculator.calculateTax(2017, 0.0);
        assertEquals(tax, 0.0, 0.001);
    }

    @Test
    public void shouldReturn25PercentTaxIfIncomeLessThen20k() {
        assertEquals(calculator.calculateTax(2018, 10000.0), 2500.0, 0.001);
    }

    @Test
    public void shouldReturn40PercentTaxIfIncomeMoreThen20k() {
        double tax = calculator.calculateTax(2017, 100000.0);
        assertEquals(tax, 37000.0, 0.001);
        Mockito.verify(emailSender).sendEmail(2017, 100000.0);
    }

}