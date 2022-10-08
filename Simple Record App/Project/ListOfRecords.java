
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;
import java.util.Calendar;
import java.text.SimpleDateFormat;  
import java.util.Date;  
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.text.ParseException;
import java.text.DateFormat;
import java.util.Comparator;

public class ListOfRecords{
	/*LIST OF RECORDS/MAIN WINDOW*/
//Containers for main window
	private static JFrame Mainfr;
//Components for main window
	private static DefaultTableModel model;
	private static JTable table;
	private static JScrollPane sp;
	private static JPanel pTable, pSort, pButton;
	private static JLabel lSort;
	private static JComboBox<String> cbSort;
	private static JRadioButton rbAscending, rbDescending;
	private static JButton bAdd, bRemove, bExport;

	public ListOfRecords(){
		/*for Main window*/
		Mainfr = new JFrame("List of Records");
		model = new DefaultTableModel();
		table = new JTable(model); 
		sp = new JScrollPane(table);
		
		pTable = new JPanel();
		pSort = new JPanel();
		pButton = new JPanel();
		
		lSort = new JLabel("Sort by: ");
		
		String [] arrCategories = {"Name", "Birthday", "Age"};
		cbSort = new JComboBox<>(arrCategories);
		
		rbAscending = new JRadioButton("Ascending");
		rbDescending = new JRadioButton("Descending");
		
		bAdd = new JButton("Add a Record");
		bRemove = new JButton("Remove a Record");
		bExport = new JButton("Export to CSV File");	
		
	}
	/*launches Main Window*/
	public void startRecordApp() throws IllegalArgumentException{
		pTable.add(sp);
		pTable.setSize(600, 200);
		model.addColumn("NAME");
		model.addColumn("BIRTHDAY");
		model.addColumn("AGE");
		sp.setVisible(true);
		table.setPreferredScrollableViewportSize(new Dimension(600,200));
        table.setFillsViewportHeight(true);
		table.setDefaultEditor(Object.class, null);//disables editting of cells
		table.getTableHeader().setReorderingAllowed(false);//disables dragging of collumns by the header
		table.getTableHeader().setResizingAllowed(false);//disables resizing of cells
		table.getTableHeader().setFont(new Font("Dialog", Font.BOLD, 16));//format font of the columns header
		
		pSort.setLayout(new GridBagLayout());
		pSort.add(lSort);
		pSort.add(cbSort);
		pSort.add(rbAscending);
		pSort.add(rbDescending);
		
		ButtonGroup orderGroup = new ButtonGroup();
		orderGroup.add(rbAscending);
		orderGroup.add(rbDescending);
		
		pButton.add(bAdd);
		pButton.add(bRemove);
		pButton.add(bExport);
		
		Mainfr.setLayout(new BorderLayout());
		Mainfr.add(pTable, BorderLayout.NORTH);
		Mainfr.add(pSort, BorderLayout.CENTER);
		Mainfr.add(pButton, BorderLayout.SOUTH);

		Mainfr.pack();
		Mainfr.setSize(650,450);
		Mainfr.setResizable(false);
		Mainfr.setVisible(true);
		Mainfr.setLocationRelativeTo(null); //centers the List of Records window
		Mainfr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//register event handlers for Main Window
		rbAscending.addActionListener(
			e -> {  String sortType = String.valueOf(cbSort.getSelectedItem());
					JOptionPane.showMessageDialog(null, "Sort by " + sortType + " in Ascending Order.");
						
					if(sortType.equals("Name")){
						//putting values displayed on table in an arraylist type String
						ArrayList<String>list = new ArrayList<>();
						for(int i=0; i<table.getRowCount(); i++){
							list.add(String.valueOf(table.getValueAt(i,0)));
						}
						Collections.sort(list); //sorted by Ascending order
						ListLoop:
						for(int i=0; i<table.getRowCount(); i++){
							TableLoop:
							for(int j=0; j<table.getRowCount(); j++ ){
								if(String.valueOf(list.get(i)).equals(String.valueOf(table.getValueAt(j,0)))){
									model.moveRow(j,j,i);
									continue ListLoop;
								}
							}
						}
					}else if(sortType.equals("Age")){
						//putting values displayed on table in an arraylist type Integer
						ArrayList<Integer>list = new ArrayList<>();
						for(int i=0; i<table.getRowCount(); i++){
							list.add(Integer.valueOf(String.valueOf(table.getValueAt(i,2))));
						}
						Collections.sort(list); //sorted by Ascending order
						ListLoop:
						for(int i=0; i<table.getRowCount(); i++){
							TableLoop:
							for(int j=0; j<table.getRowCount(); j++ ){
								if(Integer.valueOf(String.valueOf(list.get(i))).equals(Integer.valueOf(String.valueOf(table.getValueAt(j,2))))){
									model.moveRow(j,j,i);
									continue ListLoop;
								}
							}
						}
					}else if(sortType.equals("Birthday")){
						//putting values displayed on table in an arraylist type String
						ArrayList<String>list = new ArrayList<>();
						for(int i=0; i<table.getRowCount(); i++){
							list.add(String.valueOf(table.getValueAt(i,1)));
						}
						Collections.sort(list, new Comparator<String>() {//sorted by Ascending order
							DateFormat f = new SimpleDateFormat("MM/dd/yyyy");
							@Override
							public int compare(String o1, String o2){
								try{
									return f.parse(o1).compareTo(f.parse(o2));
								}catch(ParseException e){
									} return 0;}
						});
						ListLoop:
						for(int i=0; i<table.getRowCount(); i++){
							TableLoop:
							for(int j=0; j<table.getRowCount(); j++ ){
								if(String.valueOf(list.get(i)).equals(String.valueOf(table.getValueAt(j,1)))){
									model.moveRow(j,j,i);
									continue ListLoop;
								}
							}
						}
					}
			});
		rbDescending.addActionListener(
			e -> { 	JOptionPane.showMessageDialog(null, "Sort by " + String.valueOf(cbSort.getSelectedItem()) + " in Descending Order.");
					String sortType = String.valueOf(cbSort.getSelectedItem());
						if(sortType.equals("Name")){
							ArrayList<String>list = new ArrayList<>();
						for(int i=0; i<table.getRowCount(); i++){
							list.add(String.valueOf(table.getValueAt(i,0)));
						}
						Collections.sort(list, Collections.reverseOrder()); //sorted by Descending order
						ListLoop:
						for(int i=0; i<table.getRowCount(); i++){
							TableLoop:
							for(int j=0; j<table.getRowCount(); j++ ){
								if(String.valueOf(list.get(i)).equals(String.valueOf(table.getValueAt(j,0)))){
									model.moveRow(j,j,i);
									continue ListLoop;
								}
							}
						}
					}else if(sortType.equals("Age")){
						//putting values displayed on table in an arraylist type Integer
						ArrayList<Integer>list = new ArrayList<>();
						for(int i=0; i<table.getRowCount(); i++){
							list.add(Integer.valueOf(String.valueOf(table.getValueAt(i,2))));
						}
						Collections.sort(list, Collections.reverseOrder()); //sorted by Descending order
						ListLoop:
						for(int i=0; i<table.getRowCount(); i++){
							TableLoop:
							for(int j=0; j<table.getRowCount(); j++ ){
								if(Integer.valueOf(String.valueOf(list.get(i))).equals(Integer.valueOf(String.valueOf(table.getValueAt(j,2))))){
									model.moveRow(j,j,i);
									continue ListLoop;
								}
							}
						}
					}else if(sortType.equals("Birthday")){
						//putting values displayed on table in an arraylist type String
						ArrayList<String>list = new ArrayList<>();
						for(int i=0; i<table.getRowCount(); i++){
							list.add(String.valueOf(table.getValueAt(i,1)));
						}
						Collections.sort(list, new Comparator<String>() {//sorted by Descending order
							DateFormat f = new SimpleDateFormat("MM/dd/yyyy");
							@Override
							public int compare(String o1, String o2){
								try{
									return f.parse(o1).compareTo(f.parse(o2))*-1;
								}catch(ParseException e){
									} return 0;}
						});
						ListLoop:
						for(int i=0; i<table.getRowCount(); i++){
							TableLoop:
							for(int j=0; j<table.getRowCount(); j++ ){
								if(String.valueOf(list.get(i)).equals(String.valueOf(table.getValueAt(j,1)))){
									model.moveRow(j,j,i);
									continue ListLoop;
								}
							}
						}
					}
			});
		bAdd.addActionListener(
			e -> { AddRecord.startAddRecords();
			});
		bRemove.addActionListener(
			e -> { RemoveRecord.startRemoveRecordsApp(); });
		bExport.addActionListener(
			e -> { try {
                    this.startExport();
                 } catch (IOException ex) {
				 }
			});
	}
	
class AddRecord{
	/*ADD RECORDS WINDOW*/
	//Containers for AddRecords
		private static JFrame ARfr;
	//Components for AddRecords
		private static JPanel pName, pBday, pBdayLabels, pOptions, pBuffer;
		private static JLabel lName, lBday, lMonth, lDay, lYear;
		private static JTextField tfName;
		private static JComboBox<String> cbMonth, cbDay, cbYear;
		private static JButton bSaveBack, bSaveAdd, bBack;
		
