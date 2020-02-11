package view.chatController;

import clientAndServer.Client;
import gamecenter.User;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;

import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.Timer;
import java.util.TimerTask;


public class ChatController implements Initializable {
    private static byte[] sendingImage = null ;
    private String imageName = null ;
    private static int ID = 0 ;

    @FXML
    private ListView<String> accountList;

    @FXML
    private ListView<String> messageList;

    @FXML
    private TextField textMessage;

    @FXML
    private ImageView targetImage;

    @FXML
    private ImageView imageMessage;

    public static byte[] getSendingImage() {
        return sendingImage;
    }

    public static void setSendingImage(byte[] sendingImage) {
        ChatController.sendingImage = sendingImage;
    }

    public static int getID() {
        return ID;
    }

    public static void setID(int ID) {
        ChatController.ID = ID;
    }


    public void reply() throws IOException {
        String text = "in reply to message<<"+ messageList.getSelectionModel().getSelectedItem()+">>"+ textMessage.getText() ;
        Payam payam = new Payam(text,Client.currentClient.getUser().getUsername(),Client.getCurrentClient().getSelectedAccount().getUsername(),imageName,sendingImage);
        Client.getCurrentClient().sendPayam(payam);
        imageName = null ;
        sendingImage =null ;
    }


    public void ShowImage() throws IOException {
        if (messageList.getSelectionModel().getSelectedItem().contains("<<Image>>")){
            int length = messageList.getSelectionModel().getSelectedItem().length() ;
            String s =  messageList.getSelectionModel().getSelectedItem().substring(length-1,length);
            int index = Integer.parseInt(s);
           Payam payam = Client.getCurrentClient().getUser().getPayamHa().get(index);
            String path = new String("img/"+payam.getImageName() +".jpg");
            File file1 = new File(path);
            OutputStream outputStream = new FileOutputStream(file1);
            outputStream.write(payam.getImage());
            outputStream.close();
            String serverImage = file1.toURI().toURL().toExternalForm();
            imageMessage.setImage(new Image(serverImage));
        }
    }

    public void send() throws IOException {
        String text = textMessage.getText() ;
        Payam payam = new Payam(text,Client.currentClient.getUser().getUsername(),Client.getCurrentClient().getSelectedAccount().getUsername(),imageName,sendingImage);
        Client.getCurrentClient().sendPayam(payam);
        imageName = null ;
        sendingImage =null ;
    }

    public void refreshButton() throws IOException {
        Client.getCurrentClient().refresh();
        ArrayList<String> accountNames = new ArrayList<>();
        for (User account: Client.getCurrentClient().getUsers()) {
            if (account.getUsername().equals(Client.getCurrentClient().getUser().getUsername()))
                continue;
                accountNames.add(account.getUsername());
        }
        ObservableList<String> userNames = FXCollections.observableArrayList(accountNames);
        accountList.setItems(userNames);

    }

    public void repeatedRefresh() throws IOException {
        Client.currentClient.refresh();
        ArrayList<String> chat = new ArrayList<>();
        for (Payam payam : Client.getCurrentClient().getUser().getPayamHa()){
            if (payam.getSender().equals(Client.getCurrentClient().getSelectedAccount().getUsername())){
                String finalPayam ;
                if (payam.getImageName() == null){
                    finalPayam = payam.getSender() + "said : " + payam.getText() ;
                }else {
                    finalPayam = payam.getSender() + "said : " + payam.getText() + "<<Image>>"+ chat.size() ;
                }
                chat.add(finalPayam);
            }
            if (payam.getReceiver().equals(Client.getCurrentClient().getSelectedAccount().getUsername())){
                String finalPayam = "you said : " + payam.getText() ;
                chat.add(finalPayam);
            }
        }
        ObservableList<String> chatRoom = FXCollections.observableArrayList(chat);
        messageList.setItems(chatRoom);
    }



    public void chooseImage() throws IOException {
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Image files", "*.jpg"));
        File file = fileChooser.showOpenDialog(null);
        byte[] imageTemp = new byte[(int) file.length()] ;
        if (file != null) {
            FileInputStream fis = new FileInputStream(file);
            fis.read(imageTemp);
            fis.close();
        }

        imageName = Client.currentClient.getUser().getUsername() + "" + ID ;
        ID ++ ;
        ChatController.setSendingImage(imageTemp);
    }




 public void startChat() throws IOException {
     for (User selectedAccount:Client.getCurrentClient().getUsers()) {
        if (selectedAccount.getUsername().equals(accountList.getSelectionModel().getSelectedItem())){
            Client.getCurrentClient().setSelectedAccount(selectedAccount);
            break;
        }
     }
     Timer t = new Timer();
     t.schedule(new TimerTask() {
         @Override
         public void run() {
             try {
                 repeatedRefresh();
             } catch (IOException e) {

             }
         }
     }, 0,5000);

    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            refreshButton();
        } catch (IOException e) {

        }
    }
}
