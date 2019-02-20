package com.epam.engx.cleancode.comments.task1;

import com.epam.engx.cleancode.comments.task1.thirdpartyjar.InvalidInputException;

public class MortgageInstallmentCalculator {

    private final static double ONE_HUNDRED = 100.0;
    private final static double MONTH_IN_YEAR = 12;

    /**
     * @return monthly payment amount
     */
    public static double calculateMonthlyPayment(int principalAmount, int yearlyMortgageTerm, double interestRate) {

        checkParametersForNegativeValue(principalAmount, yearlyMortgageTerm, interestRate);

        // Convert interest rate into a decimal - eg. 6.5% = 0.065
        interestRate /= ONE_HUNDRED;

        double monthlyMortgageTerm = convertYearlyTermInMonthly(yearlyMortgageTerm);

        if (interestRate == 0) return principalAmount / monthlyMortgageTerm;

        double monthlyRate = convertInterestRateInMonthlyRate(interestRate);

        return calculate(principalAmount, monthlyRate, monthlyMortgageTerm);
    }

    private static void checkParametersForNegativeValue(int principalAmount, int yearlyMortgageTerm, double interestRate) {
        if (principalAmount < 0 || yearlyMortgageTerm <= 0 || interestRate < 0) {
            throw new InvalidInputException("Negative values are not allowed");
        }
    }

    private static double convertYearlyTermInMonthly(double yearlyMortgageTerm) {
        return yearlyMortgageTerm * MONTH_IN_YEAR;
    }

    private static double convertInterestRateInMonthlyRate(double interestRate) {
        return interestRate / MONTH_IN_YEAR;
    }

    private static double calculate(int principalAmount, double monthlyRate, double monthlyMortgageTerm) {
        // the Math.pow() method is used to calculate values raised to a power
        return (principalAmount * monthlyRate) / (1 - Math.pow(1 + monthlyRate, - monthlyMortgageTerm));
    }
}
