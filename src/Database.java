import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
	private String dburl="jdbc:mysql://localhost:3306/gerpro";
	private String dbuname="root";
	private String dbpassword="root";
	private String dbdriver="com.mysql.cj.jdbc.Driver";
	
	public void loadDriver(String dbDriver) {
		try {
			Class.forName(dbDriver);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Connection getConnection() {
		Connection con=null;
		try {
			con = DriverManager.getConnection(dburl, dbuname, dbpassword);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
	}
	
	public String getDbdriver() {
		return dbdriver;
	}
}
