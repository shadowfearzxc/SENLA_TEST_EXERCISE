package Entities;

public class User {
    private final String login;
    private final String pass;
    private String money;

    private final String name;
    private final String surname;
    private final boolean isBlocked;
    public User (String login, String pass, String name, String surname, String money, boolean isBlocked) {
        this.login = login;
        this.pass = pass;
        this.name = name;
        this.surname = surname;
        this.money = money;
        this.isBlocked = isBlocked;

    }
    @Override
    public String toString() {
        return "Login : " + login + ". Password : " + pass + ". Name : " + name + ". Surname : " + surname + ". Amount on the acc  : " + money + "$. isBlocked : " + isBlocked; }

    public String getLogin() {
        return login;
    }
    public String getPassword() {
        return pass;
    }

    public String getName() {return name;}
    public String getSurname(){return surname;}
    public String getMoney() { return money; }
    public void setMoney(String money) { this.money = money; }
    public boolean getIsBlocked() {
        return isBlocked;
    }

}
