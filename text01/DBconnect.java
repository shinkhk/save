package text01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.*;

public class DBconnect {

	Connection con = null;
	public DBconnect() {
		
		String url = "jdbc:oracle:thin:@localhost:1521:projec";
		String id = "root";
		String password = "1234";
		
		try
		{
			Class.forName("oracle.jdbc.OracleDriver");
			System.out.println("드라이버 적재 성공");
			con = DriverManager.getConnection(url, id, password);
			System.out.println("데이터베이스 연결 성공:");
		} 
		catch (SQLException e) 
		{
			// TODO: handle exception
			System.out.println("연결에 실패하였습니다.");
		}
		catch(ClassNotFoundException e)
		{
			System.out.println("아이디 뭐지?");		
		} 
		
	}
	public static void main(String[] args) {
		new DBconnect();
	}

}