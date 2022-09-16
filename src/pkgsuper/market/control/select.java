/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkgsuper.market.control;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.naming.spi.DirStateFactory;
import pkgsuper.market.modern.admin;

public class select {

    Statement st;

    public boolean islogin(admin ad) throws SQLException {
        st = connectionDB.openconnection().createStatement();
        ResultSet res = st.executeQuery("select * from admins where user_name ='" + ad.getUsername()
                + "' and password='" + ad.getPassword()+"'");
         connectionDB.closeconnection();
        if (res.next()) {
            return true;
        } else {
            return false;
        }
    }
}
