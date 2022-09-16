
package pkgsuper.market.control;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class connectionDB {
    private static Connection con=null;
    private connectionDB(){
        
    }
    public static Connection openconnection() throws SQLException{
        if(con==null)
        con=DriverManager.getConnection("jdbc:mysql://localhost/db", "root", "");
       // con=DriverManager.getConnection("mysql:host=localhost;dbname=db;charset=utf8;", "root", "");
        return con;
    } 
    public static void closeconnection(){
        if(con!=null)con=null;
    }
}
