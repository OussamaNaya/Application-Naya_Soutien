package tools;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class DBInteraction {
	private static Connection con;
	private static Statement st;
	private static String url = "jdbc:mysql://localhost/Naya_Soutien";
	
	public DBInteraction() {
	}
	public static void connect() throws SQLException, ClassNotFoundException
	{
		Class.forName("com.mysql.jdbc.Driver");
		con=DriverManager.getConnection(url,"root","");
		st=con.createStatement();
	}
	public static void disconnect() throws SQLException
	{
		st.close();
		con.close();
	}
	public static int Maj(String sql) throws SQLException
	{
		int nb = 0;
		nb = st.executeUpdate(sql);
		return nb;
	}
	public static ResultSet Select(String sql) throws SQLException
	{
		ResultSet rs = null;
		rs = st.executeQuery(sql);
		return rs;
	}
}