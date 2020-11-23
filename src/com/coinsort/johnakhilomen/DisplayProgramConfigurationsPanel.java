package com.coinsort.johnakhilomen;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class DisplayProgramConfigurationsPanel extends JPanel{

	private String[] _buttonNames;
	//public static String currency;
	public DisplayProgramConfigurationsPanel(String[] buttonNames)
	{
		_buttonNames = buttonNames;
		setLayout();
		setupButtons();
	}

	private void setLayout()
	{
		setLayout(new GridLayout(2,2));  
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
						//String item = JOptionPane.showInputDialog("Item name: ");
						
					}
					else if(e.getActionCommand() == "Set currency")
					{
						System.out.println("Multiple coin calculators...");
						setCurrency();
						
					} 
					else if(e.getActionCommand() == "Set minimum coin input value")
					{
						System.out.println("Print coin lists...");
						
					} 
					else if(e.getActionCommand() == "Set maximum coin input value")
					{
						System.out.println("Set details");
					} 
					else if(e.getActionCommand() == "Return to main menu")
					{
						returnToMainMenu();
						System.out.println("Return to main menu");
					}
				
				}  
			});
			add(button);
		}
		
	}

	protected void setCurrency() {
		var oPane = new OptionPaneDialog("Currency", null, true);
		var dialog = oPane.getDialog();
		dialog.setVisible(true);
		testCoinSorter.coinSorter.setCurrency(oPane.getInputValue().toString());
		testCoinSorter.mainPanel._currencyLabel.setText("Currency: "+testCoinSorter.coinSorter.getCurrency());
	}

	protected void returnToMainMenu() {
		MainPanel.subMenudialog.setVisible(false);
		testCoinSorter.mainDialog.setVisible(true);
	}
	
}
