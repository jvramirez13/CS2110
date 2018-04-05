//John Ramirez jr5xw

import javax.swing.*;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

public class GPACalculator extends JFrame {
	JPanel title, coursePanel, summaryPanel;
	JLabel courses, summary, titleLabel, courseName;
	JLabel creditHours, gradeLabel, targetGPALabel, currentGPALabel, enteredCoursesLabel, addLabel, creditHours2;
	JTextField courseField, creditField, gradeField, blankField;
	GridBagConstraints gbc, gbc1, gbc2, gbc3, gbc4, gbc5, gbc6, gbc7, gbc8, gbc9, gbc10, gbc11, gbc12, gbc13, gbc14, gbc15;
	JButton calculate, remove, removeAll, add, add15Blank;
	ArrayList<String> enteredCourses;
	double currentGPA, targetGPA, creditHoursNumber, numberOfCourses;
	JTextArea listEnteredCourses;

	//Constructor
	public GPACalculator() {
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);

		this.setSize(1300, 400);

		/** Initializing the JPanels **/
		title = new JPanel(new GridLayout(1,3));
		coursePanel = new JPanel(new GridBagLayout());
		summaryPanel = new JPanel(new GridBagLayout());
		
		/** Creating the constraints for the GridBagLayout **/
		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 0;

		gbc1 = new GridBagConstraints();
		gbc1.gridx = 0;
		gbc1.gridy = 10;


		gbc2 = new GridBagConstraints();
		gbc2.gridx = 0;
		gbc2.gridy = 100;

		gbc6 = new GridBagConstraints();
		gbc6.gridx = 0;
		gbc6.gridy = 200;

		gbc3 = new GridBagConstraints();
		gbc3.gridx = 1;
		gbc3.gridy = 0;

		gbc4 = new GridBagConstraints();
		gbc4.gridx = 1;
		gbc4.gridy = 10;

		gbc5 = new GridBagConstraints();
		gbc5.gridx = 1;
		gbc5.gridy = 100;

		gbc7 = new GridBagConstraints();
		gbc7.gridx = 1;
		gbc7.gridy = 200;

		gbc8 = new GridBagConstraints();
		gbc8.gridx = 100;
		gbc8.gridy = 0;

		gbc9 = new GridBagConstraints();
		gbc9.gridx = 100;
		gbc9.gridy = 500;

		gbc10 = new GridBagConstraints();
		gbc10.gridx = 0;
		gbc10.gridy = 300;

		gbc11 = new GridBagConstraints();
		gbc11.gridx = 1;
		gbc11.gridy = 300;

		gbc12 = new GridBagConstraints();
		gbc12.gridx = 0;
		gbc12.gridy = 400;

		gbc13 = new GridBagConstraints();
		gbc13.gridx = 1;
		gbc13.gridy = 400;

		gbc14 = new GridBagConstraints();
		gbc14.gridx = 0;
		gbc14.gridy = 500;
		gbc14.gridwidth = 2;
		gbc14.fill = GridBagConstraints.HORIZONTAL;

		gbc15 = new GridBagConstraints();
		gbc15.gridx = 100;
		gbc15.gridy = 100;


		/** Adding the JPanels to the GPACalculator JFrame **/
		this.add(title, BorderLayout.NORTH);
		this.add(summaryPanel, BorderLayout.CENTER);

		/** Initializing the GPAs, credit hours, and course number **/
		currentGPA = 0.0;
		targetGPA = 0.0;
		creditHoursNumber = 0.0;
		numberOfCourses = 0;

		/** Initializing the JLabels **/
		courses = new JLabel("COURSES");
		summary = new JLabel("SUMMARY");
		titleLabel = new JLabel("GPA Calculator");
		courseName = new JLabel("Course Name: ");
		creditHours = new JLabel("Credit Hours: ");
		gradeLabel = new JLabel("Grade: ");
		currentGPALabel = new JLabel("Current GPA: " + currentGPA);
		targetGPALabel = new JLabel("Target GPA: " + targetGPA);
		enteredCoursesLabel = new JLabel("Entered Courses: ");
		addLabel = new JLabel("Add: ");
		creditHours2 = new JLabel("Total Credit Hours: " + creditHoursNumber);

		/** Initializing the Course ArrayList **/
		enteredCourses = new ArrayList<String>();
		numberOfCourses = enteredCourses.size();

		/** Initializing the JTextfields **/
		courseField = new JTextField(10);
		creditField = new JTextField(10);
		gradeField = new JTextField(10);
		blankField = new JTextField(10);

		/** Initializing the JTextArea **/
		listEnteredCourses = new JTextArea(10,10);
		listEnteredCourses.setEditable(false);
		listEnteredCourses.append(enteredCourses + "\n");


