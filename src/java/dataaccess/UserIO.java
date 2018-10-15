package dataaccess;

import java.io.*;
import java.util.*;

import business.User;

public class UserIO {

    public static boolean add(User user, String filepath) {
        try {
            File file = new File(filepath);
            PrintWriter out = new PrintWriter(new FileWriter(file, true));
            out.println(user.getUsername());

            out.close();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static User getUser(String loginID, String filepath) {
        try {
            File file = new File(filepath);
            BufferedReader in = new BufferedReader(new FileReader(file));
            User user = new User();
            String line = in.readLine();
            while (line != null) {
                if (line.equalsIgnoreCase(loginID)) {
                    String username = line;
                    user = UserDB.searchUsername(username);
                }
                line = in.readLine();
            }
            in.close();
            return user;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}