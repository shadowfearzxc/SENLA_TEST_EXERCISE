package Entities;

public class User {
    private final String login;
    private final String pass;
    private final String money;
    private final boolean isBlocked;
    public User (String login, String pass, String money, boolean isBlocked) {
        this.login = login;
        this.pass = pass;
        this.money = money;
        this.isBlocked = isBlocked;

    }
    @Override
    public String toString() {
        return "Login : " + login + ". Password : " + pass + ". Amount on the acc  : " + money + "$. isBlocked : " + isBlocked;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return pass;
    }

    public String getMoney() {
        return money;
    }

    public String setMoney(String money) {return money;}

    public boolean getIsBlocked() {
        return isBlocked;
    }

}
