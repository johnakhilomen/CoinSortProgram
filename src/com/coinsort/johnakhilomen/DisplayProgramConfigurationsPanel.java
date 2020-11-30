package com.coinsort.johnakhilomen;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class DisplayProgramConfigurationsPanel extends JPanel{

	private JComboBox currencyCombo; 
	private String[] _buttonNames;
	public DisplayProgramConfigurationsPanel(String[] buttonNames)
	{
		_buttonNames = buttonNames;
		setLayout(new GridLayout(2,2));
		setupButtons();
	}
	//use grid layout to place UI components on the panel
	private void setLayout()
	{
		//place UI components 2 x 2
		setLayout(new GridLayout(2,2));  
	}
	
	public void setupButtons()
	{
		//Iterate the buttons array
		for (int i = 0; i< _buttonNames.length; i++)
		{
			//instantiate a new JButton with every values in the buttonNames array
			JButton button = new JButton(_buttonNames[i]);
			//Attach an event listener to button to listen to any button-click 
			button.addActionListener(new ActionListener(){  
				@Override
				public void actionPerformed(ActionEvent e) {
					//if the command name is Set Currency
					if(e.getActionCommand() == "Set currency")
					{
						//then we call the setCurrency method which sets currency for the program
						setCurrency();
					} 
					//if the command name is Set minimum coin input value
					else if(e.getActionCommand() == "Set minimum coin input value")
					{
						//then we call the setMinCoinInput method which sets minimum coin input value for the program
						setMinCoinInput();
					} 
					//if the command name is Set maximum coin input value
					else if(e.getActionCommand() == "Set maximum coin input value")
					{
						//then we call the setMaxCoinInput method which sets maximum coin input value for the program
						setMaxCoinInput();
					} 
					//if the command name is Return to main menu
					else if(e.getActionCommand() == "Return to main menu")
					{
						//then we call the returnToMainMenu method which takes the user back to the main menu
						returnToMainMenu();
						
					}
				
				}  
			});
			//add the button the panel
			add(button);
		}
		
	}

	protected void setMaxCoinInput() {
		//Prompt user to enter a value for maximum value
		String maxInput= JOptionPane.showInputDialog("Maximum input value: ");
		//Lets make sure the result from JOptionPane isn't empty first
		if(!maxInput.isEmpty())
		{
			//Initialize coinSorter object with the maximum coin value
			TestCoinSorter.coinSorter.setMaxCoinIn(Integer.parseInt(maxInput));
		}	
		
	}

	protected void setMinCoinInput() {
		//Prompt user to enter a value for maximum value
		String minInput = JOptionPane.showInputDialog("Enter currency");
		//Lets make sure the result from JOptionPane isn't empty first
		if(!minInput.isEmpty())
		{		
			//Initialize coinSorter object with the minimum coin value
			TestCoinSorter.coinSorter.setMinCoinIn(Integer.parseInt(minInput));
		}
		
	}

	//Create a combo box for currencies
	protected void setCurrency() {
		String currencies[] = {"£", "P"}; 
		currencyCombo = new JComboBox(currencies); 
		currencyCombo.addItemListener(new ItemListener(){
			@Override
			public void itemStateChanged(ItemEvent e) {
				 if (e.getSource() == currencyCombo) { 
					//Initialize coinSorter object with the currency value 
					 TestCoinSorter.coinSorter.setCurrency(currencyCombo.getSelectedItem().toString());						
			        } 
				
			}  
					
			}); 
		//Add the combo box to message dialog and display
		JOptionPane.showMessageDialog(null, currencyCombo, "Set Currency", JOptionPane.INFORMATION_MESSAGE);
		
	}
	
	protected void returnToMainMenu() {
		//hide the sub menu dialog 
		MainPanel.subMenudialog.setVisible(false);
		//show the main window
		TestCoinSorter.mainDialog.setVisible(true);
	}
	
}
