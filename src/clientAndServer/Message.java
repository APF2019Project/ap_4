package clientAndServer;

import com.gilecode.yagson.YaGson;
import com.gilecode.yagson.YaGsonBuilder;
import gamecenter.User;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Formatter;

public class Message {
    private Status status;
    private ArrayList<User> allUsers;
    private User user;
    private String errorMessage;


    public Message(Status status, User user) {
        this.status = status ;
        this.user = user ;
    }
    public Message(Status status, ArrayList<User> allUsers){
        this.status = status ;
        this.allUsers = allUsers ;
    }
    public Message(Status status, String errorMessage){
        this.status = status ;
        this.errorMessage = errorMessage ;
    }
    public Message(Status status, ArrayList<User> users , User user){
        this.status = status ;
        this.allUsers = users ;
        this.user = user ;
    }

    public Message(Status status) {
        this.status = status ;
    }



    public static void sendMessage(Message message, Socket socket) throws IOException {
        YaGson yaGson = new YaGsonBuilder().create();
        String s = yaGson.toJson(message);
        OutputStream outputStream = socket.getOutputStream();
        Formatter formatter = new Formatter(outputStream);
        formatter.format("%s\n", s);
        formatter.flush();
    }


    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public ArrayList<User> getAllUsers() {
        return allUsers;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}

enum Status {
     SEND_ACCOUNTS, NEW_ACCOUNT_SIGN_UP, ERROR, NEW_ACCOUNT_LOGIN, GET_ACCOUNTS, SEND_MESSAGE, SEND_REPLY , GET_MESSAGE,
    SEND_IMAGE, OFFLINE ;
}
