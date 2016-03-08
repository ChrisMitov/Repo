package news.dao;

import java.util.List;

import news.exceptions.CategoryException;
import news.model.Category;

public interface ICategoryDAO {
	public List<Category> getAllCategories() throws CategoryException;
	public Category getCategoryById(int categoryId) throws CategoryException;
}