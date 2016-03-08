package news.demo;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.SortedSet;

import news.dao.AuthorDatabaseDAO;
import news.dao.CategoryDAO;
import news.dao.INewsDAO;
import news.dao.NewsDAO;
import news.exceptions.AuthorException;
import news.exceptions.CategoryException;
import news.model.News;

public class Demo {
	public static void main(String[] args) throws CategoryException, AuthorException {
		INewsDAO newsDao = new NewsDAO();
		
		newsDao.addNews(new News(0, "Moqta novina", "Moeto zaglavie", 
				new AuthorDatabaseDAO().getAuthorById(2), new CategoryDAO().getCategoryById(1), 
				new Date(Calendar.getInstance().getTime().getTime())));
		
		SortedSet<News> allNews = new NewsList().getAllNewsByTitle();
		for (News news : allNews) {
			System.out.println("Category : " + news.getCategory().getTitle() + " id : " + news.getId());
			System.out.println(news.getTitle());
			System.out.println("--------------------------");
			System.out.println(news.getText());
			
			System.out.println("--------------------------");
			SimpleDateFormat df = new SimpleDateFormat();
			System.out.println("Posted on : " + df.format(news.getDate()));
			System.out.println("By : " + news.getAuthor().getName());
			System.out.println("Email : " + news.getAuthor().getEmail());
			System.out.println();
			System.out.println();
		}
	}
}
