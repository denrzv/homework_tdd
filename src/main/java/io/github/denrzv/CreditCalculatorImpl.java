package io.github.denrzv;

public class CreditCalculatorImpl implements CreditCalculator {
    @Override
    public double getLoanTotal(int months, double loan, double interest) {
        validValues(months, loan, interest);
        return getMonthlyPayment(months, loan, interest) * months;
    }

    @Override
    public double getMonthlyPayment(int months, double loan, double interest) {
        validValues(months, loan, interest);
        double monthlyInterestRate = interest / 12;
        double monthlyPayment = loan * monthlyInterestRate /
                (1 - 1 / Math.pow(1 + monthlyInterestRate, months));
        return Math.round(monthlyPayment);
    }

    @Override
    public double getInterestTotal(int months, double loan, double interest) {
        validValues(months, loan, interest);
        return getLoanTotal(months, loan, interest) - loan;
    }

    private void validValues(int months, double loan, double interest) {
        if (months <= 0 || loan <= 0 || interest <= 0) {
            throw new IllegalArgumentException("Некорректно заданы аргументы метода");
        }
    }
}
