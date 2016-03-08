package news.model;

import java.sql.Date;

public class News {

	private int id;
	private String text;
	private String title;
	private Author author;
	private Category category;
	private Date date;
	
	
	public News(int id, String text, String title, 
			Author author, Category category, Date date) {
		this.id = id;
		this.text = text;
		this.title = title;
		this.author = author;
		this.category = category;
		this.date = date;
	}


	public Author getAuthor() {
		return author;
	}


	public void setAuthor(Author author) {
		this.author = author;
	}


	public Category getCategory() {
		return category;
	}


	public void setCategory(Category category) {
		this.category = category;
	}


	public String getText() {
		return text;
	}


	public void setText(String text) {
		this.text = text;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}

	public Date getDate() {
		return date;
	}


	public void setDate(Date date) {
		this.date = date;
	}


	public int getId() {
		return id;
	}
}
