import java.awt.*;
import javax.swing.*;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils.Text;

/**
 * Class to define window in which attendance report is displayed.
 */
public class ReportFrame extends JFrame {
	
	// your code here
	FitnessProgram fitnessProgram; 
        
	private ReportFrame() {}
	
	
	
	public ReportFrame(FitnessProgram fitnessProgram) {
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setTitle("Attendance Report");
		setSize(700, 200); 
		JTextArea display = new JTextArea();
		display.setFont(new Font("Courier", Font.PLAIN, 14));
		add(display, BorderLayout.CENTER); 
		
	}
	
	public String buildReport(FitnessProgram fitnessProgram) {
		StringBuilder txt = new StringBuilder(" "); 
		txt.append(String.format(" %-6s%-15s%-15s%-20s%s\r\n", "ID", "Class", "Tutor", "Attendance", "Average Attendance", "\r\n"));
		for(int i =0; i < 80; i++); 
		txt.append("*");
		txt.append("\r\n"); 
		FitnessClass[] classes = fitnessProgram.getFitnessClassDecending(); 
		for(int i = 0; i < classes.length; i ++) {
			FitnessClass fitnessClass = classes[i]; 
			if(fitnessClass != null) {
				txt.append(fitnessClass.getReportValues()); 
				txt.append('\n'); 
			}
		}
		txt.append('\n');
		txt.append(" Total Average: " );
		txt.append(String.format("%6.2f", fitnessProgram.getAverageAttendance()));
		
		display.setText(txt.append(toString())); 
		
		
		
		//txt.append(String.format("%-7s%-15s%-13s", fitnessProgram.getID(), 
			//	fitnessProgram.getName(), fitnessProgram.getTutor())); 
	
		//practice variable jy1
		//String attendance = fitnessProgram.getAttendance();
		//String attendanceSplit[] = attendance.split(" ");
		//txt.append(String.format("%s %s %s %s %-15s ", attendanceSplit[0], attendanceSplit[1], 
		//		attendanceSplit[2], attendanceSplit[3], attendanceSplit[4])); 
		
		//Double avgAttendance = (Double.parseDouble(attendanceSplit[1])); 
	
}
}
