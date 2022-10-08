
public class Rectangle implements Shape{
	//instance variables
	private int length;
	private int width;
	
	//constructor
	public Rectangle(int length, int width){
		this.length = length;
		this.width = width;
	}
	
	//methods
	@Override
	public double getPerimeter(){
		return (2*length) + (2*width);
	}
	public double getArea(){
		return length*width;
	}
	public void getDetails(){
		System.out.println("Type: Rectangle" + "\nLength: " + length + "\nWidth: " + width + "\nPerimeter: " + getPerimeter() + "\nArea: " + getArea());
	}
}