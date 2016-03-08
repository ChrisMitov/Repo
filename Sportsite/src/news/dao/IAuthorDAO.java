package news.dao;

import news.exceptions.AuthorException;
import news.model.Author;

public interface IAuthorDAO {

	int addAuthor(Author author) throws AuthorException;

	void removeAuthor(int authorId) throws AuthorException;

	Author getAuthorById(int authorId) throws AuthorException;

}