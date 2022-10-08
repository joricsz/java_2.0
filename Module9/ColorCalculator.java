import java.awt.*;
//import java.swing.*;

public class ColorCalculator{
	public static void main(String ... args){
		ColorCalculator CC = new ColorCalculator();
		CC.launchApp();
	}
	
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
		
		tfRed = new TextField("0", 3);
		tfGreen = new TextField("0", 3);
		tfBlue = new TextField("0", 3);
		tfAlpha = new TextField("0", 3);
		
		bCompute = new Button("Compute");
		bClear = new Button("Clear");	
	}
	
	public void launchApp(){
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
		
		pColor.setBackground(Color.gray);
		
		fr.setLayout(new GridLayout(6,2));
		
		fr.add(pRed);
		fr.add(pGreen);
		fr.add(pBlue);
		fr.add(pAlpha);
		fr.add(pButtons);
		fr.add(pColor);
		
		fr.pack();
		fr.setVisible(true);
	}
}