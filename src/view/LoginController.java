package view;

import clientAndServer.Client;
import gamecenter.User;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
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
        String userName = signUpUsername.getText();
        String passWord = signUpPassword.getText();
        User account = new User(userName, passWord);
        Client client = new Client(account);
        try {
            String s = client.SignUp();
            if (s != null) {
                signUpPassword.setText(null);
                signUpUsername.setText(null);
                msg.setText(s);
            }else {
                Client.setCurrentClient(client);
                Menu.mainmenu.mainmenu(pane);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void login() {
        String userName = loginUsername.getText();
        String passWord = loginPassword.getText();
        User account = new User(userName, passWord);
        Client client = new Client(account);
        try {
            String s = client.login();
            if (s != null) {
                loginPassword.setText(null);
                loginUsername.setText(null);
                msg2.setText(s);
            } else {
                Client.setCurrentClient(client);
                Menu.mainmenu.mainmenu(pane);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
