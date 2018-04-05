//John Ramirez, jr5xw, Homework 4

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class PlayList implements Comparator<Playable>, Playable{

	/**contains the name of the playlist
	 */
	private String name;

	/**ArrayList of Playable elements that make up the playlist
	 */
	private ArrayList<Playable> playableList;

	/**Constructor
	 */
	public PlayList() {
		this.name = "Untitled";
		this.playableList = new ArrayList<Playable>();
	}

	/**Constructor
	 * @param newName
	 */
	public PlayList(String newName) {
		this.name = newName;
		this.playableList = new ArrayList<Playable>();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<Playable> getPlayableList() {
		return playableList;
	}

	public void setPlayableList(ArrayList<Playable> playableList) {
		this.playableList = playableList;
	}

	/** returns the name of the playlist followed by its contents
	 */
	public String toString() {
		String content = this.name + "\n";
		for(Playable pl: playableList) {
			content = content + pl.toString() +"\n";
		}
		return content;
	}

	/**plays the playlist by calling play() on each item in the playlist in order
	 */
	@Override
	public void play() {
		for(Playable pl: playableList) {
			pl.play();
		}

	}



	/**For PlayList: returns the number of seconds in the entire PlayList 
	 */
	@Override
	public int getPlayTimeSeconds() {
		int totalSeconds = 0;
		for(Playable pl: playableList) {
			totalSeconds = totalSeconds + (pl.getPlayTimeSeconds());
		}
		return totalSeconds;

	}

	/**For PlayList returns the number of songs in the playlist and all playlists contained within
	 */
	@Override
	public int numberOfSongs() {
		int numberSongs = 0;
		for(Playable pl: playableList) {
			numberSongs = numberSongs + pl.numberOfSongs();
		}
		return numberSongs;
	}

	/**loads songs from file
	 * @param fileName
	 * @return
	 */
	public boolean loadSongs(String fileName) {
		File input = new File(fileName);
		Scanner inputFile;
		try{
			inputFile = new Scanner(input);
		} catch(FileNotFoundException e) {
			return false;
		}
		while(inputFile.hasNextLine()){
			String title = inputFile.nextLine().trim();
			String artist = inputFile.nextLine().trim();
			String time = inputFile.nextLine().trim();
			int minutes = Integer.parseInt(time.substring(0, time.indexOf(':')));
			int seconds = Integer.parseInt(time.substring(time.indexOf(':')+1));

			inputFile.nextLine();

			Song s = new Song(artist, title, minutes, seconds);
			this.addSong(s);
		}
		inputFile.close();
		return true;

	}
	/**
	 * Adds song to playlist
	 * @param s
	 * @return
	 */
	public boolean addSong(Song s){
		return playableList.add(s);
	}

	/**removes all playable elements in the playlist
	 * @return
	 */
	public boolean clear() {
		playableList.clear();
		return true;

	}

	/**removes every occurrence of Playable p from the list and returns p
	 * @param index
	 * @return
	 */
	public Playable removePlayable(int index) {
		if(index < 0 || index >= playableList.size()){
			return null;
		}
		return playableList.remove(index);
	}

	/**removes every occurrence of Playable p from the list and returns p
	 * @param p
	 * @return
	 */
	public Playable removePlayable(Playable p) {
		while(playableList.contains(p)){
			playableList.remove(p);
		}
		return p;
	}


	/**returns the Playable element at the appropriate index
	 * @param index
	 * @return
	 */
	public Playable getPlayable(int index) {
		if(index < 0 || index >= playableList.size()){
			return null;
		}
		return playableList.get(index);
	}

	/**adds the PlayList that is being passed to the end of the playableList 
	 *and returns true unless the playableList already contains a playlist with the same name, 
	 *in this case, do not add the playlist and return false
	 */
	public boolean addPlayList(PlayList pl) {
		if(playableList.contains(pl)) {
			return false;
		} else {
			playableList.add(pl);
			return true;
		}

	}

	/**This method will sort the Playable items by the value returned by getName() in ascending order
	 */
	public void sortByName() {
		Collections.sort(playableList,new compareByName());
	}

	/**sorts by the Song or PlayList's total time in seconds, in ascending order (shortest first)
	 */
	public void sortByTime() {
		Collections.sort(playableList, new compareByTime());
	}

	@Override
	public int compare(Playable o1, Playable o2) {
		if(o1.getPlayTimeSeconds() < o2.getPlayTimeSeconds()) {
			return -1;
		} else if (o1.getPlayTimeSeconds() > o2.getPlayTimeSeconds()) {
			return 1;
		} else {
			return 0;
		}
	}



}
