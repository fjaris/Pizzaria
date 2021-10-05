package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public abstract class BaseDAO {
	Connection conn = null;
	String url = "jdbc:mariadb://localhost:3306/pizzaria";
	String user = "root";
	String senha = "123456";
	
	public Connection getConnection() {
		if(conn == null) {
			try {
				conn = DriverManager.getConnection(url, user, senha);
				System.out.println("Database connected");
			} catch(SQLException e) {
				e.printStackTrace();
			}
			return conn;
		}
		else return conn;
	}
}
