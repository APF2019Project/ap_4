package gamecenter;

import java.util.ArrayList;
import java.util.Comparator;

public class AllUsers {
    public static String currentuser;
    public ArrayList<User> users = new ArrayList<>();

    public boolean newUser(String username, String password) {
        for (User User : users) {
            if (username.equals(User.username))
                return false;
        }
        User u = new User(username, password);
        users.add(u);
        return true;
    }

    public boolean login(String username, String password) {
        for (User User : users) {
            if (username.equals(User.username)) {
                if (password.equals((User.password))) {
                    currentuser = username;
                } else return false;
            } else return false;
        }
        if (users.size() != 0)
            return true;
        return false;
    }

    public String[] Leaderboard() {
        users.sort(new Leaderboardsort());
        String[] usernames = new String[users.size()];
        for (User user : users) {
            int i = -1;
            i++;
            usernames[i] = user.username;
        }
        return usernames;
    }

    public int[] Leaderboardnumbers() {
        int[] numbers = new int[users.size()];
        for (User user : users) {
            int i = -1;
            i++;
            numbers[i] = user.ZombiesKilled.size();
        }
        return numbers;
    }
}


class Leaderboardsort implements Comparator<User> {
    @Override
    public int compare(User u1, User u2) {

        return u1.ZombiesKilled.size() - u2.ZombiesKilled.size();
    }
}