package view;

import controller.ViewController;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import sample.*;

import java.io.IOException;

public class LoginController {
    @FXML
    public Pane pane;
    @FXML
    public Label msg;
    @FXML
    public TextField signUpUsername;
    @FXML
    public PasswordField signUpPassword;
    @FXML
    public TextField loginUsername;
    @FXML
    public PasswordField loginPassword;
    @FXML
    public Label msg2;

    public void loginmenu() {
        Parent root = null;
        try {
            root = FXMLLoader.load(mainmenu.class.getResource("login.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        pane.getChildren().add(root);
    }


    public void signUp() {
        String s = ViewController.loginMenu("create account", signUpUsername.getText(), signUpPassword.getText());
        msg.setText(s);
    }

    public void login() {
        String s = ViewController.loginMenu("login", signUpUsername.getText(), signUpPassword.getText());
        msg.setText(s);
        if (s.equals("mainmenu")) {
            Menu.mainmenu.mainmenu(pane);
        }
    }
}
