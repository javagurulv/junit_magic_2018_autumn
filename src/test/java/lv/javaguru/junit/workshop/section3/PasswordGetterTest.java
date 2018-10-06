package lv.javaguru.junit.workshop.section3;

import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

public class PasswordGetterTest {

    @Test
    public void test1() {
        PasswordGetter passwordGetter = Mockito.mock(PasswordGetter.class);

        List<String> passwords1 = new ArrayList<>();
        passwords1.add("pass1");
        passwords1.add("pass2");
        passwords1.add("pass3");
        Mockito.when(passwordGetter.getLastThreePasswords("Vasja"))
                .thenReturn(passwords1);

    }

}