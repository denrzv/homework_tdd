package io.github.denrzv;

public interface CreditCalculator {
    double getLoanTotal(int months, double loan, double interest);
    double getMonthlyPayment(int months, double loan, double interest);
    double getInterestTotal(int months, double loan, double interest);
}
