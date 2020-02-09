package view.chatController;

import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

public class ChatController {

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

    @FXML
    public void chooseImage() {

    }

    @FXML
    public void reply() {
        String text = messageList.getSelectionModel().getSelectedItem() ;

    }

    @FXML
    public void replyMessage() {

    }

    @FXML
    public void send() {

    }

    @FXML
 public void startChat() {

    }
}
