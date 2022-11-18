package org.Main;


import FileManaged.ReaderFile;
import FileManaged.StringsParser;
import Functions.Logs;
import Functions.extraFunctions;
//import Functions.Person;
//import Functions.Logs;

import java.io.*;
//import java.nio.file.Path;
//import java.nio.file.Paths;
//import java.sql.SQLOutput;
import java.util.Objects;
import java.util.Scanner;

//import static java.lang.Runtime.getRuntime;

public class Main {



    
    public static void main(String[] args) throws IOException {
        Scanner console = new Scanner(System.in);
        //Path path = Paths.get("database.txt");



        System.out.println("Welcome, this is the ATM  of Alfa Bank");
        int generalChoice;
        do {
            System.out.println(extraFunctions.generalFunctions());
            generalChoice = console.nextInt();

            switch (generalChoice) {
                case 1 -> {
                    System.out.print("Enter your login : "); String login = console.next();
                    System.out.print("Enter your pass : "); String pass = console.next();
                   // Registration.SignIn(login, pass);
                    String money = "0";
                    String isBlocked = "0";
                    Logs.signInSuccess(login, pass, money, isBlocked);

                }

                case 2 -> {
                    System.out.print("Введите ваш логин : "); String login = console.next();
                   // System.out.print("Введите ваш пароль : "); String pass = console.next();
                    if(Objects.equals(login, "Sasha")) {
                        Logs.logInSuccess(login);
                    }
                }

                case 3 -> extraFunctions.ShowRates();

                case 4 -> {
                    //String login = "Sasha";
                    //Logs.Exit(login);
                }

                case 5 -> {
                    System.out.print("Введите ваш логин : "); String login = console.next();
                    System.out.print("Введите количество денег для снятия : "); int CashOut = console.nextInt();
                    Logs.clientCastOutIsSuccess(login, CashOut);
                }

                case 6 -> {
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







