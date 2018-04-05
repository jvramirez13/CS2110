
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;

public class GUILLOfFortune extends JFrame {
	JLabel instructions;
	JButton submit;
	JTextArea enterArea;
	
	JLabel livesRemaining;
	JLabel lettersEntered;
	JLabel wordOutput;
	
	
	boolean[] lettersCorrect = {false, false, false, false, false};
	int lives;
	String password;
	ArrayList<String> letters;
	
	public static void main(String[] args) {
		new GUILLOfFortune();
	}
	
	public GUILLOfFortune()
	{
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		int height = (int)Toolkit.getDefaultToolkit().getScreenSize().getHeight();
		int width = (int)Toolkit.getDefaultToolkit().getScreenSize().getWidth();
		this.setSize(width, height);
		
		password = "super";
		lives = 5;
		letters = new ArrayList<String>();
		
		instructions = new JLabel("<html>Enter a letter to see if it's in the word!</html>" );
		submit = new JButton("ENTER");
		enterArea = new JTextArea();
		livesRemaining = new JLabel("Lives: " + lives);
		lettersEntered = new JLabel("<html>Letters Entered: " + letters + "</html>");
		wordOutput = new JLabel("_ _ _ _ _");
		wordOutput.setFont(new Font("Times", Font.BOLD, 20));
		
		instructions.setSize(23*width/60, height/6);
		submit.setSize(width/3, 50);
		enterArea.setSize(width/3, 50);
		livesRemaining.setSize(width/4, height/12);
		lettersEntered.setSize(width/3, height/3);
		wordOutput.setSize(width/2, height/6);
		
		instructions.setLocation(width/15, 1);
		submit.setLocation(width/2, height/2);
		enterArea.setLocation(width/6, height/2);
		livesRemaining.setLocation(11*width/15, 1);
		lettersEntered.setLocation(17*width/30, height/20);
		wordOutput.setLocation(width/3, height/3);
		
		submit.addActionListener(new passwordButtonListener());
		
		this.add(instructions);
		this.add(submit);
		this.add(enterArea);
		this.add(livesRemaining);
		this.add(lettersEntered);
		this.add(wordOutput);
		
		this.add(new JLabel());
		this.setLocationRelativeTo(null);
		setVisible(true);
	}
	
	private class passwordButtonListener implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO: implement the action taken by the button.
			boolean isWon = true;
			String newOutput = "";
			
			//takes the input and change it into one character
			String charEntered =  enterArea.getText().substring(0, 1);
			if (!letters.contains(charEntered)) //verify that the entered character hasn't already been submitted
			{
				letters.add(charEntered); //add character to the list of entered characters
				if (password.contains(charEntered)) //see if the letter is correct
				{
					for (int i = 0; i < password.length(); i++) //rewrite the output
					{
						if (password.substring(i, i+1).equals(charEntered))
						{
							lettersCorrect[i] = true;
						}
					}
					for (int j = 0; j < password.length(); j++) 
					{
						if (lettersCorrect[j])
						{
							newOutput += password.substring(j, j+1) + " ";
						}
						else
						{
							newOutput += "_ ";
						}
					}
					wordOutput.setText(newOutput);
				}
				else //take off a life, guess was wrong
				{
					lives --;
				}
			}
			else //notify that the letter has been guessed
			{
				instructions.setText("Character already entered!");
			}
			//update components
			enterArea.setText("");
			livesRemaining.setText("<html>Lives: " + lives + "</html>");
			lettersEntered.setText("<html>Letters Entered: " + letters + "</html>");
			for (int i = 0; i < lettersCorrect.length; i++) //check to see if the word is completed
			{
				if (!lettersCorrect[i])
				{
					isWon = lettersCorrect[i];
				}
			}
			if (isWon)
			{
				instructions.setText("<html>You won!</html>");
				enterArea.setEnabled(false);
			}
		}
		
	}

}