		/*launches Add Records Window*/
	public static void startAddRecords() throws IllegalArgumentException{
		
		/*for Add Records*/
		ARfr = new JFrame("Add Records");
		
		pName = new JPanel();
		pBday = new JPanel();
		pBdayLabels = new JPanel();
		pOptions = new JPanel();
		pBuffer = new JPanel();
		
		lName = new JLabel("Name: ");
		tfName = new JTextField(20);
		
		lBday = new JLabel("Birthday");
		String [] arrMonth = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
		cbMonth = new JComboBox<>(arrMonth);
		
		String [] arrDay = new String[31];
		for(int i=1; i<=31; i++){
		arrDay[i-1]= Integer.toString(i);}
		cbDay = new JComboBox<>(arrDay);
		
		String [] arrYear = new String[123];
		for(int i=1900; i<=2022; i++){
		arrYear[i-1900]= Integer.toString(i);}
		cbYear = new JComboBox<>(arrYear);
		
		lMonth = new JLabel("           mm         ");
		lDay = new JLabel("dd           ");
		lYear = new JLabel("yyyy");
		
		bSaveBack = new JButton("Save and Go Back");
		bSaveAdd = new JButton("Save and Add Another"); 
		bBack = new JButton("Back");
		
		pName.add(lName);
		pName.add(tfName);
		
		pBday.add(lBday);
		pBday.add(cbMonth);
		pBday.add(cbDay);
		pBday.add(cbYear);
		
		pBdayLabels.add(lMonth);
		pBdayLabels.add(lDay);
		pBdayLabels.add(lYear);
		
		pOptions.add(bSaveBack);
		pOptions.add(bSaveAdd);
		pOptions.add(bBack);
		
		ARfr.setLayout(new GridLayout(6,1));
		ARfr.add(pBuffer);
		ARfr.add(pName);
		ARfr.add(pBday);
		ARfr.add(pBdayLabels);
		ARfr.add(pOptions);
		
		ARfr.pack();
		ARfr.setSize(new Dimension(650,350));
		ARfr.setResizable(false);
		ARfr.setVisible(true);
		Mainfr.setVisible(false);
		ARfr.setLocationRelativeTo(null); //centers the Add Records window
		//register event handlers for Add Records
		bBack.addActionListener(
			e -> {  ARfr.dispose();
					Mainfr.setVisible(true);
					//resets to intial values
					tfName.setText("");
					cbMonth.setSelectedIndex(0);
					cbDay.setSelectedIndex(0);
					cbYear.setSelectedIndex(0);
			});
		bSaveAdd.addActionListener(
			e -> {	String name = tfName.getText().trim();
				if(!(name.trim().equals(""))){
					boolean temp = true;
					boolean duplicateName = false;
					int rowCount = table.getRowCount();
					
					String month = null;
					switch(String.valueOf(cbMonth.getSelectedItem())){
						case "Jan":
							month = "01";
							break;
						case "Feb":
							month = "02";
							break;
						case "Mar":
							month = "03";
							break;
						case "Apr":
							month = "04";
							break;
						case "May":
							month = "05";
							break;
						case "Jun":
							month = "06";
							break;
						case "Jul":
							month = "07";
							break;
						case "Aug":
							month = "08";
							break;
						case "Sep":
							month = "09";
							break;
						case "Oct":
							month = "10";
							break;
						case "Nov":
							month = "11";
							break;
						case "Dec":
							month = "12";
					}
					String day = String.valueOf(cbDay.getSelectedItem());
					if((String.valueOf(cbDay.getSelectedItem()).length()==1)){
						day = "0" + String.valueOf(cbDay.getSelectedItem());
					}
					String year = String.valueOf(cbYear.getSelectedItem()); 
					String Bdate = month + "/" + day + "/" + year;
					
					//to check if date entered is valid
					try{
						Calendar now = Calendar.getInstance();
						int yearNow = now.get(Calendar.YEAR);
						int monthNow = now.get(Calendar.MONTH);
						int dayNow = now.get(Calendar.DAY_OF_WEEK);
						int m = Integer.valueOf(month);
						int y = Integer.valueOf(year);
						int d = Integer.valueOf(day);
						
						if(y==yearNow){
							if(m>monthNow){
								throw new IllegalArgumentException();
							}
							if(m==monthNow){
								if(d>dayNow){
									throw new IllegalArgumentException();
								}
							}
						}
						//for months with 30 days only
						else if(m==4 || m==6 || m==9 || m==11){
							if(d>30){
								throw new IllegalArgumentException();
							}
						}
						else if(m==2){
							if(isLeap(y)==false){
								if(d>28){
									throw new IllegalArgumentException();
								}
							}
							else if(d>29){
								throw new IllegalArgumentException();
							}
						}
					}catch(IllegalArgumentException IAE){
						temp = false;
						JOptionPane.showMessageDialog(null, "IllegalArgumentException is caught.\nAn invalid date or future date is entered.", "Invalid Date", JOptionPane.ERROR_MESSAGE);
					}
					if(temp==true){
						Person P = new Person(name, Bdate);
						
						String [] data = {String.valueOf(P.getName()), String.valueOf(P.getBday()), String.valueOf(P.getAge())};
						model = (DefaultTableModel)table.getModel();
						model.addRow(data);
						model.fireTableDataChanged();
						JOptionPane.showMessageDialog(null, "Record has been created.");
						}
						
						//resets to intial values
						tfName.setText("");
						cbMonth.setSelectedIndex(0);
						cbDay.setSelectedIndex(0);
						cbYear.setSelectedIndex(0);
				}
			});
		bSaveBack.addActionListener(
			e -> {	String name = tfName.getText().trim();
				if(!(name.trim().equals(""))){
					boolean duplicateName = false;
					boolean temp = true;
					int rowCount = table.getRowCount();
					
					String month = null;
					switch(String.valueOf(cbMonth.getSelectedItem())){
						case "Jan":
							month = "01";
							break;
						case "Feb":
							month = "02";
							break;
						case "Mar":
							month = "03";
							break;
						case "Apr":
							month = "04";
							break;
						case "May":
							month = "05";
							break;
						case "Jun":
							month = "06";
							break;
						case "Jul":
							month = "07";
							break;
						case "Aug":
							month = "08";
							break;
						case "Sep":
							month = "09";
							break;
						case "Oct":
							month = "10";
							break;
						case "Nov":
							month = "11";
							break;
						case "Dec":
							month = "12";
					}
					String day = String.valueOf(cbDay.getSelectedItem());
					if((String.valueOf(cbDay.getSelectedItem()).length()==1)){
						day = "0" + String.valueOf(cbDay.getSelectedItem());
					}
					String year = String.valueOf(cbYear.getSelectedItem()); 
					String Bdate = month + "/" + day + "/" + year;
					
					//to check if date entered is valid
					try{
						Calendar now = Calendar.getInstance();
						int yearNow = now.get(Calendar.YEAR);
						int monthNow = now.get(Calendar.MONTH);
						int dayNow = now.get(Calendar.DAY_OF_WEEK);
						int m = Integer.valueOf(month);
						int y = Integer.valueOf(year);
						int d = Integer.valueOf(day);
						
						if(y==yearNow){
							if(m>monthNow){
								throw new IllegalArgumentException();
							}
							if(m==monthNow){
								if(d>dayNow){
									throw new IllegalArgumentException();
								}
							}
						}
						//for months with 30 days only
						if(m==4 || m==6 || m==9 || m==11){
							if(d>30){
								throw new IllegalArgumentException();
							}
						}
						if(m==2){
							if(isLeap(y)==false){
								if(d>28){
									throw new IllegalArgumentException();
								}
							}
							if(d>29){
								throw new IllegalArgumentException();
							}
						}
					}catch(IllegalArgumentException IAE){
						temp = false;
						JOptionPane.showMessageDialog(null, "IllegalArgumentException is caught.\nAn invalid date or future date is entered.", "Invalid Date", JOptionPane.ERROR_MESSAGE);
					}
					if(temp==true){
						Person P = new Person(name, Bdate);
						
						String [] data = {String.valueOf(P.getName()), String.valueOf(P.getBday()), String.valueOf(P.getAge())};
						model = (DefaultTableModel)table.getModel();
						model.addRow(data);
						model.fireTableDataChanged();
						JOptionPane.showMessageDialog(null, "Record has been created.");
					}
						//resets to intial values
						ARfr.dispose();
						tfName.setText("");
						cbMonth.setSelectedIndex(0);
						cbDay.setSelectedIndex(0);
						cbYear.setSelectedIndex(0);
						Mainfr.setVisible(true);
				}
			});
		ARfr.addWindowListener(new WindowAdapter(){
			@Override
			public void windowClosing(WindowEvent windowEvent) {
					ARfr.dispose();
					tfName.setText("");
					cbMonth.setSelectedIndex(0);
					cbDay.setSelectedIndex(0);
					cbYear.setSelectedIndex(0);	
					Mainfr.setVisible(true);
				}
			});	
	}
	}
	
class RemoveRecord{
	/*REMOVE RECORDS WINDOW*/
	//Containers for RemoveRecords
		private static JFrame RRfr;
	//Components for RemoveRecords
		private static JPanel p1Name, p1Options, p1Buffer;
		private static JLabel l1Name;
		private static JTextField tf1Name;
		private static JButton b1RemoveBack, b1RemoveAnother, b1Back;
		
