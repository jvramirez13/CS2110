import org.junit.Test;
import static org.junit.Assert.*;
import java.util.*;

public class Hw3Test {
	@Test
	public void libraryTest() {
		Library library = new Library("library");
		Library library1 = new Library("library1");
		Book book1 = new Book("Harry Potter", "J.K. Rowling", 106820, 20.00);
		Book book2 = new Book("The Hunger Games", "Suzzanne Collins", 302105, 9.00);
		Book book3 = new Book("A Game of Thrones", "George R. R. Martin", 502175, 21.00);
		Book book4 = new Book("Kingdom Keepers", "Ridley Pearson", 201502, 14.00);
		Book book5 = new Book("A Game of Thrones", "George R. R. Martin", 502175, 21.00);

		Person person1 = new Person("John Ramirez", "West Main St.", 12452);
		Person person2 = new Person("Jackie Strayer", "Jefferson Park Ave.", 60321 );
		ArrayList<Person> people = new ArrayList<Person>();
		ArrayList<Book> libBooks = new ArrayList<Book>();
		ArrayList<Book> libBooks1 = new ArrayList<Book>();
		book1.setDueDate("11 05 2017");
		book2.setDueDate("03 01 2017");
		book3.setDueDate("06 06 2017");

		people.add(person1);
		people.add(person2);
		library.setPatrons(people);

		person2.addBook(book1);
		person1.addBook(book2);

		libBooks.add(book1);
		libBooks.add(book2);
		libBooks.add(book3);
		libBooks.add(book4);
		libBooks.add(book5);
		libBooks1.add(book3);
		libBooks1.add(book1);
		library.setLibraryBooks(libBooks);
		library1.setLibraryBooks(libBooks1);


		assertEquals(2, library.checkNumCopies("A Game of Thrones", "George R. R. Martin"));
		assertEquals(1, library.checkNumCopies("Kingdom Keepers", "Ridley Pearson"));
		assertTrue(library.checkOut(person2, book1, "02 01 1900"));
		assertFalse(library.checkOut(person1, book1,"02 01 1900"));
		assertEquals(library.booksDueOnDate("06 06 2017"),library1.booksDueOnDate("06 06 2017"));
		assertEquals(library.booksDueOnDate("05 11 2017"),library1.booksDueOnDate("05 11 2017"));
		assertFalse(26.0 == library.lateFee(person2));
		assertFalse(18.0 == library.lateFee(person1));


	}

}
