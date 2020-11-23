package com.coinsort.johnakhilomen;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class MainPanel extends JPanel{
	private String[] _buttonNames;
	public static JDialog subMenudialog;
	public MainPanel(String[] buttonNames)
	{
		_buttonNames = buttonNames;
		setLayout();
		setupButtons();
	}

	private void setLayout()
	{
		setLayout(new GridLayout(3,3));  
	}
	
	public void setupButtons()
	{
		for (int i = 0; i< _buttonNames.length; i++)
		{
			JButton button = new JButton(_buttonNames[i]);
			button.addActionListener(new ActionListener(){  
				@Override
				public void actionPerformed(ActionEvent e) {
					if(e.getActionCommand() == "Coin calculator")
					{
						System.out.println("Coin calculator...");
						coinCalculator();
						
					}
					else if(e.getActionCommand() == "Multiple coin calculators")
					{
						System.out.println("Multiple coin calculators...");
						multipleCoinCalculator();
						
					} 
					else if(e.getActionCommand() == "Print coin list")
					{
						System.out.println("Print coin lists...");
						printCoinList();
						
					} 
					else if(e.getActionCommand() == "Set details")
					{
						System.out.println("Set details");
						setDetails();
					} 
					else if(e.getActionCommand() == "Display program configurations")
					{
						//System.out.println("Display program configurations");
						displayProgramConfigurations();
					}
					else if(e.getActionCommand() == "Quit the program")
					{
						System.out.println("Quit the program");
						quitTheProgram();
					}
				}  
			});
			add(button);
		}
		
	}

	protected void quitTheProgram() {
	System.exit(0);	
	}

	protected void displayProgramConfigurations() {
		String[] subMenuButtonNames = new String[] {"Set currency", "Set minimum coin input value", "Set maximum coin input value",
		"Return to main menu"};
		subMenudialog = new OptionPaneDialog("Set Details Sub-Menu", new DisplayProgramConfigurationsPanel(subMenuButtonNames), false).getDialog();
		testCoinSorter.mainDialog.setVisible(false);
		subMenudialog.setVisible(true);
	}

	protected void setDetails() {
		// TODO Auto-generated method stub
		
	}

	protected void printCoinList() {
		// TODO Auto-generated method stub
		System.out.println("Currency set: " +testCoinSorter.coinSorter.getCurrency());
		
	}

	protected void multipleCoinCalculator() {
		// TODO Auto-generated method stub
		
	}

	protected void coinCalculator() {
		// TODO Auto-generated method stub
		
	}
	


}
