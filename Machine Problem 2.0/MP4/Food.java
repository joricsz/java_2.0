
public class Food extends Item{
	//instance variable
	private int health;
	
	//constructor
	public Food(String name, double weight, int health){
		super(name, weight);
		this.health = health;
	}
	
	//getters
	public int getHealth(){
		return health;
	}
	
	//setters
	public void setHealth(int health){
		this.health = health;
	}
	
	//other methods
	public boolean use(Object target){
		if(target instanceof Person){
			Person p = (Person) target;
			if(p.heal(health)==true){
				System.out.println(p.getName() + " ate " + getName() + " for " + health + " health!");
				return true;
			}
			System.out.println(p.getName() + " cannot be healed!");
			return false;
		}
		return false;
	}
	
	@Override
	public String toString(){
		return "Name: " + super.getName() + "\nWeight: " + super.getWeight() + "\nHealth: " + health + "\n";		
	}
	
}