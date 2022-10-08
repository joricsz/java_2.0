
public class Square implements Shape{
	//instance variable
	private int side;
	
	//constructor
	public Square(int side){
		this.side = side;
	}
	
	//methods
	@Override
	public double getPerimeter(){
		return 4*side;
	}
	public double getArea(){
		return side*side;
	}
	public void getDetails(){
		System.out.println("Type: Square" + "\nSide: " + side + "\nPerimeter: " + getPerimeter() + "\nArea: " + getArea());
	}
}