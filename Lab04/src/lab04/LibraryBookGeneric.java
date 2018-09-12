package lab04;

import java.util.GregorianCalendar;

public class LibraryBookGeneric<Type> extends Book {
	
	private Type holder;
	private GregorianCalendar dueDate;
	
	public LibraryBookGeneric(long isbn, String author, String title) {
		super(isbn, author, title);
	}
	
	public Type getHolder() {
		return this.holder;
	}
	
	public GregorianCalendar getDueDate() {
		return this.dueDate;
	}
	
	public void checkin() {
		this.holder = null;
		this.dueDate = null;
	}
	
	public void checkout(Type holder, GregorianCalendar dueDate) {
		this.holder = holder;
		this.dueDate = dueDate;
	}
	
	
}
