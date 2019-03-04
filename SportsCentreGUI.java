import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.io.*;
import java.lang.reflect.Array;

/**
 * Defines a GUI that displays details of a FitnessProgram object
 * and contains buttons enabling access to the required functionality.
 */
public class SportsCentreGUI extends JFrame implements ActionListener {
	
	private static final String String = null;
	/** GUI JButtons */
	private JButton closeButton, attendanceButton;
	private JButton addButton, deleteButton;

	/** GUI JTextFields */
	private JTextField idIn, classIn, tutorIn;

	/** Display of class timetable */
	private JTextArea display;

	/** Display of attendance information */
	private ReportFrame report;

	/** Names of input text files */
	private final String classesInFile = "ClassesIn.txt";
	private final String classesOutFile = "ClassesOut.txt";
	private final String attendancesFile = "AttendancesIn.txt";
	private FileReader reader = null; 
	private FileWriter writer = null; 
	private String classId, className, tutorName, startTime; 
	private FitnessProgram fitnessProgram; 
	
	/**
	 * Constructor for AssEx3GUI class
	 */
	public SportsCentreGUI() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Boyd-Orr Sports Centre");
		setSize(700, 300);
		display = new JTextArea();
		display.setFont(new Font("Courier", Font.PLAIN, 14));
		add(display, BorderLayout.CENTER);
		layoutTop();
		layoutBottom();
		// more code needed here
		
		fitnessProgram = new FitnessProgram();
		
		initLadiesDay();
		
		initAttendances();
		
