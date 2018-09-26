package connection;
import java.sql.*;

public class DBconnection {
	private DBconnection() {

	}

	private static String user = "sa";
	private static String pwd = "INFdev1";

	public static Connection getConnection() throws SQLException {
		String url = "jdbc:sqlserver://localhost:1433;database=RISI";
		DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
		return DriverManager.getConnection(url, user, pwd);
	}

	// so good
}
