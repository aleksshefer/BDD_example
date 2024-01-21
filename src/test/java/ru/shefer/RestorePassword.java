package ru.shefer;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

public class RestorePassword {
    private final GMailAuth gMailAuth = new GMailAuth();
    private String sms;

    @When("Я выбираю опцию “Забыли пароль?” и указываю свой номер телефона")
    public void pushRestorePasswordButton() {
        sms = gMailAuth.restorePassword("11111");
        Assertions.assertNotNull(sms);
    }

    @Then("На мой телефон приходит SMS с кодом, который я должен ввести для подтверждения своей личности и начала процесса восстановления пароля.")
    public void getSMS() {
        Assertions.assertEquals("смс для номера 11111", sms);
    }
}
