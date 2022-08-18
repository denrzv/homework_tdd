import io.github.denrzv.CreditCalculator;
import io.github.denrzv.Main;
import org.junit.jupiter.api.*;

public class TestCreditCalculator {
    final double LOAN = 100_000;
    final double ANNUAL_INTEREST_RATE = 0.12;
    final int MONTHS = 1;

    @Test
    @DisplayName("Успешный расчёт ежемесячного платежа")
    public void testGetMonthlyPayment() {
        CreditCalculator calculator = null;
        double monthlyPayment = LOAN + LOAN * ANNUAL_INTEREST_RATE / 12;
        System.out.println(monthlyPayment);
        var monthlyPaymentCalculated = calculator.getMonthlyPayment(MONTHS, LOAN, ANNUAL_INTEREST_RATE);
        Assertions.assertEquals(monthlyPayment, monthlyPaymentCalculated);
    }

    @Test
    @DisplayName("Успешный расчёт общей суммы возврата в банк")
    public void testGetLoanTotal() {
        CreditCalculator calculator = null;
        double loanTotal = LOAN + LOAN * ANNUAL_INTEREST_RATE / 12 * MONTHS;
        System.out.println(loanTotal);
        var loanTotalCalculated = calculator.getLoanTotal(MONTHS, LOAN, ANNUAL_INTEREST_RATE);
        Assertions.assertEquals(loanTotal, loanTotalCalculated);
    }

    @Test
    @DisplayName("Успешеый расчёт переплаты за весь период")
    public void testGetInterestTotal() {
        CreditCalculator calculator = null;
        double interestTotal = LOAN * ANNUAL_INTEREST_RATE / 12 * MONTHS;
        System.out.println(interestTotal);
        var interestTotalCalculated = calculator.getInterestTotal(MONTHS, LOAN, ANNUAL_INTEREST_RATE);
        Assertions.assertEquals(interestTotal, interestTotalCalculated);
    }
}
