package news.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import news.exceptions.AuthorException;
import news.exceptions.CategoryException;
import news.model.News;

public class NewsDAO extends AbstractDAO implements INewsDAO {
	
	private static final String INSERT_NEWS_QUERY = "INSERT INTO news VALUES(null, ?, ?, ?, ?, ?);";

	/* (non-Javadoc)
	 * @see bg.ittalents.news.dao.INewsDAO#addNews(bg.ittalents.news.model.News)
	 */
	public void addNews(News news) {
		if (news != null) {
			try {
				PreparedStatement ps = getCon().prepareStatement(INSERT_NEWS_QUERY);
				ps.setString(1, news.getText());
				ps.setString(2, news.getTitle());
				ps.setInt(3, news.getAuthor().getId());
				ps.setInt(4, news.getCategory().getId());
				ps.setDate(5, news.getDate());
				
				ps.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	/* (non-Javadoc)
	 * @see bg.ittalents.news.dao.INewsDAO#getAllNews()
	 */
	public List<News> getAllNews() throws CategoryException, AuthorException {
		List<News> newsList = new ArrayList<News>();
		try {
			Statement statement = getCon().createStatement();
			ResultSet resultSet = statement.executeQuery("SELECT * FROM news;");
			
			AuthorDatabaseDAO authorDao = new AuthorDatabaseDAO();
			CategoryDAO categoryDao = new CategoryDAO();
			while (resultSet.next()) {
				News news = new News(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3), 
						authorDao.getAuthorById(resultSet.getInt(4)), categoryDao.getCategoryById(resultSet.getInt(5)), 
						resultSet.getDate(6,Calendar.getInstance()));
				newsList.add(news);
			}
			
			return newsList;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new CategoryException("No categories found!", e);
		}
		
	}

}
