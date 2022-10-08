
public class Student{
	private String name;
	private String course;
	private float tuitionFee;
	private int studentNumber;
	private static int counter;
	
	//constructor
	public Student(String name, String course, float tuitionFee){
		this.name = name;
		this.course = course;
		this.tuitionFee = tuitionFee;
		counter += 1;
		studentNumber = counter;
		
	}
	
	//getters
	public String getName(){
		return name;
	}
	
	public String getCourse(){
		return course;
	}
	
	public float getTuitionFee(){
		return tuitionFee;
	}
	
	public int getStudentNumber(){
		return studentNumber;
	}
	
	@Override
	public String toString(){
		return "Student # " + getStudentNumber() + ": " + getName() + " is taking up " + getCourse() + " with a tuition fee of " + getTuitionFee() + "\n";  
	}
}