package news.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import news.exceptions.CategoryException;
import news.model.Category;


public class CategoryDAO extends AbstractDAO implements ICategoryDAO {
	
	private static final String SELECT_CATEGORY_BY_ID_QUERY = 
			"SELECT * FROM categories WHERE id = ?";
	
	public Category getCategoryById(int categoryId) throws CategoryException {

		try {
			PreparedStatement ps = getCon().prepareStatement(SELECT_CATEGORY_BY_ID_QUERY);
			ps.setInt(1, categoryId);
			ResultSet result = ps.executeQuery();
			result.next();
			int id = result.getInt(1);
			String name = result.getString(2);

			return new Category(id, name);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new CategoryException("Can't find an category with ID : " + categoryId, e);
		}
	}

	public List<Category> getAllCategories() throws CategoryException {
		List<Category> categoriesList = new ArrayList<Category>();
		try {
			Statement statement = getCon().createStatement();
			ResultSet resultSet = statement.executeQuery("SELECT * FROM categories;");
			
			while (resultSet.next()) {
				Category category = new Category(resultSet.getInt(1), 
						resultSet.getString(2));
				categoriesList.add(category);
			}
			
			return categoriesList;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new CategoryException("No categories found!", e);
		}
		
	}

}
