
package pkgsuper.market.viewControl;

import java.io.IOException;
import java.sql.SQLException;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import pkgsuper.market.control.select;
import pkgsuper.market.modern.admin;


public class LoginForm_CL {
    @FXML
    TextField textuser;
    @FXML
    PasswordField textpass;
    @FXML
    Label lableMsg;
    
    admin ad=new admin();
    select lg=new select();
    @FXML
    private Button btnsignin;
    @FXML
    private Button btnsignup;
    @FXML
    private void islogin(ActionEvent event) throws SQLException, IOException{
        ad.setUsername(textuser.getText());
        ad.setPassword(textpass.getText());
        if(lg.islogin(ad)){
            Node node = (Node)event.getSource();
            Stage stage=(Stage)node.getScene().getWindow();
            //stage.close();
            
            Parent root=FXMLLoader.load(getClass().getResource("/pkgsuper/market/view/home.fxml"));
            Scene scene=new Scene(root,900,650);
            stage.setScene(scene);
            stage.show();
        }
        else{   
            lableMsg.setText("Username or password is wrong!");
        }
    }

    @FXML
    private void signup(ActionEvent event) {
    }
}
