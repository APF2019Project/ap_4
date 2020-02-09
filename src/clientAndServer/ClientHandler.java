package clientAndServer;

import com.gilecode.yagson.YaGson;
import com.gilecode.yagson.YaGsonBuilder;
import gamecenter.User;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Type;
import java.net.Socket;
import java.util.Formatter;
import java.util.Scanner;

public class ClientHandler implements Runnable {

    private InputStream inputStream;
    private OutputStream outputStream;
    private String name;
    private Socket socket;

    public ClientHandler(Socket socket) throws IOException, ClassNotFoundException {
        this.socket = socket;
        inputStream = this.socket.getInputStream();
        outputStream = this.socket.getOutputStream();
        Scanner scanner = new Scanner(inputStream);
        String s = scanner.nextLine();
        YaGson yaGson = new YaGsonBuilder().create();
        Message message = yaGson.fromJson(s, (Type) Message.class);
        User newAccount;
        if (message.getStatus() == Status.NEW_ACCOUNT_SIGN_UP) {
            newAccount = message.getUser();
            int flagOfExistence = 0 ;
            for (User account : Server.getUsers()) {
                if (account.getUsername().equals(newAccount.getUsername())) {
                    flagOfExistence = 1;
                }
            }
            if (flagOfExistence == 0) {
                newAccount.setOnline(true);
                Server.getUsers().add(newAccount);
                this.name = newAccount.getUsername();
                System.out.println("name: " + this.name);
                Message message1 = new Message(Status.SEND_ACCOUNTS,Server.getUsers());
                String all = yaGson.toJson(message1);
                Formatter formatter = new Formatter(outputStream);
                formatter.format("%s\n", all);
                formatter.flush();
            } else{
                Message message1 = new Message(Status.ERROR, "already exists") ;
                String all = yaGson.toJson(message1);
                Formatter formatter = new Formatter(outputStream);
                formatter.format("%s\n", all);
                formatter.flush();
            }
        }else if (message.getStatus() == Status.NEW_ACCOUNT_LOGIN){
            newAccount = message.getUser();
            int flagOfExistence = 0;
            for (User account : Server.getUsers()) {
                if (account.getUsername().equals(newAccount.getUsername())) {
                    if (account.getPassword().equals(newAccount.getPassword())){
                        flagOfExistence = 1;
                        account.setOnline(true);
                        this.name = newAccount.getUsername();
                        System.out.println("name: " + this.name);
                        Message message1 = new Message(Status.SEND_ACCOUNTS,Server.getUsers(), account);
                        String all = yaGson.toJson(message1);
                        Formatter formatter = new Formatter(outputStream);
                        formatter.format("%s\n", all);
                        formatter.flush();
                    }else {
                        flagOfExistence = 1;
                        Message message1 = new Message(Status.ERROR, "wrong password");
                        String all = yaGson.toJson(message1);
                        Formatter formatter = new Formatter(outputStream);
                        formatter.format("%s\n", all);
                        formatter.flush();
                    }

                }
            }
            if (flagOfExistence == 0){
                Message message1 = new Message(Status.ERROR, "no such account");
                String all = yaGson.toJson(message1);
                Formatter formatter = new Formatter(outputStream);
                formatter.format("%s\n", all);
                formatter.flush();
            }

        }

    }

    @Override
    public void run() {
        System.out.println("client started :D");

        while (true) {
            try {
                InputStream inputStream = socket.getInputStream();
                Scanner scanner = new Scanner(inputStream);
                String s = scanner.nextLine();
                YaGson yaGson = new YaGsonBuilder().create();
                Message message = yaGson.fromJson(s, (Type) Message.class);


                if (message.getStatus() == Status.GET_ACCOUNTS){
                    Message message1 = new Message(Status.SEND_ACCOUNTS, Server.getUsers());
                    String all = yaGson.toJson(message1) ;
                    Formatter formatter = new Formatter(outputStream);
                    formatter.format("%s\n", all);
                    formatter.flush();
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


    public String getName() {
        return name;
    }

    public Socket getSocket() {
        return socket;
    }

    public boolean newUser(String username, String password) {
        for (User user : Server.getUsers()) {
            if (username.equals(user.getUsername()))
                return false;
        }
        User u = new User(username, password);
        Server.getUsers().add(u);
        return true;
    }

}
