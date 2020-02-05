package view.collectionController;

import controller.ViewController;
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

public class Collection_z {
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
            root = FXMLLoader.load(getClass().getResource("collectionz.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        anchorPane.getChildren().add(root);
    }

    public void hand() {
        handList.getItems().removeAll(handList.getItems());
        handList.getItems().addAll(ViewController.collection.names_z());
    }

    public void selectCard() {
        collectionCardName = collectionList.getSelectionModel().getSelectedItem();
        collectionList.getItems().remove(collectionCardName);
        handList.getItems().add(collectionCardName);
    }


    public void remove() {
        handCardName = handList.getSelectionModel().getSelectedItem();
        collectionList.getItems().add(handCardName);
        handList.getItems().remove(handCardName);
    }

    public void collectionHandler() {
        collectionList.getItems().removeAll(collectionList.getItems());
        collectionList.getItems().addAll(ViewController.collection.names_c_z());
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

    public void selectCollectionList() {
//        String temp = collectionList.getSelectionModel().getSelectedItem().toString();
//        String cardName = temp.substring(1, temp.length() - 1);
//        //todo get the card with its name
//        collectionImage.setImage(new Image((/*todo path of image card))*/)));
//        //todo set the information in lables
//        collectionCardName = cardName;
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
