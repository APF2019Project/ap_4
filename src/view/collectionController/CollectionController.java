package view.collectionController;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class CollectionController {
    private String handCardName ;
    private String collectionCardName ;
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
    private ListView<String> collectionList ;
    @FXML
    private ImageView collectionImage ;
   public void hand() {
        handList.getItems().removeAll(handList.getItems());
        handList.getItems().addAll() ; //todo add sorted list of hand cards
    }

    public void select(){
        String temp = handList.getSelectionModel().getSelectedItem().toString();
        String cardName = temp.substring(1,temp.length()-1);
        //todo get the card with its name
        handImage.setImage(new Image((/*todo path of image card))*/)));
        //todo set the information in lables
        handCardName = cardName ;
   }

  public   void remove() {
            //todo remove the hand card name from list
      handList.getItems().remove(handCardName);
    }

    public void collectionHandler(){
        collectionList.getItems().removeAll(collectionList.getItems());
        collectionList.getItems().addAll() ; //todo add sorted list of collection cards
    }

    public void selectCollectionList(){
       String temp = collectionList.getSelectionModel().getSelectedItem().toString() ;
        String cardName = temp.substring(1,temp.length()-1);
        //todo get the card with its name
        collectionImage.setImage(new Image((/*todo path of image card))*/)));
        //todo set the information in lables
        collectionCardName = cardName ;
    }

    public void selectCard(){
       //todo put the target card into hand
        collectionList.getItems().remove(collectionCardName);
        handList.getItems().add(collectionCardName);
    }

}