		/** Initializing the Buttons as well as thhe ActionListeners **/
		calculate = new JButton("Calculate");
		remove = new JButton("Remove Course");
		removeAll = new JButton("Remove All Courses");
		add = new JButton("Add");
		add15Blank = new JButton("Add 15 Course Blocks");
		remove.addActionListener(new removeCourse());
		removeAll.addActionListener(new removeAllButtonListener());
		add15Blank.addActionListener(new add15BlankCoursesListener());
		add.addActionListener(new addCourseAndGrade());
		this.add(calculate, BorderLayout.SOUTH);

		this.add(coursePanel, BorderLayout.WEST);

		/** Adding the panels to the frames **/
		coursePanel.add(courseName, gbc);
		coursePanel.add(creditHours, gbc1);
		coursePanel.add(gradeLabel, gbc2);
		coursePanel.add(courseField, gbc3);
		coursePanel.add(creditField, gbc4);
		coursePanel.add(gradeField, gbc5);
		coursePanel.add(enteredCoursesLabel, gbc10);
		coursePanel.add(listEnteredCourses, gbc11);
		coursePanel.add(remove, gbc12);
		coursePanel.add(removeAll, gbc13);
		coursePanel.add(addLabel, gbc6);
		coursePanel.add(add, gbc7);
		coursePanel.add(add15Blank, gbc14);
		title.add(courses);
		title.add(titleLabel);
		title.add(summary, gbc2);
		summaryPanel.add(currentGPALabel, gbc8);
		summaryPanel.add(targetGPALabel, gbc9);
		summaryPanel.add(creditHours2, gbc15);



		/** Allows the frame to be visible **/
		setVisible(true);



	}

	/** Action Listener that allows the user to add Course and Grade **/
	private class addCourseAndGrade implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {


			//couldnt figure out method
			currentGPA = currentGPA + Double.parseDouble(gradeField.getText());

			currentGPA = currentGPA/numberOfCourses;
			currentGPALabel.setText("Current GPA: " + currentGPA);



			enteredCourses.add(courseField.getText());
			listEnteredCourses.append(enteredCourses.get(enteredCourses.size()-1) + "\n");

			creditHoursNumber = creditHoursNumber + Double.parseDouble(creditField.getText());
			creditHours2.setText("Total Credit Hours: " + creditHoursNumber);


		}
	}

	/** Action Listener that allows the user to remove all the courses in the JTextArea **/
	private class removeAllButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			enteredCourses.clear();
			listEnteredCourses.setText(enteredCourses + "\n");
		}
	}

	/** Action Listener that allows the user to add 15 blank courses **/
	private class add15BlankCoursesListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			enteredCourses.add("");
			listEnteredCourses.append(enteredCourses.get(enteredCourses.size()-1) + "\n");
			enteredCourses.add("");
			listEnteredCourses.append(enteredCourses.get(enteredCourses.size()-1) + "\n");
			enteredCourses.add("");
			listEnteredCourses.append(enteredCourses.get(enteredCourses.size()-1) + "\n");
			enteredCourses.add("");
			listEnteredCourses.append(enteredCourses.get(enteredCourses.size()-1) + "\n");
			enteredCourses.add("");
			listEnteredCourses.append(enteredCourses.get(enteredCourses.size()-1) + "\n");
			enteredCourses.add("");
			listEnteredCourses.append(enteredCourses.get(enteredCourses.size()-1) + "\n");
			enteredCourses.add("");
			listEnteredCourses.append(enteredCourses.get(enteredCourses.size()-1) + "\n");
			enteredCourses.add("");
			listEnteredCourses.append(enteredCourses.get(enteredCourses.size()-1) + "\n");
			enteredCourses.add("");
			listEnteredCourses.append(enteredCourses.get(enteredCourses.size()-1) + "\n");
			enteredCourses.add("");
			listEnteredCourses.append(enteredCourses.get(enteredCourses.size()-1) + "\n");
			enteredCourses.add("");
			listEnteredCourses.append(enteredCourses.get(enteredCourses.size()-1) + "\n");
			enteredCourses.add("");
			listEnteredCourses.append(enteredCourses.get(enteredCourses.size()-1) + "\n");
			enteredCourses.add("");
			listEnteredCourses.append(enteredCourses.get(enteredCourses.size()-1) + "\n");
			enteredCourses.add("");
			listEnteredCourses.append(enteredCourses.get(enteredCourses.size()-1) + "\n");
			enteredCourses.add("");
			listEnteredCourses.append(enteredCourses.get(enteredCourses.size()-1) + "\n");

		}
	}

	/** Action listener that allows you to select a course in the JTextArea and remove it **/
	private class removeCourse implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			listEnteredCourses.replaceSelection("");
			//listEnteredCourses.setText(listEnteredCourses.getText().replace(listEnteredCourses.getSelectedText(),""));
		}
	}


	public static void main(String[] args) {
		new GPACalculator();

	}

}
