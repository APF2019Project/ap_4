package clientAndServer;

import gamecenter.User;

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
}
