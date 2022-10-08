
public class PartialScholar extends Student{
	//instance variables
	private float discountRate;
	private float payableAmount;
	
	//constructor
	public PartialScholar(String name, String course, float tuitionFee, float discountRate){
		super(name, course, tuitionFee);
		//this();
		//super(String name, String course, float tuitionFee);
		this.discountRate = discountRate;
		this.payableAmount = tuitionFee - (tuitionFee * discountRate);
	}
	
	//getters
	public float getDiscountRate(){
		return discountRate;
	}
	
	public float getPayableAmount(){
		return payableAmount;
	}
	
	@Override
	public String toString(){
		//return super.toString() + "\nDiscount Rate of: " + (int)(getDiscountRate()*100) + "%" + "\nNet Payable Tuition Fee is: " + getPayableAmount();
		return "Student # " + getStudentNumber() + ": " + getName() + " is taking up " + getCourse() + " with a tuition fee of " + getTuitionFee() + "\nDiscount Rate of: " + (int)(getDiscountRate()*100) + "%" + "\nNet Payable Tuition Fee is: " + getPayableAmount() + "\n";  

	}
}