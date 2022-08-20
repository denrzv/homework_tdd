package io.github.denrzv;

public class Main {
    public static void main(String[] args) {
        int months = 36;
        double loan = 1_000_000;
        double interest = 0.12;

        CreditCalculator calculator = new CreditCalculatorImpl();
        System.out.println("Ежемесячный платёж: " + calculator.getMonthlyPayment(months, loan, interest));
        System.out.println("Общая сумма возврата в банк: " + calculator.getLoanTotal(months, loan, interest));
        System.out.println("Ежемесячный платёж: " + calculator.getInterestTotal(months, loan, interest));
    }
}