package org.Main;


import FileManaged.ReaderFile;
import FileManaged.StringsParser;
import Functions.Logs;
import Functions.extraFunctions;

import java.io.*;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner console = new Scanner(System.in);

        System.out.println("Welcome, this is the ATM  of Alfa Bank");
        int generalChoice;
        do {
            System.out.println(extraFunctions.generalFunctions());
            generalChoice = console.nextInt();

            switch (generalChoice) {

                case 1 -> {
                    System.out.print("Введите ваш логин : "); String login = console.next();
                   // System.out.print("Введите ваш пароль : "); String pass = console.next();

                        Logs.logInSuccess(login);

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

                        var strings = ReaderFile.sReader();
                        var users = StringsParser.parse(strings);
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

}







