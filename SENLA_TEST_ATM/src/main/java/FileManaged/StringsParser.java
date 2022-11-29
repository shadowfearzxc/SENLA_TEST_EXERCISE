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
            String name = values[2];
            String surname = values[3];
            String clientCash = values[4];
            boolean isBlocked = Boolean.parseBoolean(values[5]);
            users.add(new User(login, pass, name, surname, clientCash, isBlocked));
        }
        return users;

    }
}
