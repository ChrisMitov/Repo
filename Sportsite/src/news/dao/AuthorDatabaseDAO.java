package news.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import news.exceptions.AuthorException;
import news.model.Author;

public class AuthorDatabaseDAO extends AbstractDAO implements IAuthorDAO {

	private static final String SELECT_AUTHOR_BY_ID_QUERY = "SELECT * FROM authors WHERE id = ?";
	private static final String DELETE_AUTHOR_QUERY = "DELETE FROM authors WHERE id = ?";
	private static final String ADD_AUTHOR_QUERY = "INSERT INTO authors VALUES (null, ?,?)";

	public int addAuthor(Author author) throws AuthorException {
		if (author != null) {
			try {
				PreparedStatement ps = getCon().prepareStatement(ADD_AUTHOR_QUERY,
						PreparedStatement.RETURN_GENERATED_KEYS);
				ps.setString(1, author.getName());
				ps.setString(2, author.getEmail());

				ps.executeUpdate();

				// get last inserted id
				ResultSet id = ps.getGeneratedKeys();
				id.next();
				return id.getInt(1);
			} catch (SQLException e) {
				e.printStackTrace();
				throw new AuthorException("Can't add an author", e);
			}
		}
		return 0;
	}

	public void removeAuthor(int authorId) throws AuthorException {

		try {
			PreparedStatement ps = getCon().prepareStatement(DELETE_AUTHOR_QUERY);
			ps.setInt(1, authorId);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new AuthorException("Can't delete an author with ID : " + authorId, e);
		}
	}

	public Author getAuthorById(int authorId) throws AuthorException {

		try {
			PreparedStatement ps = getCon().prepareStatement(SELECT_AUTHOR_BY_ID_QUERY);
			ps.setInt(1, authorId);
			ResultSet result = ps.executeQuery();
			result.next();
			int id = result.getInt(1);
			String name = result.getString(2);
			String email = result.getString(3);

			return new Author(id, name, email);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new AuthorException("Can't find an author with ID : " + authorId, e);
		}
	}
}
