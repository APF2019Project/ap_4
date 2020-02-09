package view.shopController;


import clientAndServer.Client;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import view.mainmenu;

import java.io.IOException;

public class ShopController {
    @FXML
    public AnchorPane anchorPane;
    private String name;
    @FXML
    private Label amountOfMoney;
    @FXML
    private Button collectionBtn;
    @FXML
    private Label moneyAmount;
    @FXML
    private Button moneyBtn;
    @FXML
    private ListView<String> collectionList;
    @FXML
    private ImageView collectionImage;
    @FXML
    private ListView<String> shopList;
    @FXML
    private ImageView shopImage;
    @FXML
    private Label buyMsg;

    public void moneyHandler() {
        moneyAmount.setText(Client.currentClient.getUser().shop.getCoin() + "");
    }

    public void collectionHandler() {
        collectionList.getItems().removeAll(collectionList.getItems());
        collectionList.getItems().addAll(Client.currentClient.getUser().shop.name_c());//todo string list of all cards)
    }

    public void listClick() {
//        String temp = collectionList.getSelectionModel().getSelectedItems().toString();
//        String cardName = temp.substring(1, temp.length() - 1);
//        //todo get the card with its name
//        collectionImage.setImage(new Image(//todo path of imageCard));
//                //todo set the information in lables
    }

    public void shopHandler() {
        shopList.getItems().removeAll(shopList.getItems());
        shopList.getItems().addAll(Client.currentClient.getUser().shop.names());//todo string list of available cards)
    }

    public void shopListClick() {
        String temp = shopList.getSelectionModel().getSelectedItem();
    }

    public void buyHandler() {
        String temp = shopList.getSelectionModel().getSelectedItem();
        int status = Client.currentClient.getUser().shop.buyCard(temp);
        if (status == 0)
            buyMsg.setText("notEnoughMoney");
        if (status == -1)
            buyMsg.setText("invalid card");
        if (status == 2)
            buyMsg.setText("its been bought before");
        if (status == 1){
            buyMsg.setText("Bought!");
        }
    }

    public void stage(AnchorPane anchorPane) {
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("shop.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        anchorPane.getChildren().add(root);
    }

    public void back() {
        Parent root = null;
        try {
            root = FXMLLoader.load(mainmenu.class.getResource("mainmenu.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        anchorPane.getChildren().add(root);
    }
}
