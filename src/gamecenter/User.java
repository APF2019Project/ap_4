package gamecenter;

import java.util.ArrayList;

import gamecenter.zombies.*;
import controller.ViewController;

public class User {
    String username;
    String password;
    public ArrayList<Zombies> ZombiesKilled = new ArrayList<>();

    User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public static boolean deleteUser(String username, String password) {
        for (User User : ViewController.allusers.users) {
            if (username.equals(User.username))
                if (password.equals((User.password))) {
                    ViewController.allusers.users.remove(User);
                    return true;
                } else return false;
        }
        return false;
    }

    public static void renameUsername(String newusername) {
        for (User User : ViewController.allusers.users) {
            if (ViewController.allusers.currentuser.equals(User.username)) {
                User.username = newusername;
                ViewController.allusers.currentuser = newusername;
            } else break;
        }
    }

    public static void change(String newusername, String newpassword) {
        for (User User : ViewController.allusers.users) {
            if (ViewController.allusers.currentuser.equals(User.username)) {
                User.username = newusername;
                ViewController.allusers.currentuser = newusername;
                User.password = newpassword;
            } else break;
        }
    }

}
