package pkgsuper.market.control;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.ObservableListBase;
import pkgsuper.market.modern.modelProduct;

public class productDB {

    Statement st;
    public int getcount(){
        int r=0;
        try {
            st = connectionDB.openconnection().createStatement();
            
            ResultSet rs= st.executeQuery("SELECT * FROM product");
            while(rs.next()){
                if(r<rs.getInt("id"))r=rs.getInt("id");
                r++;
            }
            connectionDB.closeconnection();
        } catch (SQLException ex) {
            Logger.getLogger(productDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return r;
    }
    public void insert(modelProduct pr) {
        try {
            st = connectionDB.openconnection().createStatement();
            
            st.executeUpdate("INSERT INTO product (id , name , number , price ,type , discount ) "
              + "VALUES ("+ (getcount()) +", '" + pr.getName() + "', " + pr.getNumber() + "," + pr.getPrice() + ", '" + pr.getType() + "' ,"
                    + pr.getDiscount() + ")");
            
            connectionDB.closeconnection();
        } catch (SQLException ex) {
            Logger.getLogger(productDB.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void remove(int id) {
        try {
            st = connectionDB.openconnection().createStatement();
            st.executeUpdate("Delete FROM product WHERE id=" + id);
            connectionDB.closeconnection();
        } catch (SQLException ex) {
            Logger.getLogger(productDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void update(modelProduct pr) {
        try {
            st = connectionDB.openconnection().createStatement();
            st.executeUpdate("update product set name= '" + pr.getName() + "' ,number=" + pr.getNumber() + ", price="
                    + pr.getPrice() + ", type= '" + pr.getType() + "' ,discount=" + pr.getDiscount()
                    + " where id=" + pr.getId());
        } catch (SQLException ex) {
            Logger.getLogger(productDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ObservableList<modelProduct> getallproduct() {
         ObservableList product=FXCollections.observableArrayList();
        try {
            st = connectionDB.openconnection().createStatement();
            ResultSet res=st.executeQuery("SELECT * FROM product");
            while(res.next()){
                modelProduct obj=new modelProduct();
                obj.setId(res.getInt(1));
                obj.setNumber(res.getInt(2));
                obj.setPrice(res.getDouble(3));
                obj.setDiscount(res.getDouble(4));
                obj.setName(res.getString(5));
                obj.setType(res.getString(6));
                product.add(obj);
            }
            connectionDB.closeconnection();
        } catch (SQLException ex) {
            Logger.getLogger(productDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return product;
    }
    
    public ObservableList<modelProduct> getsearchproduct(String name) {
         ObservableList product=FXCollections.observableArrayList();
        try {
            st = connectionDB.openconnection().createStatement();
            ResultSet res=st.executeQuery("SELECT * FROM product WHERE name LIKE '%"+name+"%'");
            while(res.next()){
                modelProduct obj=new modelProduct();
                obj.setId(res.getInt(1));
                obj.setNumber(res.getInt(2));
                obj.setPrice(res.getDouble(3));
                obj.setDiscount(res.getDouble(4));
                obj.setName(res.getString(5));
                obj.setType(res.getString(6));
                product.add(obj);
            }
            connectionDB.closeconnection();
        } catch (SQLException ex) {
            Logger.getLogger(productDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return product;
    }
}
