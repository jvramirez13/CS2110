//John Ramirez, jr5xw, Homework 4

public class Song implements Comparable<Song>, Playable{

	/**the artist performing the song
	 */
	private String artist;

	/**the title of the song
	 */
	private String title;

	/**number of min in length
	 */
	private int minutes;

	/**number of seconds of the song (always less than 60)
	 */
	private int seconds;

	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getMinutes() {
		return minutes;
	}

	public void setMinutes(int minutes) {
		this.minutes = minutes;
	}

	public int getSeconds() {
		return seconds;
	}

	public void setSeconds(int seconds) {
		this.seconds = seconds;
	}

	/**Constructor
	 * @param artist
	 * @param title
	 */
	public Song(String artist, String title) {
		this.artist = artist;
		this.title = title;
		this.minutes = 0;
		this.seconds = 0;

	}

	/**Constructor
	 * @param artist
	 * @param title
	 * @param minutes
	 * @param seconds
	 */
	public Song(String artist, String title, int minutes, int seconds) {
		this.artist = artist;
		this.title = title;
		this.minutes = minutes;
		this.seconds = seconds;

	}

	/**Constructor
	 * @param s
	 */
	public Song(Song s) {
		this.title = s.getTitle();
		this.artist = s.getArtist();
		this.minutes = s.getMinutes();
		this.seconds = s.getSeconds();
	}

	/**two songs are equal if all four fields are equal
	 */
	@Override
	public boolean equals(Object o) {
		if (o instanceof Song
				&& (artist.equalsIgnoreCase(((Song) o).getArtist()))
				&& (title.equalsIgnoreCase(((Song) o).getTitle()))
				&& (minutes == ((Song) o).getMinutes())
				&& (seconds == ((Song) o).getSeconds())) {
			return true;
		} else {
			return false;
		}
	}

	/**returns the Song playing
	 */
	@Override
	public void play() {
		System.out.printf("Playing Song: artist = %-20s title = %s\n", artist, title);

	}

	/** returns title (for Song) of Playable object
	 */
	@Override
	public String getName() {
		return title;
	}

	/**For Song: returns the number of seconds in the song
	 */
	@Override
	public int getPlayTimeSeconds() {
		return (this.minutes*60) + this.seconds;
	}

	/**For Song: returns 1
	 */
	@Override
	public int numberOfSongs() {
		return 1;
	}

	/**Songs will be ordered by the artist in ascending order
	 *If the artists are the same, then by title in ascending order. 
	 *If both artist and title are the same, then any order is acceptable
	 */
	@Override
	public int compareTo(Song o) {
		int compareVal = this.artist.compareTo(o.getArtist());
		if(compareVal != 0) {
			return compareVal;
		} else {
			return this.title.compareTo(o.getTitle());
		}
	}

	/**returns Song title and Song artist
	 */
	@Override
	public String toString() {
		return "{Song: title = " + title + " artist = " + artist + "}";
	}




}
