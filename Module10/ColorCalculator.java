import java.awt.*;
import java.awt.event.*;

public class ColorCalculator{
	private Frame fr;
	private Panel pRed, pGreen, pBlue, pAlpha, pButtons, pColor;
	private Label lRed, lGreen, lBlue, lAlpha;
	private TextField tfRed, tfGreen, tfBlue, tfAlpha;
	private Button bCompute, bClear;
	
	public ColorCalculator(){
		//containers
		fr = new Frame("My Color Calculator");
		
		pRed = new Panel();
		pGreen = new Panel();
		pBlue = new Panel();
		pAlpha = new Panel();
		pButtons = new Panel();
		pColor = new Panel();
		
		//components
		lRed = new Label("Red: ");
		lGreen = new Label("Green: ");
		lBlue = new Label("Blue: ");
		lAlpha = new Label("Alpha: ");
		
		tfRed = new TextField("0", 10);
		tfGreen = new TextField("0", 10);
		tfBlue = new TextField("0", 10);
		tfAlpha = new TextField("0", 10);
		
		bCompute = new Button("Compute");
		bClear = new Button("Clear");	
	}
	
	public void launchApp() throws IllegalArgumentException{
		pRed.add(lRed);
		pRed.add(tfRed);
		
		pGreen.add(lGreen);
		pGreen.add(tfGreen);
		
		pBlue.add(lBlue);
		pBlue.add(tfBlue);
		
		pAlpha.add(lAlpha);
		pAlpha.add(tfAlpha);
		
		pButtons.add(bCompute);
		pButtons.add(bClear);
		
		fr.setLayout(new GridLayout(6,2));
		
		fr.add(pRed);
		fr.add(pGreen);
		fr.add(pBlue);
		fr.add(pAlpha);
		fr.add(pButtons);
		fr.add(pColor);
		
		fr.pack();
		fr.setVisible(true);
		
		//register event handlers
		bCompute.addActionListener(
		e -> { 	boolean valid = true;
				int rVal, gVal, bVal, aVal;
				try{
				rVal = Integer.valueOf(tfRed.getText().trim());
				gVal = Integer.valueOf(tfGreen.getText().trim());
				bVal = Integer.valueOf(tfBlue.getText().trim());
				aVal = Integer.valueOf(tfAlpha.getText().trim());
				if(rVal<0 || gVal<0 || bVal<0 || aVal<0){
					throw new IllegalArgumentException();
				}else if(rVal>250 || gVal>250 || bVal>250 || aVal>250){
					System.out.println("Invalid value. Please try again.");
					valid = false;
				 }
				}catch(IllegalArgumentException IOE){
					System.out.println("Invalid value. Please try again.");
					valid = false;
				}
				if(valid){
					rVal = Integer.valueOf(tfRed.getText());
					gVal = Integer.valueOf(tfGreen.getText());
					bVal = Integer.valueOf(tfBlue.getText());
					aVal = Integer.valueOf(tfAlpha.getText());
					Color color = new Color(rVal, gVal, bVal, aVal);
					pColor.setBackground(color);
				}
		});
		bClear.addActionListener(
		e -> { tfRed.setText("");
			   tfGreen.setText("");
			   tfBlue.setText("");
			   tfAlpha.setText("");
		});
	}
	public static void main(String ... args){
		ColorCalculator CC = new ColorCalculator();
		CC.launchApp();
	}
}