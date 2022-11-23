package Functions;

import FileManaged.WriterFile;

import java.io.*;
import java.util.Date;

public class Logs {
        static File file2 = new File("CashATM.txt");
        static FileReader fr2;
        static Date date = new Date();




        public static void logInSuccess(String login) {
                String MainLog = "[" + date + "]Пользователь с номером карточки : " + login + " успешно вошел в банкомат";
                WriterFile.write(MainLog, "logs.txt");
        }
        public static void clientCastOutIsSuccess(String login, int CashOut) throws IOException {

                fr2 = new FileReader(file2);
                BufferedReader read = new BufferedReader(fr2);

                var buff = read.readLine();
                int temp = Integer.parseInt(buff);
                if (temp < CashOut) {
                        System.out.println("На данный момент в банкомате отсутствуют купюры для выдачи. Повторите попытку позднее,\nили введите сумму для выдачи меньше.");
                        String MainLog = "[" + date + "]Пользователь под логином : " + login + ". Не смог снять наличные.";
                        WriterFile.write(MainLog, "logs.txt");
                } else {

                        String MainLog  = "[" + date + "]Пользователь с номером: " + login + " снял с банкомата наличные суммой : " + CashOut;
                        WriterFile.write(MainLog, "logs.txt");
                        String MainCash = ("" + (temp - CashOut));
                        System.out.println("В банкомате осталось : " + MainCash);
                        WriterFile.write(MainCash, "CashATM.txt");
                }
        }
}



