import javax.swing.*;
import java.awt.event.*;
import java.awt.*;


public class ClassPanel extends JFrame {

	private JPanel panel;
	private JLabel label;
	private JLabel label1;
	private JButton button;
	private JTextField text;
	private JRadioButton milesButton;
	private ButtonGroup radioButtonGroup; 

	public ClassPanel() {
		this.setTitle("Class Panel");
		this.setBounds(600,300,300,200);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		milesButton = new JRadioButton("Convert to miles");
		panel = new JPanel();
		panel.add(button);
		this.add(panel);
		label = new JLabel("This should output a result");
		label1 = new JLabel("This is the instruction");
		text = new JTextField(20);
		panel.add(label);
		panel.add(button, BorderLayout.SOUTH);
		panel.add(text);
		panel.add(label1);

		this.setVisible(true);

		button.addActionListener(new RadioButtonListener());

	}

	private class RadioButtonListener implements ActionListener
	   {
	      public void actionPerformed(ActionEvent e)
	      {
	         String input;          // To hold the user's input
	         String convertTo = ""; // The units we're converting to
	         double result = 0.0;   // To hold the conversion

	         // Get the kilometers entered.
	         input = text.getText();
	         
	         if(e.getSource()== milesButton) {
	        	 convertTo = " miles.";
	        	 result = Double.parseDouble(input) / 1.609344;
	         }
	          
	         JOptionPane.showMessageDialog(null,  input + " miles is " + result + convertTo);
	         radioButtonGroup.clearSelection();
	         // Determine which radio button was clicked.
	               }
	   }


		public static void main(String[] args) {
			new ClassPanel();

		}



	}
