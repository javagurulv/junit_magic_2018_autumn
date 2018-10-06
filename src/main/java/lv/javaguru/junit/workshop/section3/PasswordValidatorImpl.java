package lv.javaguru.junit.workshop.section3;

import java.util.List;

class PasswordValidatorImpl implements PasswordValidator {

    private PasswordGetter passwordGetter;

    public PasswordValidatorImpl(PasswordGetter passwordGetter) {
        this.passwordGetter = passwordGetter;
    }

    @Override
    public boolean validate(String login, String password) {
        // TODO implement 1 rule
        // TODO implement 2 rule

        List<String> lastThreePasswords = passwordGetter.getLastThreePasswords(login);
        return !lastThreePasswords.contains(password);
    }


}
