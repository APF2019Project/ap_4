package gamecenter;

import java.util.ArrayList;

import clientAndServer.Client;
import clientAndServer.Server;
import gamecenter.zombies.*;
import controller.Viewcontroller;

public class User {
    public Collection collection = new Collection();
    public Shop shop = new Shop(collection);
    String username;
    String password;
    private boolean isOnline ;


    public ArrayList<Zombies> ZombiesKilled = new ArrayList<>();

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public static boolean deleteUser(String username, String password) {
        for (User User : Server.users) {
            if (username.equals(User.username))
                if (password.equals((User.password))) {
                    Server.users.remove(User);
                    return true;
                } else return false;
        }
        return false;
    }

    public static void renameUsername(String newusername) {
        for (User User : Server.users) {
            if (Client.currentClient.getUser().username.equals(User.username)) {
                User.username = newusername;
                Client.currentClient.getUser().username = newusername;
            } else break;
        }
    }

    public static void change(String newusername, String newpassword) {
        for (User User : Server.users) {
            if (Client.currentClient.getUser().username.equals(User.username)) {
                User.username = newusername;
                Client.currentClient.getUser().username = newusername;
                User.password = newpassword;
                Client.currentClient.getUser().password = newpassword;
            } else break;
        }
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public boolean isOnline() {
        return isOnline;
    }

    public void setOnline(boolean online) {
        isOnline = online;
    }
}