		updateDisplay(); 
	}

	/**
	 * Creates the FitnessProgram list ordered by start time
	 * using data from the file ClassesIn.txt
	 * @throws IOException 
	 */
	public void initLadiesDay() {
		
		BufferedReader breader = null; 	
		
			try {
				breader = new BufferedReader(new FileReader(classesInFile)); 
				String line = null;
				line = breader.readLine();
					while(line != null) {
						FitnessClass fitnessClass = new FitnessClass(line); 
						fitnessProgram.setFitnessClass(fitnessClass);
						line = breader.readLine();
					}
					System.out.println();
			}
			catch(Exception e) {
				
			}
			finally {
				try {
					breader.close();
				}
				catch(IOException e) {
					
				}
			}

	}

	
					
	

	



	/**
	 * Initialises the attendances using data
	 * from the file AttendancesIn.txt
	 */
	public void initAttendances() {
	    // your code here
		BufferedReader breader = null; 	
		
		try {
			breader = new BufferedReader(new FileReader(attendancesFile)); 
			String line = null;
			line = breader.readLine();
				while(line != null) {
					FitnessClass fitnessClass = new FitnessClass(line); 
					//fitnessProgram.setAttendances(fitnessClass);
					line = breader.readLine();
				}
				System.out.println();
		}
		catch(Exception e) {
			
		}
		finally {
			try {
				breader.close();
			}
			catch(IOException e) {
				
			}
		}
		
	}

	/**
	 * Instantiates timetable display and adds it to GUI
	 * @return 
	 */
	public void updateDisplay() {
	    // your code here
		//update class information  
		String startTimes = "";
		String className = "";
		String tutorName = ""; 
		
		for(int i = 0; i < fitnessProgram.getNumberOfFitnessClasses(); i++) {
			FitnessClass fitnessClass = fitnessProgram.getFitnessClassAtIndex(i); 
			int startTime = i + FitnessProgram.FIRST_START_TIME;
			startTimes += java.lang.String.format("%-12s", startTime + "-" + (startTime + 1));
			if(fitnessClass != null) {
			className += java.lang.String.format("%-12s", fitnessClass.getClassName());
			tutorName += java.lang.String.format("%-12s", fitnessClass.getTutor()); 
			}
			else {
				className += "Available  ";
				tutorName += "           "; 
			}
		}
		display.setText(startTimes + '\n' + className + '\n' + tutorName);
		System.out.println(display);
		
	}

	/**
	 * adds buttons to top of GUI
	 */
	public void layoutTop() {
		JPanel top = new JPanel();
		closeButton = new JButton("Save and Exit");
		closeButton.addActionListener(this);
		top.add(closeButton);
		attendanceButton = new JButton("View Attendances");
		attendanceButton.addActionListener(this);
		top.add(attendanceButton);
		add(top, BorderLayout.NORTH);
	}

	/**
	 * adds labels, text fields and buttons to bottom of GUI
	 */
	public void layoutBottom() {
		// instantiate panel for bottom of display
		JPanel bottom = new JPanel(new GridLayout(3, 3));

		// add upper label, text field and button
		JLabel idLabel = new JLabel("Enter Class Id");
		bottom.add(idLabel);
		idIn = new JTextField();
		bottom.add(idIn);
		JPanel panel1 = new JPanel();
		addButton = new JButton("Add");
		addButton.addActionListener(this);
		panel1.add(addButton);
		bottom.add(panel1);

		// add middle label, text field and button
		JLabel nmeLabel = new JLabel("Enter Class Name");
		bottom.add(nmeLabel);
		classIn = new JTextField();
		bottom.add(classIn);
		JPanel panel2 = new JPanel();
		deleteButton = new JButton("Delete");
		deleteButton.addActionListener(this);
		panel2.add(deleteButton);
		bottom.add(panel2);

		// add lower label text field and button
		JLabel tutLabel = new JLabel("Enter Tutor Name");
		bottom.add(tutLabel);
		tutorIn = new JTextField();
		bottom.add(tutorIn);

		add(bottom, BorderLayout.SOUTH);
	}

	/**
	 * Processes adding a class
	 */
	public void processAdding() {
	    // your code here
		idIn.getText(); 
		classIn.getText(); 
		tutorIn.getText(); 
		idIn.setText(" "); 
		classIn.setText(" ");
		tutorIn.setText(" ");
		
		classId = idIn.getText(); 
		className = classIn.getText(); 
		tutorName = tutorIn.getText();
		System.out.println("Hazzah! Added class"); 
		//classId = int.parse(classId.getText()); 
		
	}
	

	

	/**
	 * Processes deleting a class
	 * @throws FileNotFoundException 
	 */
	public void processDeletion() throws FileNotFoundException {
	    // your code here
		idIn.getText(); 
		classIn.getText();
		tutorIn.getText(); 

		FileReader reader2 = new FileReader("ClassesIn.txt"); 
		

		//BufferedReader reader = new BufferedReader(new FileReader(inputFile));
		//BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));
		
		String lineToRemove = idIn.getText();
		String currentLine;

		//while((currentLine = reader2.readLine()) != null) {
		    // trim newline when comparing with lineToRemove
		  //  String trimmedLine = currentLine.trim();
		  //  if(trimmedLine.equals(lineToRemove)) continue;
		  //  writer.write(currentLine + System.getProperty("line.separator"));
		
		System.out.println("Boo - you deleted a class" );
		}
		
		
	//}

	/**
	 * Instantiates a new window and displays the attendance report
	 */
	public void displayReport() {
	    // your code here
	
			ReportFrame reportFrame = new ReportFrame(fitnessProgram);
			reportFrame.setVisible(true);
		}
	
	

	/**
	 * Writes lines to file representing class name, 
	 * tutor and start time and then exits from the program
	 */
	public void processSaveAndClose() {
	    // your code here
		BufferedWriter saveWriter = null; 
		try {
			saveWriter = new BufferedWriter(new FileWriter(classesOutFile));
		for(int i = 0; i < fitnessProgram.getNumberOfFitnessClasses(); i++) {
			FitnessClass fitnessClass = fitnessProgram.getFitnessClassAtIndex(i);
			if(fitnessClass != null){
				StringBuffer saveInfo = new StringBuffer(100); 
				saveInfo.append(fitnessClass.getID()); 
				saveInfo.append(" "); 
				saveInfo.append(fitnessClass.getClassName());
				saveInfo.append(" ");
				saveInfo.append(fitnessClass.getTutor());
				saveInfo.append(" ");
				saveInfo.append(fitnessClass.getStartTime()); 
				
			}
			}
			
		}
		catch(Exception e) {
		}
			finally {
				try {
					saveWriter.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
				System.out.println("Done & done");
				System.exit(0);
			}
		}
		
		
	


	/**
	 * Process button clicks.
	 * @param ae the ActionEvent
	 */
	public void actionPerformed(ActionEvent ae) {
	    // your code here
		if (ae.getSource() == addButton) {
			processAdding();
	}
		else if(ae.getSource() == deleteButton) {
			try {
				processDeletion();
			} catch (FileNotFoundException e) {
				//why do I need a catch?
				e.printStackTrace();
			} 
		}
		else if(ae.getSource() == attendanceButton) {
			displayReport(); 
		}
		else if(ae.getSource() == closeButton) {
			processSaveAndClose(); 
		}
}
}
