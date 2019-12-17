package gamecenter;

import java.util.ArrayList;

import controller.ViewController;

public class User {
    String username;
    String password;
    ArrayList<Zombies> ZombiesKilled = new ArrayList<>();
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
            if (AllUsers.currentuser.equals(User.username)){
                User.username=newusername;
                AllUsers.currentuser=newusername;
            }else break;
        }
    }
    public static void change(String newusername, String newpassword) {
        for (User User : ViewController.allusers.users) {
            if (AllUsers.currentuser.equals(User.username)){
                User.username=newusername;
                AllUsers.currentuser=newusername;
                User.password=newpassword;
            }else break;
        }
    }
}
