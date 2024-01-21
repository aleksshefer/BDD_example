package ru.shefer;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

public class AuthInMailTestSuccessfully {
    private final GMailAuth gMailAuth = new GMailAuth();

    private User user;

    @Given("Я нахожусь на странице входа в Gmail")
    public void getLoginPage() {
        Assertions.assertEquals("страница входа", gMailAuth.getLoginPage());
    }

    @When("Я ввожу верные учетные данные и нажимаю “Войти”")

    public void setRightParameters() {
        user = gMailAuth.auth("OK");
        User newUser = new User("user", "user@gmail.com", "8999222111333");
        newUser.setAuthParameter(true);
        Assertions.assertEquals(newUser, user);


    }

    @Then("Я успешно аутентифицирован и перенаправлен на домашнюю страницу Gmail")
    public void getMainPaigeAfterLogin() {
        String mainPage = gMailAuth.getMainPage(user);
        Assertions.assertEquals("страница почты", mainPage);
    }
}
