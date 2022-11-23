package org.Main;


import Entities.User;
import FileManaged.ReaderFile;
import FileManaged.StringsParser;
import Functions.Logs;
import Functions.extraFunctions;

import java.io.*;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) throws IOException {
        int limitCashOut = 1000000;
        Scanner console = new Scanner(System.in);

        System.out.println("Welcome, this is the ATM  of Alfa Bank");
        int generalChoice;
        var strings = ReaderFile.sReader();
        var users = StringsParser.parse(strings);
        do {
            System.out.println(extraFunctions.generalFunctions());
            generalChoice = console.nextInt();

            switch (generalChoice) {

                case 1 -> {

                    User curUser = null;
                    while(curUser == null) {
                        System.out.print("Enter your login : "); String login = console.next();
                        System.out.print("Enter your password : "); String pass = console.next();
                        for(var user : users) {
                            if (user.getLogin().equals(login) && user.getPassword().equals(pass)) {



                                curUser = user;
                                if(!curUser.getIsBlocked()) {
                                Logs.logInSuccess(login);
                                int clientChoice;
                                do {

                                    System.out.println("МЕНЮ :");
                                    System.out.println(extraFunctions.clientFunctions());
                                    clientChoice = console.nextInt();
                                    switch(clientChoice) {
                                        case 1 -> {
                                            System.out.println(curUser.getMoney() + "$");
                                        }

                                        case 3 -> {
                                            System.out.print("Введите количество денег для снятия : ");
                                            int temp = Integer.parseInt(curUser.getMoney());
                                            int CashOut = console.nextInt();
                                            if (CashOut > limitCashOut) {
                                                System.out.println("error");
                                            } else if (CashOut > temp) {
                                                System.out.println("error");
                                            } else {
                                                System.out.println("У вас осталось : " + (Integer.parseInt(curUser.getMoney()) - CashOut));
                                                String data = String.valueOf(Integer.parseInt(curUser.getMoney()) - CashOut);
                                                curUser.setMoney(data);
                                                // String rewrite = curUser.getLogin() + " " + curUser.getPassword() + " " + data + " " + curUser.getIsBlocked();


                                                Logs.clientCastOutIsSuccess(curUser.getLogin(), CashOut);
                                            }
                                        }
                                        case 4 -> System.out.println("Всего доброго");

                                        case 2 -> {
                                            System.out.print("Введите количество : ");
                                            int cashin = console.nextInt();
                                            String data = String.valueOf(Integer.parseInt(curUser.getMoney()) + cashin);
                                            curUser.setMoney(data);
                                            System.out.println("Ваш баланс : " + curUser.getMoney());


                                        }

                                        default -> throw new IllegalStateException("Unexpected value: " + clientChoice);
                                     }
                                } while (clientChoice != 4); }
                                else System.out.println("you are banned");
                                //break;
                            }





                        }




                    }



                    //    Logs.logInSuccess(login);

                }

                //extraFunctions.ShowRates();

                case 2 -> {
                    System.out.println("Всего хорошего");
                }


                case 3 -> {
                    System.out.print("Enter a ALogin : "); String aLogin = console.next();
                    System.out.print("Enter a APassword : "); String aPass = console.next();
                    System.out.print("Enter a APin : "); String aPin = console.next();
                    if (Objects.equals(aLogin, "admin") && Objects.equals(aPass, "admin") && Objects.equals(aPin, "admin")) {
                        for (var user : users) {
                            System.out.println(user.toString());
                        }
                    }
                    else {
                        System.out.println("Incorrect...");
                    }
                }

                default -> System.out.println("Incorrect... Try again...");
            }
        } while(generalChoice != 2);
        Main.write(users, "database.txt");

    }


    public static void write(List<User> users, String PATH) {
        try{
            FileWriter write = new FileWriter(PATH);
            for(var user : users) {
                var buff = user.getLogin() + " " + user.getPassword() + " " + user.getName() + " " + user.getSurname() + " " + user.getMoney() + " " + user.getIsBlocked() + "\n";
                write.write(buff);
            }
            write.close();
        }
        catch(IOException ex) {
            System.out.println(ex.getMessage());
        }

    }

}