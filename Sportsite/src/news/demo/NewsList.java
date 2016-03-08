package news.demo;

import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

import news.dao.NewsDAO;
import news.exceptions.AuthorException;
import news.exceptions.CategoryException;
import news.model.News;

public class NewsList {
	private List<News> news = null;
	
	
	public NewsList() {
		try {
			news = 	new NewsDAO().getAllNews();
		} catch (CategoryException | AuthorException e) {
			e.printStackTrace();
		}
	}
	
	public List<News> getAllNews() throws CategoryException, AuthorException {
		return 	news;
	}
	
	
	public SortedSet<News> getAllNewsByTitle() throws CategoryException, AuthorException {
		TreeSet<News> sortedNews = new TreeSet<News>(
				(n1, n2)->n1.getTitle().compareTo(n2.getTitle()));
		sortedNews.addAll(news);
		return sortedNews;
	}


}
