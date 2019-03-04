/** Defines an object representing a single fitness class
 */
public class FitnessClass implements Comparable<FitnessClass> {
    // your code here
    
    private String id;
    private String name; 
    private String tutor; 
    private int startTime; 
    public final int AttendanceAverage = 5; 
    private int[] attendance; //= new int[ATTENDANCES];  
    

    
    public FitnessClass(String line) {
    String[] classDetailslist = line.split(" ");
    setID(classDetailslist [0]);
    setName(classDetailslist [1]);
    setTutor(classDetailslist [2]);
    setStartTime(Integer.parseInt(classDetailslist[3]));
    //attendance = new String[AttendanceAverage]; 
    }
    
 

	public FitnessClass (String id, String className, String tutorName, int startTime) {
    	
    	setID(id); 
    	setName(className);
    	setTutor(tutorName);
    	setStartTime(startTime); 
    
    }


public String getID() {
	return id; 
}

public void setID(String id) {
	this.id = id; 
	
}

public String getClassName() {
	return name; 
}

public void setName(String className) {
	this.name = className; 
}

public String getTutor() {
	return tutor; 
}

public void setTutor(String tutorName) {
	this.tutor = tutorName; 
}

public int getStartTime() {
	return startTime; 
}

public void setStartTime(int startTime) {
	this.startTime = startTime; 
}


//public void SetAttendance(String line) {
//	String[] classDetails = line.split(" "); 
////	for(int i = 0, j = 0; j < attendance.length; i++) {
//		String attendances = classDetails[i+1];
//	try {
	
//		int attend = Integer.parseInt(attendances); 
//		attendance[j] = attend;
//		j++;
		
//	}
//	catch(NumberFormatException n) {
		
//	}
//	}
	
//	UpdatedAverage = -1; 
//}

public double GetAvgAttendance() {
	if(UpdatedAverage >= 0) {
		return UpdatedAverage; 
	}
	
}

public int compareTo(FitnessClass enrollment) {
	double BeginAverageAttendance = this.getAverageAttendance();
	double EndAverageAttenance = enrollment.getAverageAttendance(); 
	if(BeginAverageAttendance < EndAverageAttendance) {
		return 1;
	}
	else if(BeginAverageAttendance == EndAverageAttendance) {
		return 0;
	}
	else {
		return -1; 
	}
}



    
}
