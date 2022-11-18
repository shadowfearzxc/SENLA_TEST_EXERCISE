package Functions;

import FileManaged.WriterFile;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.Date;
import java.util.Scanner;

public class Logs {
        static Scanner scanner;

        static {
                try {
                        scanner = new Scanner(new FileInputStream("CashATM.txt"));
                } catch (FileNotFoundException e) {
                        throw new RuntimeException(e);
                }
        }

        static File file = new File("logs.txt");
        static File file2 = new File("CashATM.txt");
        static FileReader fr;
        static FileReader fr2;

        static {
                try {
                        fr = new FileReader(file);
                        fr2 = new FileReader(file2);
                } catch (FileNotFoundException e) {
                        throw new RuntimeException(e);
                }
        }

        static FileWriter fw;
        static FileWriter fw2;

        static {
                try {
                        fw = new FileWriter(file, true);
                        fw2 = new FileWriter(file2, true);
                } catch (IOException e) {
                        throw new RuntimeException(e);
                }
        }

        //static BufferedReader br = new BufferedReader(fr);

        static Date date = new Date();
        //Logs for console

        public static void signInSuccess(String login, String pass, String Money, String IsBlocked){
               String addData = login + " " + pass + " " + Money + " " + IsBlocked;
               WriterFile.write(addData, "database.txt");
               String MainLog  = "[LOG]" + "[" + date + "]Пользователь успешно зарегистрировался под логином : " + login;
               WriterFile.write(MainLog, "logs.txt");


        }

        public static void logInSuccess(String login) throws IOException {
                String MainLog = "[LOG]" + "[" + date + "]Пользователь под логином : " + login + " успешно вошел в банкомат";
                WriterFile.write(MainLog, "logs.txt");
        }
        public static void clientCastOutIsSuccess(String login, int CashOut) throws IOException {

               fr2 = new FileReader(file2);
                BufferedReader read = new BufferedReader(fr2);
                var buff = read.readLine();
                int temp = Integer.parseInt(buff);
                if (temp < CashOut) {
                        System.out.println("На данный момент в банкомате не хватает наличных. Повторите попытку позже.");
                        String str = "[LOG][" + date + "]Пользователь : " + login + ". Не смог снять деньги. В банкомате нет деняк";
                        WriterFile.write(str, "logs.txt");
                } else {

                        String MainLog  = "[LOG]" + "[" + date + "]Пользователь под логином : " + login + " снял с банкомата наличные суммой : " + CashOut;
                        WriterFile.write(MainLog, "logs.txt");
                        String MainCash = ("" + (temp - CashOut));
                        System.out.println("В банкомате осталось : " + (temp - CashOut));
                        WriterFile.write(MainCash, "CashATM.txt");

                }

        } }

        // Logs for client

      //  public static String()




