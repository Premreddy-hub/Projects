package com.hcl.ems;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class DaoConnection {

  /**
   * method will return db connection object if connected. 
   * @return connection if connected successfully else it's value will be null. 
   */

  public static Connection getConnection() {
    ResourceBundle rb = ResourceBundle.getBundle("db");
    String url = rb.getString("url");
    String user = rb.getString("user");
    String password = rb.getString("password");
    Connection con = null;
    try {
      Class.forName(rb.getString("driver"));
      con = DriverManager.getConnection(url,user,password);
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return con;
  
  }
}