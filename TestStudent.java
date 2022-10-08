
public class TestStudent{
	public static void main(String ... args){
		Student s1 = new Student("You", 11235813, "B.S. Marine Engineering");
		Student s2 = new Student("You", 11235813, "B.S. Marine Engineering");
		
		System.out.println(s1);
		System.out.println(s2);
		
		System.out.println(s1.equals(s2));
		
		System.out.println(s1.hashCode());
		System.out.println(s2.hashCode());
		
	}
}