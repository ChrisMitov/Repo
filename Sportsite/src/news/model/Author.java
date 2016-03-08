package news.model;

// POJO
public class Author {

	private int id;
	private String name;
	private String email;
	
	public Author(String name, String email) {
		setEmail(email);
		setName(name);
	}
	
	public Author(int id, String name, String email) {
		this(name, email);
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		if (name != null)
			this.name = name;
	}

	public String getEmail() {
		return email;
	}

	void setEmail(String email) {
		if (email != null)
			this.email = email;
	}


}
