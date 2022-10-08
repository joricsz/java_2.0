
public class Circle implements Shape{
	//instance variables
	private final double PI = 3.14;
	private int radius;
	
	//constructor
	public Circle(int radius){
		this.radius = radius;
	}
	
	//methods
	@Override
	public double getPerimeter(){
		return 2*PI*radius;
	}
	public double getArea(){
		return PI*(radius*radius);
	}
	public void getDetails(){
		System.out.println("Type: Circle" + "\nRadius: " + radius + "\nPerimeter: " + getPerimeter() + "\nArea: " + getArea());
	}
}