import java.io.*;
public class ModuleAssignment7{
	public static void main(String ... args) throws IOException{
		File myFile = new File(args[0]);
		BufferedReader  br = new BufferedReader(new FileReader(myFile));
		BufferedWriter Ubw = new BufferedWriter(new FileWriter("usernames.txt"));
		BufferedWriter Pbw = new BufferedWriter(new FileWriter("passwords.txt"));
		
		String str;
		int ctr = 1;
		
		while((str = br.readLine()) != null)
		{
			if (ctr%2==0){
				Pbw.write(str + "\n");
			}
			else{
				Ubw.write(str + "\n");
			}
			ctr++;
		}	
		br.close();
		Ubw.close();
		Pbw.close();
		
		System.out.println("Program successfully executed.");
	}
}