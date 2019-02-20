package com.epam.engx.cleancode.dry.task1;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class InterestCalculator {

    private static final int AGE = 60;
    private static final double INTEREST_PERCENT = 4.5d / 100;
    private static final double SENIOR_PERCENT = 5.5d / 100;
    private static final int BONUS_AGE = 13;


    public BigDecimal calculateInterest(AccountDetails accountDetails) {
        if (isAccountStartedAfterBonusAge(accountDetails)) {
            return getInterest(accountDetails);
        } else {
            return BigDecimal.ZERO;
        }
    }

    private boolean isAccountStartedAfterBonusAge(AccountDetails accountDetails) {
        return getDurationBetweenDates(accountDetails.getBirth(), accountDetails.getStartDate()) > BONUS_AGE;
    }

    private BigDecimal getInterest(AccountDetails accountDetails) {
        int yearDuration = getDurationBetweenDates(accountDetails.getStartDate(), new Date());
        double interest = accountDetails.getBalance().doubleValue() * yearDuration;
        if (AGE <= accountDetails.getAge()) {
            interest = interest * SENIOR_PERCENT;
        } else {
            interest = interest * INTEREST_PERCENT;
        }
        return BigDecimal.valueOf(interest);
    }

    private int getDurationBetweenDates(Date from, Date to) {
        Calendar startCalendar = new GregorianCalendar();
        startCalendar.setTime(from);
        Calendar endCalendar = new GregorianCalendar();
        endCalendar.setTime(to);
        int diffYear = endCalendar.get(Calendar.YEAR) - startCalendar.get(Calendar.YEAR);
        if (endCalendar.get(Calendar.DAY_OF_YEAR) < startCalendar.get(Calendar.DAY_OF_YEAR))
            return diffYear - 1;
        return diffYear;
    }
}
