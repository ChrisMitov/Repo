package library;

import java.time.LocalDateTime;

public class History {
	private LocalDateTime dateTaken;
	private LocalDateTime dateReturn;
	

	public History(LocalDateTime localDateTime) {
		this.dateTaken = localDateTime;
	}


	public LocalDateTime getDateTaken() {
		return dateTaken;
	}


	public void setDateTaken(LocalDateTime dateTaken) {
		this.dateTaken = dateTaken;
	}


	public LocalDateTime getDateReturn() {
		return dateReturn;
	}


	public void setDateReturn(LocalDateTime dateReturn) {
		this.dateReturn = dateReturn;
	}
}
