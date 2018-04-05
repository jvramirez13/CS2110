import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.locks.Lock;

/**
   Counts how many words in a file.
*/
public class WordCountRunnable implements Runnable
{
   private String filename;
   /**
      Constructs a WordCountRunnable object with a file name.
      @param aFilename the file name that needs to count word
   */
   
   private static int threadCount;
   private static int combinedWordCount;
   
   
   public WordCountRunnable(String aFilename)
   {
      filename = aFilename;
      threadCount = 0;
      combinedWordCount = 0;
   }

   public void run()
   {
	int count = 0;
      try
      {
         Scanner in = new Scanner(new FileInputStream(filename));

         while (in.hasNext())
         {
            in.next();
            count++;
            combinedWordCount++;
            threadCount =+ java.lang.Thread.activeCount();
         }
         in.close();
      } 
      catch (FileNotFoundException e)
      {
         System.out.println(filename + " not found!");
      }
      System.out.println(filename + ": " + count);
   }
}
