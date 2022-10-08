
public class RicafrancaModule2{
	public static void main(String ... args){  
		for(int index = 0; index<args.length; index++){
			
			String s = args[index];
			char lastChar = s.charAt(s.length()-1);
			
			System.out.print("args[" + index +"]" + " = " + s + " = " + s.length() + " =");
			if (Character.isDigit(lastChar)==true){
				System.out.println(" number");
			}
			else if (Character.isAlphabetic(lastChar)){
				if (lastChar=='a'||lastChar=='e'||lastChar=='i'||lastChar=='o'||lastChar=='u'){
					System.out.println(" vowel");
				}
				else{
					System.out.println(" consonant");
				}
			}
			else{
				System.out.println(" symbol");
			}
		}
	}
}

/*

public class Module2{
	public static void main(String ... args){  
		for(String s : args){
			
			char lastChar = args[length].charAt(s.length()-1);
			
			System.out.print("args[" + ctr +"]" + " = " + s + " = " + s.length() + " =");
			if (Character.isDigit(lastChar)==true){
				System.out.println(" number");
			}
			else if (Character.isAlphabetic(lastChar)){
				if (s.substring(s.length()-1)=="a"||s.substring(s.length()-1)=="e"||s.substring(s.length()-1)=="i"||s.substring(s.length()-1)=="o"||s.substring(s.length()-1)=="u"){
					System.out.println(" vowel");
				}
				System.out.println(" consonant");
			}
			System.out.println(" symbol");
		}
	}
}



Character.isDigit((s.substring(s.length()-1))

else if (isAlphabetic(s.substring(s.length()-1)))
if (s.substring(s.length()-1)=="a"||s.substring(s.length()-1)=="e"||s.substring(s.length()-1)=="i"||s.substring(s.length()-1)=="o"||s.substring(s.length()-1)=="u"){
					System.out.println(" vowel");
*/