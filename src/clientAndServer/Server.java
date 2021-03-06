package clientAndServer;

import com.gilecode.yagson.YaGson;
import gamecenter.User;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Server extends Thread {

    private ServerSocket serverSocket = new ServerSocket(9000);
    private static ArrayList<ClientHandler> allClients = new ArrayList<>();
    public static ArrayList<User> users = new ArrayList<>();

    public static ArrayList<User> getUsers() {
        return users;
    }

    public Server() throws IOException {

    }

    @Override
    public void run() {

        System.out.println("clientAndSever.Server");
        Server.getJson();

        Socket socket;
        while (true) {
            System.out.println("clientAndSever.Server is ready to get Request...");
            try {
                socket = serverSocket.accept();

                System.out.println("new server send request to connect!");

                System.out.println("clientAndServer " + "" + " connected with socket: " + socket);

                ClientHandler clientHandler = new ClientHandler(socket);
                allClients.add(clientHandler);
                Thread t = new Thread(clientHandler);
                t.start();
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }


    public static ArrayList<ClientHandler> getAllClients() {
        return allClients;
    }

    public static void toJson() {
        FileWriter fileWriter;
        try {
            fileWriter = new FileWriter("json/account.json");
            YaGson gson = new YaGson();
            String z = gson.toJson(Server.getUsers());
            fileWriter.write(z);
            fileWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void getJson() {
        YaGson yaGson = new YaGson();
        try {
            User[] accounts = yaGson.fromJson(new FileReader("json/account.json"), User[].class);
            if (accounts != null) {
                for (int i = 0; i < accounts.length; i++) {
                    Server.getUsers().add(accounts[i]);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

}
