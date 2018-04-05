//John Ramirez, jr5xw, Homework 3

import java.util.*;


public class Library {

	private ArrayList<Book> libraryBooks;
	private ArrayList<Person> patrons;
	private String name, currentDate;
	private int numBooks, numPeople;

	public Library(String name) {
		this.name = name;
		this.libraryBooks = new ArrayList<Book>();
		this.patrons = new ArrayList<Person>();
		this.currentDate = "20 09 2017";


	}

	public ArrayList<Book> getLibraryBooks() {
		return libraryBooks;
	}

	public void setLibraryBooks(ArrayList<Book> libraryBooks) {
		this.libraryBooks = libraryBooks;
	}

	public ArrayList<Person> getPatrons() {
		return patrons;
	}

	public void setPatrons(ArrayList<Person> patrons) {
		this.patrons = patrons;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCurrentDate() {
		return currentDate;
	}

	public void setCurrentDate(String currentDate) {
		this.currentDate = currentDate;
	}

	public int getNumBooks() {
		int counter = 0;
		for(int i = 0; i < libraryBooks.size(); i++)
		{
			if(!libraryBooks.get(i).isCheckedOut())
			{
				counter++;
			}
		}

		numBooks = counter;
		return numBooks;
	}
	
	public int getNumPeople() {
		numPeople = patrons.size();
		return numPeople;
	}

	//method that returns the number of copies of a certain book in the library
	public int checkNumCopies(String title, String author) {
		int numberCopies = 0;
		for(Book n: libraryBooks) {
			if (n.getTitle().equals(title) &&  n.getAuthor().equals(author)) {
				numberCopies++;
			}
		}
		return numberCopies;
	}

	public int totalNumBooks() {
		return libraryBooks.size();
	}
	//method that checks out the iff the person is a patron and the book is in the library and isn't currently checked out
	public boolean checkOut(Person p, Book b, String dueDate) {
		if(patrons.contains(p) && libraryBooks.contains(b) && !b.isCheckedOut()) {
			int index = libraryBooks.indexOf(b);
			p.addBook(libraryBooks.get(index));
			libraryBooks.get(index).setDueDate(dueDate);
			libraryBooks.get(index).setCheckedOut(true);
			return true;
		}else
		{
			return false;
		}

	}

	//returns an array list of books with the same due date
	public ArrayList<Book> booksDueOnDate(String date) {
		ArrayList<Book> booksDue = new ArrayList<Book>();
		for (Book n: this.libraryBooks) {
			if (n.isCheckedOut() && date == n.getDueDate()) {
				booksDue.add(n);
			}
		}
		return booksDue;
	}
//this method will calculate the late fee that a person owes
	public double lateFee (Person p){
		double lateFee = 0.0;
		double totalValue = 0.0;
		for (Book i: p.getRead()){
			String year = i.getDueDate().substring(6,10);
			int years = Integer.parseInt(year);
			String month = i.getDueDate().substring(3,5);
			int months = Integer.parseInt(month);
			String day = i.getDueDate().substring(0,2);
			int days = Integer.parseInt(day);
			String currentYear = getCurrentDate().substring(6,10);
			int currentYears = Integer.parseInt(currentYear);
			String currentMonth = getCurrentDate().substring(3,5);
			int currentMonths = Integer.parseInt(currentMonth);
			String currentDay = getCurrentDate().substring(0,2);
			int currentDays = Integer.parseInt(currentDay);

			Calendar dueDate = new GregorianCalendar(years, months, days);
			Calendar currentDate = new GregorianCalendar(currentYears, currentMonths, currentDays);
			long dueDateMilli = dueDate.getTimeInMillis();
			long currentDateMilli = currentDate.getTimeInMillis();
			if(currentDate.after(dueDate)) {
				double dateDifference = currentDateMilli - dueDateMilli;
				double daysOverDue = (dateDifference/8.64e7);
				lateFee = (daysOverDue * (i.getBookValue() * .01));
				totalValue = lateFee + totalValue;
			} else {
				lateFee = 0.0;
			}
		}
		return totalValue;
	}






}
