package gamecenter;

import java.util.ArrayList;
import java.util.Comparator;

import static gamecenter.AllUsers.users;

public class AllUsers {
    static String currentuser;
    static ArrayList<User> users = new ArrayList<>();

    static boolean newUser(String username, String password) {
        for (User User : users) {
            if (username.equals(User.username))
                return false;
        }
        User u = new User(username, password);
        users.add(u);
        return true;
    }
     boolean login(String username, String password) {
        for (User User : users) {
            if (username.equals(User.username)) {
                if (password.equals((User.password))) {
                    currentuser = username;
                } else return false;
            }
        }
        return false;
    }
    static String[] Leaderboard() {
        users.sort(new Leaderboardsort());
        String[] usernames = new String[users.size()];
        for (User user : users) {
            int i = -1;
            i++;
            usernames[i] = user.username;
        }
        return usernames;
    }
    int[] Leaderboardnumbers() {
        int[] numbers = new int[users.size()];
        for (User user : users) {
            int i = -1;
            i++;
            numbers[i] = user.ZombiesKilled.size();
        }
        return numbers;
    }
}

class User {
    String username;
    String password;
    ArrayList<Zombies> ZombiesKilled = new ArrayList<>();
    User(String username, String password) {
        this.username = username;
        this.password = password;
    }
    static boolean deleteUser(String username, String password) {
        for (User User : users) {
            if (username.equals(User.username))
                if (password.equals((User.password))) {
                    users.remove(User);
                    return true;
                } else return false;
        }
        return false;
    }
    static void renameUsername(String newusername) {
        for (User User : users) {
            if (AllUsers.currentuser.equals(User.username)){
                User.username=newusername;
                AllUsers.currentuser=newusername;
            }else break;
        }
    }
    static void change(String newusername,String newpassword) {
        for (User User : users) {
            if (AllUsers.currentuser.equals(User.username)){
                User.username=newusername;
                AllUsers.currentuser=newusername;
                User.password=newpassword;
            }else break;
        }
    }
}

class Leaderboardsort implements Comparator<User> {
    @Override
    public int compare(User u1, User u2) {
        return u1.ZombiesKilled.size() - u2.ZombiesKilled.size();
    }
}