
	import javax.swing.*;
	import java.awt.*;
	import java.awt.event.*;
	import java.util.ArrayList;
	import java.text.DecimalFormat;

	public class GPAExample extends JFrame{

		private JPanel panel,panelAtas;
		private JButton btnEnter,btnKira;
		private JLabel display,displayGpa;
		private JTextField namaSubjek,creditHour;

		double totalCredit=0.0;
		double realGrade=0.0;
		double result=0.0;
		double gpa=0.0;
		int i=0;
		String displayText="";

		ArrayList<String> name = new ArrayList<String>();
		ArrayList<Double> gradeList = new ArrayList<Double>();
		ArrayList<Integer> credit = new ArrayList<Integer>();

		//constuctor create frame
		public GPAExample(){
			final String[] grade = {"-","A+","A","A-","B+","B","B-","C+","C","C-","D+","D","D-","E"};


			setTitle("MyFrame");
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setSize(400,300);

			setLocationRelativeTo(null);

			final JComboBox<String> comboGrade = new JComboBox<String>(grade);

			display = new JLabel("");
			displayGpa = new JLabel("");

			namaSubjek = new JTextField(10);
			creditHour = new JTextField(3);


			btnEnter = new JButton("Insert");

			btnEnter.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					name.add(namaSubjek.getText());
					credit.add(Integer.parseInt(creditHour.getText()));
					//System.out.println(name.get(i)+"\t"+gradeList.get(i)+"\t"+credit.get(i));
					displayText+=name.get(i)+" "+gradeList.get(i)+" "+credit.get(i)+" \n";
					display.setText(displayText);

					i++;
				}
			});

			btnKira = new JButton("Calculate!");
			btnKira.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){

					DecimalFormat f = new DecimalFormat("##.##");
					double GPA=calcGpa();
					System.out.println(f.format(GPA));
					displayGpa.setText("GPA:"+f.format(GPA));
				}
			});

			comboGrade.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent ie){
					String str = (String)comboGrade.getSelectedItem();
					gradeList.add(setGrade(str));
				}
			});



			panel = new JPanel();	
			panelAtas = new JPanel();

			//panelAtas.add(display);

			//add component to panel
			panel.add(namaSubjek);

			panel.add(comboGrade);
			panel.add(creditHour);
			panel.add(btnEnter);
			panel.add(btnKira);
			panel.add(display);
			panel.add(displayGpa);



			//add panel to frame
			add(panel);

			//personalization
			namaSubjek.setPreferredSize(btnKira.getPreferredSize());	
			creditHour.setPreferredSize(btnKira.getPreferredSize());	
			setVisible(true);



		}

		public double setGrade(String g){

			//for(int i=0;i<grade.size();i++){

			if(g.equals("A+")){
				realGrade=4.0;				
			}
			else if(g.equals("A")){
				realGrade=4.0;
			}
			else if(g.equals("A-")){
				realGrade=3.67;			
			}
			else if(g.equals("B+")){
				realGrade=3.33;			
			}
			else if(g.equals("B")){
				realGrade=3.00;			
			}
			else if(g.equals("B-")){
				realGrade=2.67;			
			}
			else if(g.equals("C+")){
				realGrade=2.33;			
			}
			else if(g.equals("C")){
				realGrade=2.00;			
			}
			else if(g.equals("C-")){
				realGrade=1.67;			
			}		
			else if(g.equals("D+")){
				realGrade=1.33;			
			}
			else if(g.equals("D")){
				realGrade=1.00;			
			}
			else if(g.equals("D-")){
				realGrade=0.67;			
			}			
			else if(g.equals("E")){
				realGrade=0.00;			
			}		

			return realGrade;

		}

		public double calcGpa(){

			for(int j=0;j<name.size();j++){
				result = result+gradeList.get(j)*credit.get(j);
				totalCredit=totalCredit+credit.get(j);
				gpa=result/totalCredit;
			}

			return gpa;
		}
		
		public static void main(String[] args){
			new GPAExample();
			//System.out.println("Nama Subjek \t Grade \t Credit Hour");

		}

	}
