
public class Triangle implements Shape{
	//instance variables
	private int side1;
	private int side2;
	private int side3;
	
	//constructor
	public Triangle(int side1, int side2, int side3){
		this.side1 = side1;
		this.side2 = side2;
		this.side3 = side3;
	}
	
	//methods
	@Override
	public double getPerimeter(){
		return side1 + side2 + side3;
	}
	public double getArea(){
		double s = (side1 + side2 + side3)/2;
		return Math.sqrt(s*(s-side1)*(s-side2)*(s-side3));
	}
	public void getDetails(){
		System.out.println("Type: Triangle" + "\nSide1: " + side1 + "\nSide2: " + side2 + "\nSide3: " + side3 + "\nPerimeter: " + getPerimeter() + "\nArea: " + getArea());
	}
}