package Functions;


import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Paths;
import java.util.Scanner;

public class extraFunctions {

    public static String generalFunctions() {
        return "\n1)SignIn\n2)Log in \n3)Show rates\n4)Exit\n5)CashOut\n6)Admin panel";
    }

    public static String clientFunctions(){
        return "1) Cash out\n2) Show Balance\n3) Log Out\n\n";
    }

    public static int clientsAmount(){
        return 1;
    }

    public static void ShowRates() throws IOException {
        Scanner in = new Scanner(Paths.get("exchangeRates.txt"), StandardCharsets.UTF_8);
        while (in.hasNextLine()){
            System.out.println(in.nextLine());
        }
    }


}
