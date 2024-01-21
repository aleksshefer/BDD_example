package ru.shefer;

public class GMailAuth {


    public String getLoginPage() {
        return "страница входа";
    }

    public User auth(String authParameters) {
        if (authParameters.equals("OK")) {
            User user = new User("user", "user@gmail.com", "8999222111333");
            user.setAuthParameter(true);
            return user;
        } else {
            return null;
        }
    }

    public String getMainPage(User user) {
        if (user == null) {
            throw new RuntimeException("Ваши учетные данные не верны!");
        }
        if (user.isAuthParameter()) {
            return "страница почты";
        } else {
            return "страница входа";
        }
    }

    public String restorePassword(String phoneNumber) {
        return "смс для номера " + phoneNumber;
    }
}
