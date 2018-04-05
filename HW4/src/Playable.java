//John Ramirez, jr5xw, Homework 4

public interface Playable {
	
	// play song
	public void play();
	
	//returns the name (for PlayList) or title (for Song) of Playable object
	public String getName();
	
	//For Song: returns the number of seconds in the song. 
	//For PlayList: returns the number of seconds in the entire PlayList
	public int getPlayTimeSeconds();
	
	//For Song: returns 1
	//For PlayList returns the number of songs in the playlist and all playlists contained within
	public int numberOfSongs();
	
	
	

}
