package Entities;

public class User {
    private final String login;
    private final String pass;
    private final String money;
    private final String isBlocked;
    public User (String login, String pass, String money, String isBlocked) {
        this.login = login;
        this.pass = pass;
        this.money = money;
        this.isBlocked = isBlocked;

    }
    @Override
    public String toString() {
        return "Login : " + login + ". Password : " + pass + ". Amount on the acc  : " + money + "$. isBlocked : " + isBlocked;
    }

}
