package lv.javaguru.junit.workshop.section3;

import java.util.List;

public interface PasswordGetter {

    List<String> getLastThreePasswords(String login);

}
