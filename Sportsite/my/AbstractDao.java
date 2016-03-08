import java.sql.Connection;

public abstract class AbstractDao {

	private Connection con;

	public AbstractDao() {
		con = DBConnection.getInstance().getConnection();
	}

	public Connection getCon() {
		return con;
	}

}