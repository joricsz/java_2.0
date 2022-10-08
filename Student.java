
public class Student{
	
	//instance variables
	private String name;
	private int studentId;
	private String course;
	
	//constructor
	public Student(String name, int studentId, String course){
		this.name = name;
		this.studentId = studentId;
		this.course = course;
	}
	
	//getters
	public String getName(){
		return name;
	}
	public int getStudentId(){
		return studentId;
	}
	public String getCourse(){
		return course;
	}
	
	@Override
	public String toString(){
		return "Name: " + getName() + "\nStudent ID: " + getStudentId() + "\nCourse: " + getCourse() + "\n"; 
	}
	
	@Override
	public boolean equals(Object obj){
		boolean truthVal = false;
		Student s = (Student) obj;
		if(s != null && s instanceof Student){
			if(this.getName() == s.getName() && this.getStudentId() == s.getStudentId() && this.getCourse() == s.getCourse()){
				truthVal = true;
				return truthVal;
			}		
		}
		return truthVal;	
	}
	
	@Override
	public int hashCode(){
		return getName().hashCode() * getStudentId() + getCourse().hashCode();
	}
	
	
	
	
	
	
}