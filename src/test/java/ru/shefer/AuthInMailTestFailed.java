package ru.shefer;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

public class AuthInMailTestFailed {
    private final GMailAuth gMailAuth = new GMailAuth();
    private User user;

    @When("Я ввожу неверные учетные данные и нажимаю “Войти”")

    public void setRightParameters() {
        user = gMailAuth.auth("NOT OK");
        Assertions.assertNull(user);
    }

    @Then("Я вижу сообщение об ошибке, указывающее на то, что учетные данные неверны")
    public void getMainPaigeAfterLogin() {
        Assertions.assertThrowsExactly(RuntimeException.class, () -> gMailAuth.getMainPage(user));

    }
}
