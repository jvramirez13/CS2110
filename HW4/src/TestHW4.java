//John Ramirez, jr5xw, Homework 4

import static org.junit.Assert.assertEquals;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Collections;

import org.junit.Test;


public class TestHW4 {

	@Test
	public void test() {
		Song s1 = new Song("Carly Rae Jepsen", "Emotion", 3, 17);
		Song s2 = new Song("Carly Rae Jepsen", "Emotion", 3, 17);
		Song s3 = new Song("GoldLink", "Herside Story", 3, 3);
		Song s4 = new Song("BROCKHAMPTON", "GUMMY", 4, 21);
		ArrayList<Playable> p1 = new ArrayList<Playable>();
		ArrayList<Playable> p2 = new ArrayList<Playable>();
		PlayList play1 = new PlayList();
		PlayList play2 = new PlayList();
		play1.setPlayableList(p2);
		play2.setPlayableList(p1);
		p2.add(s1);
		p2.add(s3);
		p1.add(s1);
		p1.add(s4);
		p1.add(s3);


		//JUnit Tests dealing with Song Class
		assertTrue(s1.equals(s2));
		assertFalse(s1.equals(s3));
		assertEquals(s1.getName(), "Emotion");
		assertEquals(s3.getName(), "Herside Story");
		assertEquals(s1.getPlayTimeSeconds(), 197);
		assertEquals(s3.getPlayTimeSeconds(), 183);
		assertEquals(s3.numberOfSongs(), 1);
		assertEquals(s1.numberOfSongs(), 1);


		//JUnit Tests dealing with Playlist Class
		assertEquals(play1.getPlayTimeSeconds(), 380);
		assertEquals(play2.getPlayTimeSeconds(), 641);
		assertEquals(play1.numberOfSongs(), 2);
		assertEquals(play2.numberOfSongs(), 3);
		Collections.sort(p2, new compareByTime());
		assertTrue(p2.get(0) == s3);
		Collections.sort(p1, new compareByName());
		assertTrue(p1.get(0) == s1);

	}
}
