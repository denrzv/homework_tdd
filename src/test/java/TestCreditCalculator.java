import io.github.denrzv.CreditCalculator;
import io.github.denrzv.CreditCalculatorImpl;
import org.junit.jupiter.api.*;

public class TestCreditCalculator {
    final double LOAN = 100_000;
    final double ANNUAL_INTEREST_RATE = 0.12;
    final int MONTHS = 1;

    @Test
    @DisplayName("Успешный расчёт ежемесячного платежа")
    public void testGetMonthlyPayment() {
        CreditCalculator calculator = new CreditCalculatorImpl();
        double monthlyPayment = LOAN + LOAN * ANNUAL_INTEREST_RATE / 12;
        var monthlyPaymentCalculated = calculator.getMonthlyPayment(MONTHS, LOAN, ANNUAL_INTEREST_RATE);
        Assertions.assertEquals(monthlyPayment, monthlyPaymentCalculated);
    }

    @Test
    @DisplayName("Успешный расчёт общей суммы возврата в банк")
    public void testGetLoanTotal() {
        CreditCalculator calculator = new CreditCalculatorImpl();
        double loanTotal = LOAN + LOAN * ANNUAL_INTEREST_RATE / 12 * MONTHS;
        var loanTotalCalculated = calculator.getLoanTotal(MONTHS, LOAN, ANNUAL_INTEREST_RATE);
        Assertions.assertEquals(loanTotal, loanTotalCalculated);
    }

    @Test
    @DisplayName("Успешеый расчёт переплаты за весь период")
    public void testGetInterestTotal() {
        CreditCalculator calculator = new CreditCalculatorImpl();
        double interestTotal = LOAN * ANNUAL_INTEREST_RATE / 12 * MONTHS;
        var interestTotalCalculated = calculator.getInterestTotal(MONTHS, LOAN, ANNUAL_INTEREST_RATE);
        Assertions.assertEquals(interestTotal, interestTotalCalculated);
    }

    @Test
    @DisplayName("Тест на невалидные значения")
    public void shouldThrowException() {
        CreditCalculator calculator = new CreditCalculatorImpl();
        int months = 0;
        double loan = 0;
        double interestRate = -1;
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> calculator.getInterestTotal(months, loan, interestRate));
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> calculator.getLoanTotal(months, loan, interestRate));
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> calculator.getLoanTotal(months, loan, interestRate));
    }
}
