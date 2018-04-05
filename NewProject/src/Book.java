//John Ramirez, jr5xw, Homework 3

public class Book {

	private final String title, author;
	private String dueDate;
	private boolean checkedOut;
	private final int bookId;
	private double bookValue;

	public Book(String title, String author, int bookId, double bookValue) {
		this.title = title;
		this.author = author;
		this.bookId = bookId;
		this.bookValue = bookValue;
	}

	public String getDueDate() {
		return this.dueDate;
	}

	public void setDueDate(String dueDate) {
		this.dueDate = dueDate;
	}

	public boolean isCheckedOut() {
		return checkedOut;
	}

	public void setCheckedOut(boolean checkedOut) {
		this.checkedOut = checkedOut;
	}

	public double getBookValue() {
		return bookValue;
	}

	public void setBookValue(double bookValue) {
		this.bookValue = bookValue;
	}

	public int getBookId() {
		return bookId;
	}

	public String getTitle() {
		return this.title;
	}

	public String getAuthor() {
		return this.author;
	}
	//Method for checking whether title and author are equal
	public boolean equals(Object o) {
		if (o instanceof Book) {
			Book p1 = (Book) o;
			return (this.bookId == p1.bookId);
		} else {
			return false;
		}
	}
	//return the string of Book ID
	public String toString() {
		return "The book ID is: " + getBookId();
	}

}
