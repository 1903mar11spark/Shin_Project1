package com.revature.util;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionUtil {
	
	public static Connection getConnectionFromFile() throws SQLException, IOException {
		Properties prop = new Properties();
		InputStream in = ConnectionUtil.class.getClassLoader().getResourceAsStream("config.properties");
		prop.load(in);
		try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
         }
         catch(ClassNotFoundException ex) {
            System.out.println("Error: unable to load driver class!");
         }
		return DriverManager.getConnection(prop.getProperty("db.url"), prop.getProperty("db.user"), prop.getProperty("db.password"));
	}	
}
//	public static void main(String[] args) {
//        try (OutputStream output = new FileOutputStream("C:\\Users\\Shinr\\Desktop\\Revature_OnSight\\HomeWork\\Shin_Project1\\project1\\src\\main\\resources\\config\\config.properties")) {
//
//            Properties prop = new Properties();
//
//            // set the properties value
//            prop.setProperty("db.url", "jdbc:oracle:thin:@shinrevature.cuhlahqla0kv.us-east-2.rds.amazonaws.com:1521:orcl");
//            prop.setProperty("db.user", "HyunShin9");
//            prop.setProperty("db.password", "200147598");
//
//            // save properties to project root folder
//            prop.store(output, null);
//
//            System.out.println(prop);
//
//        } catch (IOException io) {
//            io.printStackTrace();
//        }
//	}
//}
