
import java.util.Map;
import java.util.HashMap;
import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class LoginWindow{
	//containers
	private	JFrame frame;
	//components
	private JPanel pCredentials, pUser, pPass, pLogin, pBuffer;
	private JLabel userlabel;
	private JTextField userText;
	private JLabel passlabel;
	private JTextField passText;
	private JButton login;
	
	//instance variables
	File myFile;
	BufferedReader br;
	Map<String, String> Credentials;
	String str, temp;
	int RemainingAttemptCtr, ctr;
	
	//constructor
	public LoginWindow() throws FileNotFoundException{
		//initialization of variables
		myFile = new File("loginCredentials.txt");
		br = new BufferedReader(new FileReader(myFile));
		Credentials = new HashMap<>();
		temp = null;
		RemainingAttemptCtr=3;
		ctr=1;
		
		//frame
		frame = new JFrame("Login Screen");
		//panels
		pUser = new JPanel();
		pPass = new JPanel();
		pLogin = new JPanel();
		pBuffer = new JPanel();
		pCredentials = new JPanel();
		//username components
		userlabel = new JLabel("Username: ");
		userText = new JTextField(10);
		//password components
		passlabel = new JLabel("Password: ");
		passText = new JTextField(10);
		//button components
		login = new JButton("Login");
	}
	//launches the login window
	public void startLogin() throws IOException{
		//Storing credentials from txt file to a HashMap
		while((str = br.readLine()) != null)
		{
			if (ctr%2==0){//if even number line meaning str is password
				Credentials.put(temp, str);//completes an entry in the hashmap by putting username from temp as key
			}							   //and password from str as value
			else{
				Credentials.put(str, null);
				temp = str;//stores the current value of str, which is a username, in the temp variable
			}
			ctr++;
		}
		
		//adding username components to username panel
		pUser.add(userlabel);
		pUser.add(userText);
		//adding password components to password panel
		pPass.add(passlabel);
		pPass.add(passText);
		//adding button components to button panel
		pLogin.setLayout(new GridBagLayout()); 
		pLogin.add(login, new GridBagConstraints()); //centers the button on its panel
		
		pCredentials.setLayout(new GridLayout(3,1));
		pCredentials.add(pBuffer);
		pCredentials.add(pUser);
		pCredentials.add(pPass);
		
		//adding panels to frame
		frame.setLayout(new GridLayout(2,1));
		frame.add(pCredentials);
		frame.add(pLogin);
		
		//frame settings
		frame.pack();
		frame.setSize(new Dimension(300, 250));
		frame.setResizable(false);
		frame.setVisible(true);
		frame.setLocationRelativeTo(null); //centers the login screen
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//event handlers
		login.addActionListener(
		 e -> {	try{
					String user = userText.getText();
					String password = passText.getText();
					
					if(Credentials.containsKey(user)){ //If the user exist in the record/credentials
						String tempPass = Credentials.get(user); //get the corresponding value of a key in the hashmap
						if(password.equals(tempPass)){
							JOptionPane.showMessageDialog(null, "Authorized Credentials");
							frame.setVisible(false); //hides login window
							ListOfRecords LoR = new ListOfRecords();//creates an instance of the ListOfRecords class
							LoR.startRecordApp();//launches List of Records window
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
					JOptionPane.showMessageDialog(null, "Incorrect Username/ Password, " + RemainingAttemptCtr + " more chance. ", "Invalid Credentials", JOptionPane.WARNING_MESSAGE);
					}
					else{
						JOptionPane.showMessageDialog(null, "Sorry, you have reached the limit of 3 attempts, Goodbye!", "Unathorized User", JOptionPane.WARNING_MESSAGE);
						System.exit(0);
					}
				}
			});
		br.close();
	}
}