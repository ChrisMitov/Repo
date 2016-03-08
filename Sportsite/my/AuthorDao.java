import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AuthorDao extends AbstractDao{
	
	private static final String ADD_AUTHOR = "insert into author Values (null, ? ,? )";

	public void addAuthor(Author author){
		if(author != null){
			try {
				PreparedStatement psmt = getCon().prepareStatement(ADD_AUTHOR);
				psmt.setString(1, author.getName());
				psmt.setString(2, author.getEmail());
				psmt.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	

}
