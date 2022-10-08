import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ColorCalculator{
	private JFrame fr;
	private JPanel pRed, pGreen, pBlue, pAlpha, pButtons, pColor;
	private JLabel lRed, lGreen, lBlue, lAlpha;
	private JTextField tfRed, tfGreen, tfBlue, tfAlpha;
	private JButton bCompute, bClear;
	
	public ColorCalculator(){
		//containers
		fr = new JFrame("My Color Calculator");
		
		pRed = new JPanel();
		pGreen = new JPanel();
		pBlue = new JPanel();
		pAlpha = new JPanel();
		pButtons = new JPanel();
		pColor = new JPanel();
		
		//components
		lRed = new JLabel("Red: ");
		lGreen = new JLabel("Green: ");
		lBlue = new JLabel("Blue: ");
		lAlpha = new JLabel("Alpha: ");
		
		tfRed = new JTextField("0", 10);
		tfGreen = new JTextField("0", 10);
		tfBlue = new JTextField("0", 10);
		tfAlpha = new JTextField("0", 10);
		
		bCompute = new JButton("Compute");
		bClear = new JButton("Clear");	
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
		
		fr.setLayout(new GridLayout(6,1));
		
		fr.add(pRed);
		fr.add(pGreen);
		fr.add(pBlue);
		fr.add(pAlpha);
		fr.add(pButtons);
		fr.add(pColor);
		
		fr.setSize(300,100);
		fr.pack();
		fr.setVisible(true);
		fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
				}else if(rVal>255 || gVal>255 || bVal>255 || aVal>255){
					JOptionPane.showMessageDialog(null,"Invalid value. Please try again.");
					valid = false;
				 }
				}catch(IllegalArgumentException IOE){
					JOptionPane.showMessageDialog(null,"Invalid value. Please try again.");
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