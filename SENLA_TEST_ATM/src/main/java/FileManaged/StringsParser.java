package FileManaged;

import Entities.User;

import java.util.ArrayList;
import java.util.List;

public class StringsParser {

    public static List<User> parse (List<String> ZX) {
        List<User> users = new ArrayList<>();

        for(String str : ZX) {
            var values = str.split(" ");
            String login = values[0];
            String pass = values[1];
            String clienCash = values[2];
            String isBlocked = values[3];
            users.add(new User(login,pass, clienCash,isBlocked));
        }
        return users;

    }




}
