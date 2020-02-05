package view;

import controller.ViewController;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.PasswordField;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import view.collectionController.*;
import java.io.IOException;



public class mainmenu {

    @FXML
    public Pane pane;
    @FXML
    public AnchorPane anchorPane;
    @FXML
    public AnchorPane anchorPane_pro;
    @FXML
    public AnchorPane anchorPane_play;
    @FXML
    public PasswordField password;
    @FXML
    public Label msge;
    @FXML
    private TextArea user_name;

    public void a(Pane pane) {
        this.pane = pane;
    }

    public void mainmenu(Pane pane) {
        a(pane);
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("mainmenu.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.pane.getChildren().add(root);
    }

    public void profile() {
        Parent root = null;
        try {
            root = FXMLLoader.load(mainmenu.class.getResource("profile.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        anchorPane.getChildren().add(root);
    }

    public void rename() {
        String s = ViewController.profile("rename", user_name.getText(), password.getText());
        msge.setText(s);

    }

    public void show() {
        msge.setText(ViewController.allusers.currentuser);
    }

    public void delete() {
        String s = ViewController.profile("delete", user_name.getText(), password.getText());
        msge.setText(s);
    }

    public void change() {
        String s = ViewController.profile("change", user_name.getText(), password.getText());
        msge.setText(s);
    }

    public void menu_back() {
        Parent root = null;
        try {
            root = FXMLLoader.load(mainmenu.class.getResource("login.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        anchorPane.getChildren().add(root);
    }

    public void pro_back() {
        Parent root = null;
        try {
            root = FXMLLoader.load(mainmenu.class.getResource("mainmenu.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        anchorPane_pro.getChildren().add(root);
    }

    public void goTOShop() {
        Menu.shopController.stage(anchorPane);
    }

    public void play() {
        Parent root = null;
        try {
            root = FXMLLoader.load(mainmenu.class.getResource("play.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        anchorPane.getChildren().add(root);
    }

    public void day() {
        Menu.collectionController.stage(anchorPane_play);
    }
    public void zombie() {
        Menu.collection_z.stage(anchorPane_play);
    }

    public void play_back() {
        Parent root = null;
        try {
            root = FXMLLoader.load(mainmenu.class.getResource("mainmenu.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        anchorPane_play.getChildren().add(root);
    }
}
