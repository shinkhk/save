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
			System.out.println("����̹� ���� ����");
			con = DriverManager.getConnection(url, id, password);
			System.out.println("�����ͺ��̽� ���� ����:");
		} 
		catch (SQLException e) 
		{
			// TODO: handle exception
			System.out.println("���ῡ �����Ͽ����ϴ�.");
		}
		catch(ClassNotFoundException e)
		{
			System.out.println("���̵� ����?");		
		} 
		
	}
	public static void main(String[] args) {
		new DBconnect();
	}

}