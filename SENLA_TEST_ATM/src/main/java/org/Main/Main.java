package org.Main;


import Entities.User;
import FileManaged.ReaderFile;
import FileManaged.StringsParser;
import Functions.Logs;
import Functions.extraFunctions;

import java.io.*;
import java.util.ArrayList;
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

                    User curUser= null;
                   while(curUser == null) {
                       System.out.print("Введите ваш логин : "); String login = console.next();
                       System.out.print("Введите ваш пароль : "); String pass = console.next();
                       curUser= null;
                       for(var user : users) {
                           if (user.getLogin().equals(login) && user.getPassword().equals(pass)) {

                               curUser = user;
                               int clientChoice;
                               do {

                                   System.out.println("МЕНЮ :");
                                   System.out.println(extraFunctions.clientFunctions());
                                   clientChoice = console.nextInt();
                                   switch(clientChoice){
                                       case 1 -> {
                                           System.out.println(curUser.getMoney() + "$");
                                       }

                                       case 2 -> {
                                           System.out.print("Введите количество денег для снятия : ");
                                           int CashOut = console.nextInt();
                                           if(CashOut > limitCashOut) {
                                               System.out.println("error");
                                           }
                                           else {
                                               System.out.println("У вас осталось : " + (Integer.parseInt(curUser.getMoney()) - CashOut));
                                               String data = String.valueOf(Integer.parseInt(curUser.getMoney()) - CashOut);
                                               curUser.setMoney(data);
                                               String rewrite = curUser.getLogin() + " " + curUser.getPassword() + " " + data + " " + curUser.getIsBlocked();


                                               Logs.clientCastOutIsSuccess(curUser.getLogin(), CashOut);
                                           }
                                       }
                                         case 3 -> System.out.println("Всего доброго");

                                       case 4 -> {
                                           System.out.print("Введите количество : "); int cashin = console.nextInt();
                                           String data = String.valueOf(Integer.parseInt(curUser.getMoney()) + cashin);
                                           curUser.setMoney(data);
                                           System.out.println("Ваш баланс : " + curUser.getMoney());


                                       }

                                       default -> throw new IllegalStateException("Unexpected value: " + clientChoice);
                                   }
                               } while (clientChoice != 3);
                               //break;
                           }




                       }




                   }



                    //    Logs.logInSuccess(login);

                }

                case 2 -> extraFunctions.ShowRates();

                case 4 -> {
                    System.out.println("Всего хорошего");
                }

                case 3 -> {
                    System.out.print("Введите ваш логин : "); String login = console.next();
                    System.out.print("Введите количество денег для снятия : "); int CashOut = console.nextInt();
                    Logs.clientCastOutIsSuccess(login, CashOut);
                }

                case 5 -> {
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
        } while(generalChoice != 4);

    }


    public static void write(List<String> users, String PATH) {
        try{
            FileWriter write = new FileWriter(PATH);
            for(var user : users) {
                write.write(user);
            }
            write.close();
        }
        catch(IOException ex) {
            System.out.println(ex.getMessage());
        }

    }

}