		/*launches Remove Records Window*/
	public static void startRemoveRecordsApp() throws IllegalArgumentException{
		
		/*for Remove Records*/
		RRfr = new JFrame("Remove Record");
		
		p1Name = new JPanel();
		p1Options = new JPanel();
		p1Buffer = new JPanel();
		
		l1Name = new JLabel("Name: ");
		tf1Name = new JTextField(20);
		
		b1RemoveBack = new JButton("Remove and Go Back");
		b1RemoveAnother = new JButton("Remove Another");
		b1Back = new JButton("Back");
		
		p1Name.add(l1Name);
		p1Name.add(tf1Name);
		
		p1Options.add(b1RemoveBack);
		p1Options.add(b1RemoveAnother);
		p1Options.add(b1Back);
		
		RRfr.setLayout(new GridLayout(3,1));
		RRfr.add(p1Buffer);
		RRfr.add(p1Name);
		RRfr.add(p1Options);
		
		RRfr.pack();
		RRfr.setSize(new Dimension(650,350));
		RRfr.setResizable(false);
		RRfr.setVisible(true);
		Mainfr.setVisible(false);
		RRfr.setLocationRelativeTo(null); //centers the Remove Records window
		//register event handlers
		b1Back.addActionListener(
			e -> {  RRfr.dispose();
					tf1Name.setText("");
					Mainfr.setVisible(true);
			});
		b1RemoveBack.addActionListener(
			e -> {
			boolean dne = true;
			String name = tf1Name.getText();
			int rowCount = table.getRowCount();
			model.fireTableDataChanged();
			try{
				for (int i = 0; i < rowCount; i++){
					if (name.equalsIgnoreCase(String.valueOf(table.getValueAt(i, 0)))){
						model.removeRow(i);
						JOptionPane.showMessageDialog(null, name + " has been removed from the list.");
						model.fireTableDataChanged();
						dne = false;
						break;
					}
				}
				if(dne==true)
					throw new IllegalArgumentException();
			}catch(IllegalArgumentException IAE){
				JOptionPane.showMessageDialog(null, "Name not found.", "Warning Screen", JOptionPane.WARNING_MESSAGE);
			}finally{	
			RRfr.dispose();
			tf1Name.setText("");
			Mainfr.setVisible(true);
			}
			});
		b1RemoveAnother.addActionListener(
			e -> {	
			boolean dne = true;
			String name = tf1Name.getText();
			int rowCount = table.getRowCount();
			model.fireTableDataChanged();
			try{
				for (int i = 0; i < rowCount; i++){
					if (name.equalsIgnoreCase(String.valueOf(table.getValueAt(i, 0)))){
						model.removeRow(i);
						JOptionPane.showMessageDialog(null, name + " has been removed from the list.");
						model.fireTableDataChanged();
						dne = false;
						break;
					}
				}
				if(dne==true)
					throw new IllegalArgumentException();
			}catch(IllegalArgumentException IAE){
				JOptionPane.showMessageDialog(null, "Name not found.", "Warning Screen", JOptionPane.WARNING_MESSAGE);
			}finally{
			tf1Name.setText("");
			}
			});
		RRfr.addWindowListener(new WindowAdapter(){
			@Override
			public void windowClosing(WindowEvent windowEvent) {
					RRfr.dispose();
					tf1Name.setText("");	
					Mainfr.setVisible(true);
				}
			});	
	}
		
		
}
	public void startExport() throws IOException{
		JFileChooser fileChooser = new JFileChooser();
		
		SimpleDateFormat fileFormat = new SimpleDateFormat("MMddyyyyHHmmss");  
		Date timeNow = new Date();
		
		String fileName = fileFormat.format(timeNow).toString();
		
		File csvFile = new File(fileName+".csv");
		FileWriter fw = new FileWriter(csvFile);
		BufferedWriter bw = new BufferedWriter(fw);

		//header for the columns in the csv file
		//separated by comma to move to the next cell of the same row
		bw.write("Name,");
		bw.write("Birthday,");
		bw.write("Age,");
		bw.newLine();
		//prints data from table to csv file line by line
		for(int i=0; i<table.getRowCount(); i++){
			for(int j=0; j<table.getColumnCount(); j++){
				bw.write(String.valueOf(table.getValueAt(i,j)) + ",");
			}
			bw.newLine();//record per line
		}
		bw.close();
		fw.close();
		JOptionPane.showMessageDialog(null, "Record is Exported.");
	}
	
	public static boolean isLeap(int year){
		// Return true if year is a multiple of 4 and not multiple of 100.
        // OR year is multiple of 400.
		if((year % 4 == 0) && (year % 100 != 0)){
			return true;
		}
		if((year % 400 == 0)){
			return true;
		}
		return false;
	}
}