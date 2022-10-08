
public class Person{
	//instance variables
	private String name;
	private int health; 
	
	//constructor
	public Person(String name){
		this.name = name;	
		health = 100;
	}
	
	//getters
	public String getName(){
		return name;
	}
	public int getHealth(){
		return health;
	}
	
	//other methods
	public boolean isAlive(){
		if(health!=0){
			return true;
		}
		return false;
	}
	public boolean heal(int boost){
		if(isAlive()==true){
			if(health+boost>=100){
				health = 100;
				return true;
			}
			health += boost;
			return true;
		}
		return false;
	}
	public boolean defends(int damage){
		if(health-damage <= 0){
			health = 0;
			return false;
		}
		health -= damage;
		return true;
	}
	
	public String toString(){
		return "Name: " + name + "\nHealth: " + health + "\n";
	}
}