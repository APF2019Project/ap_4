package view.collectionController;

import clientAndServer.Client;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import view.mainmenu;

import java.io.IOException;

public class CollectionController {
    private String handCardName;
    private String collectionCardName;
    @FXML
    public AnchorPane anchorPane;
    @FXML
    private ListView<String> handList;
    @FXML
    private ImageView handImage;
    @FXML
    private Label hand1Msg;
    @FXML
    private Label hand2Msg;
    @FXML
    private Label hand3Msg;
    @FXML
    private ListView<String> collectionList;
    @FXML
    private ImageView collectionImage;

    public void stage(AnchorPane anchorPane) {
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("collection.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        anchorPane.getChildren().add(root);
    }

    public void hand() {
        handList.getItems().removeAll(handList.getItems());
        handList.getItems().addAll(Client.currentClient.getUser().collection.names_p());
    }


    public void remove() {
        handCardName = handList.getSelectionModel().getSelectedItem();
        handList.getItems().remove(handCardName);
        collectionList.getItems().add(handCardName);
    }

    public void collectionHandler() {
        collectionList.getItems().removeAll(collectionList.getItems());
        collectionList.getItems().addAll(Client.currentClient.getUser().collection.names_c_p());
    }

    public void selectCard() {
        collectionCardName = collectionList.getSelectionModel().getSelectedItem();
        collectionList.getItems().remove(collectionCardName);
        handList.getItems().add(collectionCardName);
    }

    public void selectCollectionList() {
//        String temp = collectionList.getSelectionModel().getSelectedItem().toString();
//        String cardName = temp.substring(1, temp.length() - 1);
//        //todo get the card with its name
//        collectionImage.setImage(new Image((/*todo path of image card))*/)));
//        //todo set the information in lables
//        collectionCardName = cardName;
    }

    public void back() {
        Parent root = null;
        try {
            root = FXMLLoader.load(mainmenu.class.getResource("play.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        anchorPane.getChildren().add(root);
    }

    public void select() {
//        String temp = handList.getSelectionModel().getSelectedItem().toString();
//        String cardName = temp.substring(1, temp.length() - 1);
//        //todo get the card with its name
//        handImage.setImage(new Image((/*todo path of image card))*/)));
//        //todo set the information in lables
//        handCardName = cardName;
    }


}
