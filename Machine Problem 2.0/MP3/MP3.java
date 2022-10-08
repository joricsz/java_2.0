import java.util.*;
import java.io.*;
public class MP3{
	public static void main(String ... args) throws IOException{
		File myFile = new File(args[0]);
		BufferedReader  br = new BufferedReader(new FileReader(myFile));
		Scanner sc = new Scanner(System.in);
		
		Map<String, String> Credentials = new HashMap<>();
		
		String str, temp=null;
		int RemainingAttemptCtr=3, ctr=1;
		
		//Storing credentials from txt file to a HashMap
		while((str = br.readLine()) != null)
		{
			if (ctr%2==0){
				Credentials.put(temp, str);
			}
			else{
				Credentials.put(str, null);
				temp = str;
			}
			ctr++;
		}
		
		while(RemainingAttemptCtr!=0){
			try{
				System.out.print("Enter username: ");
				String user = sc.nextLine();
				System.out.print("Enter password: ");
				String pass = sc.nextLine();
				
				if(Credentials.containsKey(user)){ //If the user exist in the record/credentials
					String tempPass = Credentials.get(user); //get the corresponding value of a key in the hashmap
					if(pass.equals(tempPass)){
						System.out.println("Access Granted.");
						break;
					}
					else{ //if incorrect password
					throw new IOException();
					}
				}
				else{ //if user doesn't exist in the record/credentials
				throw new IOException();
				}
			}catch(IOException ioe){
				if(RemainingAttemptCtr>1){
				RemainingAttemptCtr--;
				System.out.println("Invalid Credential/you only have " + RemainingAttemptCtr + " attempt/s remaining." + "\n");
				}
				else{
					System.out.println("Unauthorized user... Goodbye!");
					break;
				}
			}
		}
		br.close();
		sc.close();
	}
}