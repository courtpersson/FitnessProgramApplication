import java.util.*;

/**
 * Maintains a list of Fitness Class objects
 * The list is initialised in order of start time
 * The methods allow objects to be added and deleted from the list
 * In addition an array can be returned in order of average attendance
 */
	public class FitnessProgram {
	
	public int idIn; 
	public String classIn, tutorIn; 
	private FitnessClass [] classes; 
	private int CurrentClasses =0; 
	public static final int MAXCLASS = 7; 
	public static final int FIRST_START_TIME = 9;
 
	
	public FitnessProgram() {
		classes = new FitnessClass[MAXCLASS]; 
	}
	
	public int getNumberOfFitnessClasses() {
		return classes.length; 
	}
	
	public void setFitnessClass(FitnessClass fitnessClass) {
		insertFitnessClassAtIndex(fitnessClass.getStartTime() - FIRST_START_TIME, fitnessClass); 
	}
	
	public FitnessClass getFitnessClassAtIndex(int z) {
		return classes[z]; 
	}
	
	private void setFitnessClassAtIndex(int z, FitnessClass fitnessClass) {
		classes[z] = fitnessClass;
	}
	
	public void insertFitnessClassAtIndex(int z, FitnessClass fitnessClass) {
		setFitnessClassAtIndex(z, fitnessClass);
		CurrentClasses++;
	}
	
	public void deleteFitnessClassAtTime(int z) {
		setFitnessClassAtIndex(z, null); 
		CurrentClasses--; 
	}
	
	public FitnessClass getFitnessClassAtTime(int t) {
		return classes[t - FIRST_START_TIME];
		
	}
	
	//private int getCurrentClasses() {
	//	return currentClasses; 
	
	
	public int getEarliestStartTime() {
		for(int i = 0; i < classes.length; i++) {
			if(classes[i] == null) {
				return i + FIRST_START_TIME; 
			}
		}
		return -1; 
	}
	
	//public void SetFitnessClassAttendance(String line) {
	//	String[] classDetails = line.split("");
	//	String id = (classDetails[0]); 
	//	for(int i = 0; i < classes.length; i ++) {
	//		if(classes[i] != null && classes[i].getID().equalsIgnoreCase(id)) {
	//			classes[i].SetAttendance(line); 
	 
	//break; 
				
	//		}
	//	}
	//}

	public boolean DeleteFitnessID(String id) {
		for(int i =0; i < classes.length; i++) {
			if(classes[i] != null && classes[i].getID().equalIgnoreCase(id)) {
				deleteFitnessClassAtIndex(i); 
				return true; 
			}
		}
		return false; 
	}
	
	public FitnessClass getFitnessClassID(String line) {
		String[] classDetails = line.split(" ");
		String id = classDetails[0];
		for(int i= 0; i < classes.length; i++); 
		if(classes[i] != null && classes[i].getID().equalsIgnoreCase(id)) {
			classes[i].SetAttendance(line);
			break; 
		}
		
	}
	
	public FitnessClass[] getSortedClasses() {
		int CurrentClasses = getNumberOfFitnessClasses();
		FitnessClass[] duplicate = new FitnessClass[CurrentClasses]; 
		for(int i = 0; j = 0; i < classes.length; i++) {
			if(classes[i] != null) {
				duplicate[j] = classes[i]
						j++; 
			}
		}
		Arrays.sort(duplicate);
		return duplicate; 
	}

}
