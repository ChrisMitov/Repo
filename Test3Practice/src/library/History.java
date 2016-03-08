package library;

import java.time.LocalDateTime;

public class History {
	private LocalDateTime dateTaken;
	private LocalDateTime dateReturned;

	public History(LocalDateTime dateTaken) {
		this.dateTaken = dateTaken;
	}

	public LocalDateTime getDateReturned() {
		return dateReturned;
	}

	public void setDateReturned(LocalDateTime dateReturned) {
		this.dateReturned = dateReturned;
	}

	@Override
	public String toString() {
		return this.dateTaken + " - " + this.dateReturned;
	}

	public LocalDateTime getDateTaken() {
		return dateTaken;
	}



}
