
package pkgsuper.market.viewControl;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class Home_CL {
    @FXML
    Button button_product,button_services,button_employees,button_statistics;
    
    @FXML
    public void openProduct(ActionEvent event) throws IOException{
        Node node = (Node)event.getSource();
            Stage stage=(Stage)node.getScene().getWindow();
            //stage.close();
            
            Parent root=FXMLLoader.load(getClass().getResource("/pkgsuper/market/view/product.fxml"));
            Scene scene=new Scene(root,900,650);
            stage.setScene(scene);
            stage.show();
    }

    @FXML
    private void openServices(ActionEvent event) throws IOException {
        Node node = (Node)event.getSource();
            Stage stage=(Stage)node.getScene().getWindow();
            //stage.close();
            
            Parent root=FXMLLoader.load(getClass().getResource("/pkgsuper/market/view/services.fxml"));
            Scene scene=new Scene(root,900,650);
            stage.setScene(scene);
            stage.show();
    }

    @FXML
    private void openEmployees(ActionEvent event) throws IOException {
        Node node = (Node)event.getSource();
            Stage stage=(Stage)node.getScene().getWindow();
            //stage.close();
            
            Parent root=FXMLLoader.load(getClass().getResource("/pkgsuper/market/view/employees.fxml"));
            Scene scene=new Scene(root,900,650);
            stage.setScene(scene);
            stage.show();
    }

    @FXML
    private void openStatistics(ActionEvent event) throws IOException {
        Node node = (Node)event.getSource();
            Stage stage=(Stage)node.getScene().getWindow();
            //stage.close();
            
            Parent root=FXMLLoader.load(getClass().getResource("/pkgsuper/market/view/statistics.fxml"));
            Scene scene=new Scene(root,900,650);
            stage.setScene(scene);
            stage.show();
    }
    
}
