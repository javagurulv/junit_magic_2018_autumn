package lv.javaguru.junit.workshop.section3;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class PasswordValidatorImplTest {

    private PasswordGetter passwordGetter;
    private PasswordValidatorImpl passwordValidator;

    @Before
    public void init() {
        passwordGetter = Mockito.mock(PasswordGetter.class);
        passwordValidator = new PasswordValidatorImpl(passwordGetter);
    }

    @Test
    public void shouldReturnTrueIfNewPasswordIsNotInTheLastThree() {
        List<String> passwords = createPasswordList("pass1", "pass2", "pass3");
        Mockito.when(passwordGetter.getLastThreePasswords("Vasja"))
                .thenReturn(passwords);
        boolean result = passwordValidator.validate("Vasja", "pass4");
        assertTrue(result);
    }

    @Test
    public void shouldReturnFalseIfNewPasswordIsInTheLastThree() {
        List<String> passwords = createPasswordList("pass1", "pass2", "pass3");
        Mockito.when(passwordGetter.getLastThreePasswords("Vasja"))
                .thenReturn(passwords);
        boolean result = passwordValidator.validate("Vasja", "pass3");
        assertFalse(result);
    }

    private List<String> createPasswordList(String pass1, String pass2, String pass3) {
        List<String> passwords = new ArrayList<>();
        passwords.add(pass1);
        passwords.add(pass2);
        passwords.add(pass3);
        return passwords;
    }

}