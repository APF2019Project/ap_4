package view.loginController;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import view.loginController.*;
public class LoginController {
    @FXML
    public Label msg ;
    @FXML
    public TextField signUpUsername ;
    @FXML
    public PasswordField signUpPassword ;
    @FXML
    public TextField loginUsername ;
    @FXML
    public PasswordField loginPassword ;
    @FXML
    public Label msg2 ;
    @FXML
    public ListView<String> leaderBoardList ;


    public void signUp() {
        String userName = signUpUsername.getText();
        String passWord = signUpPassword.getText();
        //todo
    }


    public void login(){
      String userName = loginUsername.getText() ;
        String passWord = loginPassword.getText() ;
       //todo

   }
//   public void leaderBoard(){
//        leaderBoardList.getItems().addAll(//todo sorted list of players + their points);
//   }


}
