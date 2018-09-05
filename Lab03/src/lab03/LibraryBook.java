package lab03;

import java.util.GregorianCalendar;

public class LibraryBook extends Book {
	
	private String holder;
	private GregorianCalendar dueDate;
	
	public LibraryBook(long isbn, String author, String title) {
		super(isbn, author, title);
	}
	
	public String getHolder() {
		return this.holder;
	}
	
	public GregorianCalendar getDueDate() {
		return this.dueDate;
	}
	
	public void checkin() {
		this.holder = null;
		this.dueDate = null;
	}
	
	public void checkout(String holder, GregorianCalendar dueDate) {
		this.holder = holder;
		this.dueDate = dueDate;
	}
	
	
}
