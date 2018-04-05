import java.util.Random;
import java.util.*;

public class RandomWords {

	public static void main(String[] args) {
		String[] data = new String[500];
		String[] hashExample = generateRandomWords(200);
			
			

	}
	public static int stringToAscii(String s) {
		int asciiSum = 0;
		for(int i = 0; i < s.length(); i++) {
			char letter = s.charAt(i);
			int ascii = (int) letter;
			asciiSum = asciiSum + ascii;
		}
		return asciiSum;
	}
	public static int returnTotalHash(String[] stringList) {
		int totalHash = 0;
		for(int i = 0; i < stringList.length; i++) {
			String word = stringList[i];
			int asciiSingle = stringToAscii(word);
			totalHash = totalHash+asciiSingle;
		} return totalHash;
	}
	public static int hashIndex(int totalHash, int tableNumber) {
		int IndexHash = totalHash % tableNumber;
		return IndexHash;
	}
	

	//A static method that takes in the number or words you would like in your array of 
	//random words.  Each word is between 3 and 10 characters in length and contain only
	//lower case letters.  
	public static String[] generateRandomWords(int numberOfWords)
	{
	    String[] randomStrings = new String[numberOfWords];
	    Random random = new Random();
	    for(int i = 0; i < numberOfWords; i++)
	    {
	        char[] word = new char[random.nextInt(8)+3]; // words of length 3 through 10. (1 and 2 letter words are boring.)
	        for(int j = 0; j < word.length; j++)
	        {
	            word[j] = (char)('a' + random.nextInt(26));
	        }
	        randomStrings[i] = new String(word);
	    }
	    return randomStrings;
	}
}
