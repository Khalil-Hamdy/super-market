package pkgsuper.market.viewControl;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.ObservableListBase;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import pkgsuper.market.control.productDB;
import pkgsuper.market.modern.modelProduct;

public class product_CL implements Initializable {

    @FXML
    private TextField productName;
    @FXML
    private TextField productNumber;
    @FXML
    private TextField productPrice;
    @FXML
    private ChoiceBox ProductType;
    @FXML
    private TextField productDiscount;
    @FXML
    private Button productAdd;
    @FXML
    private Button ProductDelete;
    @FXML
    private Button productUpdate;
    @FXML
    private Button pagelast;
    @FXML
    private ImageView lastPage;
    @FXML
    private TextField searchText;
    @FXML
    private Button searchbutton;
    @FXML
    private TableColumn name;
    @FXML
    private TableColumn number;
    @FXML
    private TableColumn price;
    @FXML
    private TableColumn type;
    @FXML
    private TableColumn discount;
    @FXML
    private TableColumn id;
    @FXML
    private TableView table;
    productDB pc = new productDB();
    private int ID;
    String typevalue[] = {"foods", "drinkes", "fruits"};
    ObservableList<String> oltype = FXCollections.observableArrayList(typevalue);
    int indexM = -1;

    public void search() {
        table.setItems(pc.getsearchproduct(searchText.getText()));
    }

    public void add(ActionEvent e) {
        modelProduct mp = new modelProduct();
        mp.setName(productName.getText());
        mp.setDiscount(Double.parseDouble(productDiscount.getText()));
        mp.setNumber(Integer.parseInt(productNumber.getText()));
        mp.setPrice(Double.parseDouble(productPrice.getText()));
        mp.setType(ProductType.getValue() + "");

        pc.insert(mp);
        table.setItems(pc.getallproduct());
        productName.setText("");
        productDiscount.setText("");
        productNumber.setText("");
        productPrice.setText("");
        // ProductType.setText("");
    }

    public void update(ActionEvent e) {
        modelProduct mp = (modelProduct) table.getSelectionModel().getSelectedItem();
        modelProduct mp2 = new modelProduct();
        mp2.setName(productName.getText());
        mp2.setDiscount(Double.parseDouble(productDiscount.getText()));
        mp2.setNumber(Integer.parseInt(productNumber.getText()));
        mp2.setPrice(Double.parseDouble(productPrice.getText()));
        mp2.setType(ProductType.getValue() + "");
        mp2.setId(mp.getId());
        pc.update(mp2);
        table.setItems(pc.getallproduct());
        productName.setText("");
        productDiscount.setText("");
        productNumber.setText("");
        productPrice.setText("");
        // ProductType.setText("");
    }

    public void clickTable() {
        modelProduct mp = (modelProduct) table.getSelectionModel().getSelectedItem();
        productName.setText(mp.getName());
        productDiscount.setText(mp.getDiscount() + "");
        productNumber.setText(mp.getNumber() + "");
        productPrice.setText(mp.getPrice() + "");
        ProductType.setValue(mp.getType());

    }

    public void delete(ActionEvent e) {
        modelProduct mp = (modelProduct) table.getSelectionModel().getSelectedItem();
        pc.remove(mp.getId());
        table.setItems(pc.getallproduct());
        productName.setText("");
        productDiscount.setText("");
        productNumber.setText("");
        productPrice.setText("");
        // ProductType.setText("");

    }

    public void lastpage(ActionEvent e) {
        try {
            Node node = (Node) e.getSource();
            Stage stage = (Stage) node.getScene().getWindow();
            //stage.close();

            Parent root = FXMLLoader.load(getClass().getResource("/pkgsuper/market/view/home.fxml"));
            Scene scene = new Scene(root, 900, 650);
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(product_CL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ProductType.getItems().addAll(oltype);
        id.setCellValueFactory(new PropertyValueFactory("id"));
        number.setCellValueFactory(new PropertyValueFactory("number"));
        price.setCellValueFactory(new PropertyValueFactory("price"));
        discount.setCellValueFactory(new PropertyValueFactory("discount"));
        name.setCellValueFactory(new PropertyValueFactory("name"));
        type.setCellValueFactory(new PropertyValueFactory("type"));

        table.setItems(pc.getallproduct());
    }

}
/* public void update(ActionEvent e){
        modelProduct mp=new modelProduct();
        mp.setName(productName.getText());
        mp.setDiscount(Double.parseDouble(productDiscount.getText()));
        mp.setNumber(Integer.parseInt(productNumber.getText()));
        mp.setPrice(Double.parseDouble(productPrice.getText()));
        mp.setType(ProductType.getValue()+"");
        
        pc.update(mp);
        table.setItems(pc.getallproduct());
        productName.setText("");
        productDiscount.setText("");
        productNumber.setText("");
        productPrice.setText("");
       // ProductType.setText("");
    }
    public void clickTable(){
        modelProduct mp=(modelProduct)table.getSelectionModel().getSelectedItem();
        productName.setText(mp.getName());
        productDiscount.setText(mp.getDiscount()+"");
        productNumber.setText(mp.getNumber()+"");
        productPrice.setText(mp.getPrice()+"");
        ProductType.setValue(mp.getType());
        
        this.ID=mp.getId();
    }*/
