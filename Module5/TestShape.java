
public class TestShape{
	public static void main(String ... args){
		boolean success = false; 
	
		try{
			if(args.length == 0){
					System.out.println("Pass one to three values via command line.");
					throw new IllegalArgumentException();
				}
			for(int i=0; i<args.length; i++){
				if(Integer.parseInt(args[i]) <= 0 ){
					System.out.println("A negative value was passed.");
					throw new IllegalArgumentException();
				}
				if(args.length > 3){
					System.out.println("Limit your arguments to a maximum of 3 values.");
					throw new IllegalArgumentException();
				}
			}
			success = true;
		}
		catch(NumberFormatException NFE){
			System.err.println("An argument contains a String value.");
			System.err.println("A NumberFormatException is caught.");
		}
		catch(IllegalArgumentException IAE){
			System.err.println("An IllegalArgumentException is caught.");
		}
		
		if(success){
		/*if(args.length == 4){
			if(Integer.parseInt(args[0])==Integer.parseInt(args[1]) && Integer.parseInt(args[1])==Integer.parseInt(args[2]) && Integer.parseInt(args[2])==Integer.parseInt(args[3])){
				Square sqr = new Square(Integer.parseInt(args[0]));
				sqr.getDetails();
				}
			else if((Integer.parseInt(args[0])==Integer.parseInt(args[1]) || Integer.parseInt(args[0])==Integer.parseInt(args[2]) || Integer.parseInt(args[0])==Integer.parseInt(args[3])) && (Integer.parseInt(args[2])==Integer.parseInt(args[3]) || Integer.parseInt(args[1])==Integer.parseInt(args[3]) || Integer.parseInt(args[1])==Integer.parseInt(args[2]))){
				int high=0 ,low=0;
				for(int ind=0; ind<4; ind++){
					if(Integer.parseInt(args[ind])>=high){
						high = Integer.parseInt(args[ind]);
						}
					else{
						low = Integer.parseInt(args[ind]);
						}
					}
				Rectangle rctngl = new Rectangle(high, low);
				rctngl.getDetails();
				}
			else{ 
			System.out.println("Invalid Input");
				}
			}
		*/
			if(args.length == 3){
				Triangle tri = new Triangle(Integer.parseInt(args[0]), Integer.parseInt(args[1]), Integer.parseInt(args[2]));
				tri.getDetails();
				}
			else if(args.length == 2){
				if(Integer.parseInt(args[0])==Integer.parseInt(args[1])){
					Square sqr = new Square(Integer.parseInt(args[0]));
					sqr.getDetails();
					}
				else if(Integer.parseInt(args[0])>Integer.parseInt(args[1])){
					Rectangle rctngl = new Rectangle(Integer.parseInt(args[0]), Integer.parseInt(args[1]));
					rctngl.getDetails();
					}
				else{
					Rectangle rctngl = new Rectangle(Integer.parseInt(args[1]), Integer.parseInt(args[0]));
				rctngl.getDetails();
					}
				}
			else if(args.length == 1){
				Circle circ = new Circle(Integer.parseInt(args[0]));
				circ.getDetails();
				}
			}
		}
	}
	
	/*
		else if(args.length == 1){
			int rng1, rng2;
			do{
				rng1 = (int) Math.round(Math.random()*100);
				rng2 = (int) Math.round(Math.random()*100);
			}while(rng1==rng2);
			
			if(rng1>rng2){
				Circle circ = new Circle(Integer.parseInt(args[0]));
				circ.getDetails();
				}
			else{
				Square sqr = new Square(Integer.parseInt(args[0]));
				sqr.getDetails();
				}
			}
	
	
	if(args[0]=="0" || args[1]=="0" || args[2]=="0" || args[3]=="0" || args.length>4){
			System.out.println("Invalid Input");
			}
	*/