package clientAndServer;

import com.gilecode.yagson.YaGson;
import com.gilecode.yagson.YaGsonBuilder;
import gamecenter.User;

import java.io.IOException;
import java.lang.reflect.Type;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

public class Client {
    public static Client currentClient ;
    private Socket socket;
    private User user;
    private User selectedAccount ;
    private ArrayList<User> users = new ArrayList<>();
    public Client(User user) {
        this.user = user;
    }

    public static Client getCurrentClient() {
        return currentClient;
    }

    public static void setCurrentClient(Client currentClient) {
        Client.currentClient = currentClient;
    }

    public String SignUp() throws IOException {
        String temp = null ;
        socket = new Socket("localhost", 9000);
        Message message = new Message(Status.NEW_ACCOUNT_SIGN_UP, this.user);
        Message.sendMessage(message,socket);

        Scanner scanner = new Scanner(socket.getInputStream());
        String s = scanner.nextLine();
        YaGson yaGson = new YaGsonBuilder().create();
        message = yaGson.fromJson(s, (Type) Message.class);
        if (message.getStatus() == Status.SEND_ACCOUNTS){
            users.addAll(message.getAllUsers());
        }
        if (message.getStatus() == Status.ERROR){
            temp = message.getErrorMessage() ;
        }
        return  temp;
    }

    public String login() throws  IOException{
        String temp = null ;
        socket = new Socket("localhost",9000);
        Message message = new Message(Status.NEW_ACCOUNT_LOGIN, this.user) ;
        Message.sendMessage(message,socket);


        Scanner scanner = new Scanner(socket.getInputStream());
        String s = scanner.nextLine();
        YaGson yaGson = new YaGsonBuilder().create();
        message = yaGson.fromJson(s, (Type) Message.class);
        if (message.getStatus() == Status.SEND_ACCOUNTS){
            this.user = message.getUser() ;
            users.addAll(message.getAllUsers());
        }
        if (message.getStatus() == Status.ERROR){
            temp = message.getErrorMessage() ;

        }
        return temp ;
    }


    public void refresh() throws IOException {
        Message message = new Message(Status.GET_ACCOUNTS) ;
        Message.sendMessage(message, socket);

        Scanner scanner = new Scanner(socket.getInputStream());
        String s = scanner.nextLine() ;

        YaGson yaGson = new YaGsonBuilder().create();
        message = yaGson.fromJson(s, (Type) Message.class);
        users.removeAll(users);
        users.addAll(message.getAllUsers());
        for (User account: users) {
            if (this.user.getUsername().equals(account.getUsername())){
                this.user = account ;
                break;
            }

        }

    }
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Socket getSocket() {
        return socket;
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
    }

    public ArrayList<User> getUsers() {
        return users;
    }

    public User getSelectedAccount() {
        return selectedAccount;
    }

    public void setSelectedAccount(User selectedAccount) {
        this.selectedAccount = selectedAccount;
    }

//    public void sendComment(String commentText, String postTitle) throws IOException {
//        Message message = new Message(Status.SEND_COMMENT,this.getSelectedAccount(), postTitle,new String(this.getUser().getUsername() + " : " + commentText)) ;
//        Message.sendMessage(message, socket);
//    }


}
