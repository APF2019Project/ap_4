package view.shopController;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class ShopController {
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
        moneyAmount.setText(//todo parseString money);
    }

    public void collectionHandler() {
        collectionList.getItems().removeAll(collectionList.getItems());
        collectionList.getItems().addAll(//todo string list of all cards)
    }

    public void listClick() {
        String temp = collectionList.getSelectionModel().getSelectedItems().toString();
        String cardName = temp.substring(1, temp.length() - 1);
        //todo get the card with its name
        collectionImage.setImage(new Image(//todo path of imageCard));
                //todo set the information in lables

    }

    public void shopHandler() {
        shopList.getItems().removeAll(shopList.getItems());
        shopList.getItems().addAll(//todo string list of available cards)
    }

    public void shopListClick() {
        String temp = shopList.getSelectionModel().getSelectedItem().toString();
        String cardName = temp.substring(1, temp.length() - 1);
        //todo get the card with its name
        shopImage.setImage(new Image((/*todo path of image card))*/)));
        //todo set the information in lables
        name = cardName;

    }

    public void buyHandler() {
        buyMsg.setText("");//todo if the shopping was successfull or not););
    }


}
