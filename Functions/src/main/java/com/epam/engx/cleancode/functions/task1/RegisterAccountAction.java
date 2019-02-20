package com.epam.engx.cleancode.functions.task1;

import com.epam.engx.cleancode.functions.task1.thirdpartyjar.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static com.epam.engx.cleancode.functions.task1.thirdpartyjar.CheckStatus.OK;

public class RegisterAccountAction {

    private PasswordChecker passwordChecker;
    private AccountManager accountManager;

    public void register(Account account) {
        validateAccountName(account);
        initiatePasswordValidation(account);
        account.setCreatedDate(new Date());
        fillAccountAddresses(account);
        accountManager.createNewAccount(account);
    }

    private void validateAccountName(Account account) {
        if (account.getName().length() <= 5){
            throw new WrongAccountNameException();
        }
    }

    private void initiatePasswordValidation(Account account) {
        String password = account.getPassword();
        if (password.length() <= 8 && passwordChecker.validate(password) != OK) {
            throw new WrongPasswordException();
        }
    }

    private void fillAccountAddresses(Account account) {
        List<Address> addresses = new ArrayList<>();
        addresses.add(account.getHomeAddress());
        addresses.add(account.getWorkAddress());
        addresses.add(account.getAdditionalAddress());
        account.setAddresses(addresses);
    }

    public void setAccountManager(AccountManager accountManager) {
        this.accountManager = accountManager;
    }

    public void setPasswordChecker(PasswordChecker passwordChecker) {
        this.passwordChecker = passwordChecker;
    }

}
