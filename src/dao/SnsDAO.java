package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SnsDAO {
//	private final String DSN = "jdbc:mysql://localhost:3306/sns?useSSL=false";
//	private final String USER = "root";
//	private final String PASSWORD = "root";
	private final String DSN = "jdbc:mysql://us-cdbr-east-06.cleardb.net/heroku_609f23575c263f1?reconnect=true&useSSL=false&useUnicode=true&characterEncoding=utf8&characterSetResults=utf8";
	private final String USER = "bbeae5de745892";
	private final String PASSWORD = "4de41e71";

	// データベースの接続情報を返す
	public Connection getConnection(){
		Connection conn = null;

		try {
			// JDBC ドライバのロード
            Class.forName("com.mysql.jdbc.Driver");

            // データベースへ接続
            conn = DriverManager.getConnection(DSN, USER, PASSWORD);
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}catch(SQLException e){
			e.printStackTrace();
		}

		return conn;
	}

	// Connection 型変数が持つデータベースと JDBC リソースの解放
	public void close(Connection conn) {
		if(conn != null){
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	// Statement 型変数が持つデータベースと JDBC リソースの解放
	public void close(Statement stmt) {
		if(stmt != null){
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	// ResultSet 型変数が持つデータベースと JDBC リソースの解放
	public void close(ResultSet rset) {
		if(rset != null){
			try {
				rset.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
