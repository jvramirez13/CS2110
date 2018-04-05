//jp6ud, Jay Park
//Homework 5

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class JayCalculator extends JFrame{
	private JFrame frame;
	private JPanel button, button1, panel, namePanel, hourPanel, gradePanel, yo, yeet, yolo, summary, coursePanel, reqPanel, tar, tar1, gpaPanel, insPanel, deladdPanel;
	private JLabel hours, grade, name, instructions, gpa, target, courseListLabel, delInstruction, tarInstruction;
	private JTextField hoursText, gradeText, nameText, targ, del, req;
	private JTextArea courseList;
	private JButton calculate, reset, adding, delete, required;
	private ButtonGroup radioButtonGroup;
	private ArrayList<String> courseName, letterGrade;
	private ArrayList<Double> creditHour, gpaGrade;



	public JayCalculator() {

		courseName = new ArrayList<String>();
		creditHour = new ArrayList<Double>();
		letterGrade = new ArrayList<String>();
		gpaGrade = new ArrayList<Double>();

		/** Set the title. **/
		setTitle("GPA Calculator");

		/** Set frame. **/
		frame = new JFrame();	    
		frame.setTitle("GPA Calculator");
		/*Dimension screenDimension = Toolkit.getDefaultToolkit().getScreenSize();
		int jFrameWidth = (int) Math.round(screenDimension.width * 0.5);
	    int jFrameHeight = (int) Math.round(screenDimension.height * 0.5);
	    frame.setBounds(600, 300, jFrameWidth,jFrameHeight);*/
		frame.setLayout(new BorderLayout());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		/** -----------------------------Build panels-------------------------------- **/
		
		/** Set up instructions. **/
		instructions = new JLabel("Calculate your GPA!");
		JLabel insContinue = new JLabel("You may add multiple courses, one at a time. You must include credit hours.");
		
		insPanel = new JPanel();
		insPanel.setLayout(new BorderLayout());
		insPanel.add(instructions, BorderLayout.NORTH);
		insPanel.add(insContinue, BorderLayout.CENTER);
		
		
		/** Building a panel to include the User input portion for Course Name, Credit Hours, and Letter Grade. **/
		name = new JLabel("(Optional) Course name:  ");
		nameText = new JTextField(10);

		hours = new JLabel("                   Credit hours:    ");
		hoursText = new JTextField(10);

		grade = new JLabel("(Optional) Letter grade:    ");
		gradeText = new JTextField(10);

		namePanel = new JPanel();
		namePanel.add(name);
		namePanel.add(nameText);

		hourPanel = new JPanel();
		hourPanel.add(hours);
		hourPanel.add(hoursText);

		gradePanel = new JPanel();
		gradePanel.add(grade);
		gradePanel.add(gradeText);

		panel = new JPanel();
		panel.setLayout(new BorderLayout());
		panel.add(namePanel, BorderLayout.CENTER);
		panel.add(hourPanel, BorderLayout.NORTH);
		panel.add(gradePanel, BorderLayout.SOUTH);



		/** Create buttons. **/
		adding = new JButton("Add");
		delete = new JButton("Delete");
		calculate = new JButton("Calculate");
		reset = new JButton("Reset");
		required = new JButton("Calculate required GPA");
		
		radioButtonGroup = new ButtonGroup();
		radioButtonGroup.add(calculate);
		radioButtonGroup.add(adding);
		radioButtonGroup.add(delete);
		radioButtonGroup.add(reset);
		radioButtonGroup.add(required);
		
		/** Add action listener. **/ 
		adding.addActionListener(new ButtonListener());
		delete.addActionListener(new ButtonListener());
		required.addActionListener(new ButtonListener());
		calculate.addActionListener(new ButtonListener());
		reset.addActionListener(new ButtonListener());
		
		
		/** Set up panel for target GPA. **/
		gpa = new JLabel("Current GPA: ");
		Font g = gpa.getFont();
		gpa.setFont(g.deriveFont(g.getStyle() | Font.BOLD));
		
		tarInstruction = new JLabel("<html>If you wish to calculate the GPA you need in order to reach a desired overall GPA, input your target GPA here.</html>");
		target = new JLabel("Target GPA: ");
		targ = new JTextField(5);
		
		tar = new JPanel();
		tar.add(target);
		tar.add(targ);

		
		/** Set up panel for required GPA. **/
		req = new JTextField(5);
		req.setEditable(false);
		
		reqPanel = new JPanel();
		reqPanel.add(required);
		reqPanel.add(req);
		
		/** Make panel for GPA. **/
		JLabel bleh = new JLabel("");
		gpaPanel = new JPanel();
		gpaPanel.setLayout(new BorderLayout());
		gpaPanel.add(gpa, BorderLayout.NORTH);
		gpaPanel.add(bleh, BorderLayout.CENTER);
		
		
		
		/** Group the target and required GPA panels together. **/
		tar1 = new JPanel();
		tar1.setLayout(new BorderLayout());
		tar1.add(tarInstruction, BorderLayout.NORTH);
		tar1.add(tar, BorderLayout.CENTER);
		tar1.add(reqPanel, BorderLayout.SOUTH);
		
		/** Set up panel for the first set up buttons to "calculate" and "reset". **/
		button1 = new JPanel();
		button1.add(calculate);
		button1.add(reset);
		

		/** Set up panel for the "add" and "delete" buttons. **/
		del = new JTextField(3);
		delInstruction = new JLabel("If you wish to delete a course, input the corresponding number and click \"Delete\".");
		
		deladdPanel = new JPanel();
		deladdPanel.add(adding);
		deladdPanel.add(delete);
		deladdPanel.add(del);
		
		button = new JPanel();
		button.setLayout(new BorderLayout());
		button.add(deladdPanel, BorderLayout.NORTH);
		button.add(delInstruction, BorderLayout.CENTER);



		/** Set up panel for displaying course lists the user inputed. **/
		courseListLabel = new JLabel("Courses: ");
		courseList = new JTextArea(5, 5); 
		courseList.setEditable(false);
		
		coursePanel = new JPanel();
		coursePanel.setLayout(new BorderLayout());
		coursePanel.add(courseListLabel, BorderLayout.NORTH);
		coursePanel.add(courseList, BorderLayout.CENTER);
		//coursePanel.add(button1, BorderLayout.SOUTH);


		/** Group the panels for target GPA, required GPA, and the current GPA into one panel. **/
		summary = new JPanel();
		summary.setLayout(new BorderLayout());
		summary.add(gpa, BorderLayout.NORTH);
		summary.add(tar1, BorderLayout.CENTER);
		summary.add(reqPanel, BorderLayout.SOUTH);



		/** Format all the created panels using Border Layout. **/
		yo = new JPanel();
		yo.setLayout(new BorderLayout());
		yo.add(insPanel, BorderLayout.NORTH);
		yo.add(panel, BorderLayout.CENTER);
		yo.add(button, BorderLayout.SOUTH);
		frame.add(yo, BorderLayout.NORTH);

		yeet = new JPanel();
		yeet.setLayout(new BorderLayout());
		yeet.add(coursePanel, BorderLayout.NORTH);
		yeet.add(courseList, BorderLayout.CENTER);
		yeet.add(button1, BorderLayout.SOUTH);
		frame.add(yeet, BorderLayout.CENTER);


	    yolo = new JPanel();    
	    yolo.setLayout(new BorderLayout());
	    yolo.add(summary);
	    frame.add(yolo, BorderLayout.SOUTH);


	    /** Display **/
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		frame.pack();


	}

	/** Create the action listener for the buttons. **/
	private class ButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			/** Create/set up variables needed for the buttons to perform its actions. **/
			String inputName, inputGrade;
			String inputHours;
			double inputHour, inputGPA, currentGPANom, currentGPADen, currentGPA, tGPA;

			currentGPANom = 0.0;
			currentGPADen = 0.0;
			currentGPA = 0.0;

			/** Get the entered course name, letter grade, and course hours. **/
			inputName = nameText.getText();
			inputGrade = gradeText.getText();
			inputHours = hoursText.getText();
			inputHour = Double.parseDouble(inputHours);
			


			/** -----------------------Determine which button was clicked----------------------- **/
			
			/** If the user clicked on "Add", add the course inputed by the user into the ArrayLists. **/
			if (e.getSource() == adding) {
				/** If the user didn't put in a name for the course, add "N/A" to the ArrayList courseName.
				 * Otherwise, add the name inputed by the user into the ArrayList. **/
				if (inputName.equals(null)) {
					courseName.add("N/A");
				}
				else {
					courseName.add(inputName);
				}
				
				/** If the user didn't put the credit hours for the course, send an error pop up message. 
				 * Otherwise, add the credit hours into the ArrayList creditHour. **/
				if (inputHours.equals(null)) {
					JOptionPane.showMessageDialog(null, "Error. You must input the credit hours.");
				}
				else {
					creditHour.add(inputHour);
				}
				
				/**  If the user didn't put in a name for the course, add null to the ArrayList letterGrade. 
				 * Otherwise, add the grade inputed by the user into the ArrayList. **/
				if (inputGrade.equals(null)) {
					letterGrade.add(null);
				}
				else {
					letterGrade.add(inputGrade);	
				}

				/** Set up or update the courseList that would be shown on the GPA Calculator. **/
				String box = "";
				
				for (int i = 1; i < creditHour.size()+1; i++) {
					box += "(" + i + ") " + courseName.get(i-1) + ", " + creditHour.get(i-1) + ", " + letterGrade.get(i-1) + "\n";
					courseList.setText(box);
				}
			}

			/** If the user clicked on "Calculate", calculate the current GPA." **/
			else if(e.getSource() == calculate) {
				for(int m = 0; m < letterGrade.size(); m++) {
					if (!letterGrade.get(m).equals("")) {
						if (letterGrade.get(m).equals("A")) {
							inputGPA = 4.0;
						}
						else if (letterGrade.get(m).equals("-A") || letterGrade.get(m).equals("A-")) {
							inputGPA = 3.7;
						}
						else if (letterGrade.get(m).equals("+B") || letterGrade.get(m).equals("B+")) {
							inputGPA = 3.3;
						}
						else if (letterGrade.get(m).equals("B")) {
							inputGPA = 3.0;
						}
						else if (letterGrade.get(m).equals("-B") || letterGrade.get(m).equals("B-")) {
							inputGPA = 2.7;
						}
						else if (letterGrade.get(m).equals("+C") || letterGrade.get(m).equals("C+")) {
							inputGPA = 2.3;
						}
						else if (letterGrade.get(m).equals("C")) {
							inputGPA = 2.0;
						}
						else if (letterGrade.get(m).equals("-C") || letterGrade.get(m).equals("C-")) {
							inputGPA = 1.7;
						}
						else if (letterGrade.get(m).equals("+D") || letterGrade.get(m).equals("D+")) {
							inputGPA = 1.3;
						}
						else if (letterGrade.get(m).equals("D")) {
							inputGPA = 1.0;
						}
						else {
							inputGPA = 0;
						}
					
						gpaGrade.add(inputGPA);
						
						currentGPANom += (inputGPA * creditHour.get(m)); 
						currentGPADen += (creditHour.get(m));
						currentGPA = currentGPANom / currentGPADen; 
						gpa.setText("Current GPA: " + currentGPA);
					}
					else {
						currentGPA += 0;
						gpaGrade.add(null);
					}	
				}
			}

			/** If the user clicked on "Delete," delete the selected course inputed by the user from the ArrayLists, and update iton the GPA Calculator. **/
			else if(e.getSource() == delete) {
				String delText = del.getText();
				int deleteNumber = Integer.parseInt(delText);
				courseName.remove(deleteNumber-1);
				creditHour.remove(deleteNumber-1);
				letterGrade.remove(deleteNumber-1);
			
				String box = "";
			
				for (int i = 1; i < creditHour.size()+1; i++) {
					box += "(" + i + ") " + courseName.get(i-1) + ", " + creditHour.get(i-1) + ", " + letterGrade.get(i-1) + "\n";
					courseList.setText(box);
				}
			}

			/** If the user clicked on "Reset," clear the ArrayLists, and update it on the GPA Calculator. **/
			else if(e.getSource() == reset){
				courseName.clear();
				creditHour.clear();
				letterGrade.clear();
				courseList.setText(null);
			}
		
			/** If the user clicked on "Calculate required GPA," calculate the required GPA the user needs to get in order to reach the user's target GPA. **/
			else {
				String targetGPA = targ.getText();
				tGPA = Double.parseDouble(targetGPA);
				
				double CreditHourswNoGrade = 0.0;
				double totalCreditHours = 0.0;
				double qwerty = 0.0;
				int blank = 0;
				for (int i = 0; i < gpaGrade.size(); i++) {
					if (gpaGrade.get(i) == null) {
						CreditHourswNoGrade += creditHour.get(i);
						totalCreditHours += creditHour.get(i);
						blank += 1;
					}
					else {
						qwerty += (gpaGrade.get(i)*creditHour.get(i));
						totalCreditHours += creditHour.get(i);
					}
				}

				if (blank == 0) {
					JOptionPane.showMessageDialog(null, "You can try taking more credit hours.");
				}
				
				double requiredGPA = (((tGPA) * totalCreditHours) - qwerty) / CreditHourswNoGrade;
				double requiredGPA1 = (double) Math.round(requiredGPA * 100) / 100;
				String reqGPA = Double.toString(requiredGPA1);
			
			
				if (requiredGPA > 4.0) {
					JOptionPane.showMessageDialog(null, "Warning. The required GPA is greater than 4.0. Try adding more credit hours and recalculating.");
				}
				else if(requiredGPA < 2.0) {
					JOptionPane.showMessageDialog(null, "Required GPA is less than 2.0. If you wish, you can take fewer credit hours.");
				}
				else {
					req.setText(reqGPA);
				}
			}
		}
	}

	public static void main(String[] args) {
		new JayCalculator();
	}
}


