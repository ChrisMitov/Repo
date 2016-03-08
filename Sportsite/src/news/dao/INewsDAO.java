package news.dao;

import java.util.List;

import news.exceptions.AuthorException;
import news.exceptions.CategoryException;
import news.model.News;

public interface INewsDAO {

	void addNews(News news);

	List<News> getAllNews() throws CategoryException, AuthorException;

}