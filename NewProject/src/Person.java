//John Ramirez, jr5xw, Homework 3

import java.util.*;

public class Person {
	private String name;
	private final int id;
	private ArrayList<Book> checkedOut;
	private String address;
	private final int libraryCardNum;


	public Person(String name, String address, int libraryCardNum) {
		this.id = 0;
		this.name = name;
		this.checkedOut = new ArrayList<Book>();
		this.address = address;
		this.libraryCardNum = libraryCardNum;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getLibraryCardNum() {
		return libraryCardNum;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public ArrayList<Book> getRead() {
		return checkedOut;
	}


	public ArrayList<Book> getCheckedOut() {
		return checkedOut;
	}

	public void setCheckedOut(ArrayList<Book> checkedOut) {
		this.checkedOut = checkedOut;
	}

	//Method to add book if the list doesn't contain said book
	public boolean addBook(Book b) {
		if (checkedOut.contains(b)) {
			return false;
		} else {
			checkedOut.add(b);
			return true;
		}
	}
	//check to see if the list has the said book
	public boolean hasRead(Book b) {
		if (checkedOut.contains(b)) {
			return true;
		} else {
			return false;
		}
	}
	//removes book and check to see if it was removed
	public boolean forgetBook(Book b) {
		if(checkedOut.contains(b)) {
			checkedOut.remove(b);
			return true;
		} else {
			return false;
		}


	}
	//returns the size of book list
	public int numBooksRead() {
		return checkedOut.size();
	}
	//check to see if person id is the same as another person
	public boolean equals(Object o) {
		if (o instanceof Person) {
			Person p1 = (Person) o;
			return (this.libraryCardNum ==p1.libraryCardNum);
		} else {
			return false;
		}
	}
	//returns a string of person's name, id, and book list
	public String toString() {
		return "Person: " + name + "," + ", Library Card: " + getLibraryCardNum() + "," + ", Checked Out: " + checkedOut.toString() + ", Address: " + getAddress();
	}
	//returns a ArrayList of common books
	public static ArrayList<Book> commonBooks(Person a, Person b) {
		ArrayList<Book> sameBooks = new ArrayList<Book>();
		for(Book aRead: a.getRead()) {
			for(Book bRead: b.getRead()) {
				if(aRead.equals(bRead)) {
					sameBooks.add(aRead);
				}
			}
		}
		return sameBooks;
	}
	//returns similarity of two lists of books
	public static double similarity(Person a, Person b) {
		int common = commonBooks(a,b).size();
		if (common == 0) {
			return 0.0;
		} else {
			if (a.getRead().size() < b.getRead().size()) {
				return (double) common / (double) a.getRead().size();
			} else {
				return (double) common / (double) b.getRead().size();
			}
		}

	}

	public static void main(String [] args) {



	}
}
