import java.time.LocalDateTime;

public class History {
	private LocalDateTime dateTaken;
	private LocalDateTime dateReturned;
	
	public History(LocalDateTime dateTaken) {
		this.setDateTaken(dateTaken);
	}

	public LocalDateTime getDateTaken() {
		return dateTaken;
	}

	public void setDateTaken(LocalDateTime dateTaken) {
		this.dateTaken = dateTaken;
	}

	public LocalDateTime getDateReturned() {
		return dateReturned;
	}

	public void setDateReturned(LocalDateTime dateReturned) {
		this.dateReturned = dateReturned;
	}
}
