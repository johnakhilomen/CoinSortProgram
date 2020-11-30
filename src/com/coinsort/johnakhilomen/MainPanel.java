package com.coinsort.johnakhilomen;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

//A class to create main panel. The main panel is used to display the main menu on the main window
public class MainPanel extends JPanel{
	public static Font font = new Font("Verdana", Font.PLAIN, 16);
	private static FrameWindow coinCalcFrame, multcoinCalcFrame;
	private String[] _buttonNames;
	
	public static JFrame subMenudialog;
	public MainPanel(String[] buttonNames)
	{
		_buttonNames = buttonNames;
		setLayout(new GridLayout(3,3));
		setupButtons();
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
					else if(e.getActionCommand() == "Multiple coin calculator")
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

	//Exits application
	protected void quitTheProgram() {
	System.exit(0);	
	}

	//Displays a concatenated string of the configuration settings for the program
	protected void displayProgramConfigurations() {
		String info = "Min Value :" + TestCoinSorter.coinSorter.getMinCoinIn() +"\n"
				+"Max Value : "+ TestCoinSorter.coinSorter.getMaxCoinIn()+"\n"
				+"Currency :" + TestCoinSorter.coinSorter.getCurrency();
		JOptionPane.showMessageDialog(null, info, "Display Program Configuration", JOptionPane.INFORMATION_MESSAGE);
	}

	//UI setup for set-details sub menu
	protected void setDetails() {
		String[] subMenuButtonNames = new String[] {"Set currency", "Set minimum coin input value", "Set maximum coin input value",
		"Return to main menu"};
		//Instantiate a new frame window and initialize it with a new DisplayProgramConfigurationsPanel window
		subMenudialog = new FrameWindow("Set Details Sub-Menu", new DisplayProgramConfigurationsPanel(subMenuButtonNames));
		//We hide the main window
		TestCoinSorter.mainDialog.setVisible(false);
		//show DisplayProgramConfigurationsPanel window
		subMenudialog.setVisible(true);	
	}

	//Displays coin lost 
	protected void printCoinList() {
		JOptionPane.showMessageDialog(null, TestCoinSorter.coinSorter.printCoinList());
	}

	//Multiple coin calculator UI
	protected void multipleCoinCalculator() {
		
		var multcoinCalcPanel = new JPanel();
		multcoinCalcPanel.setLayout(new GridLayout(3,3));
		JLabel multcoinValue = new JLabel("Enter value "+TestCoinSorter.coinSorter.getCurrency()+": ");
		multcoinValue.setFont(font);
		JTextField multcoinValueTextField = new JTextField();
		multcoinValueTextField.setFont(font);
		JLabel multcoinType = new JLabel("Enter coin type to exclude: ");
		multcoinType.setFont(font);
		
		var inputDenomination = new InputDenominationCombo().getJComoBox(TestCoinSorter.inputDenominationsMultiplecoins);
		JButton submit = new JButton("Submit");
		submit.setFont(font);
		submit.addActionListener(new ActionListener(){  
			@Override
			public void actionPerformed(ActionEvent e) {
				
				if ( !validateInputValueRange(Integer.parseInt(multcoinValueTextField.getText())))
				{
					JOptionPane.showMessageDialog(null, "Invalid input - Value must be in the range of Min and Max values set!");
					return;
				}
				else if(!validateInput(multcoinValueTextField.getText()))
				{
					JOptionPane.showMessageDialog(null, "Invalid input for Coin Value - Only integers are allowed!");
					return;
				}
				else if (TestCoinSorter.coinSorter.getCurrency() == null)
				{
					JOptionPane.showMessageDialog(null, "Please set the currency in \n Display Program Configuration menu!");
					return;
				}
				else
				{
					var inputDenominationStr = inputDenomination.getSelectedItem().toString().substring(1);
					TestCoinSorter.coinList = new ArrayList<String>(Arrays.asList(TestCoinSorter.inputDenominationsMultiplecoins));
					var coinSorter = new CoinSorter(TestCoinSorter.coinSorter.getCurrency(), TestCoinSorter.minValue, TestCoinSorter.maxValue, TestCoinSorter.coinList);
					String result = coinSorter.multiCoinCalculator(Integer.parseInt(multcoinValueTextField.getText()), Integer.parseInt(inputDenominationStr) );
					JOptionPane.showMessageDialog(null, result, "Multiple Coin Calculator", JOptionPane.INFORMATION_MESSAGE);
				}
		
			}
		});
		
		JButton returnToMainMenu = new JButton("Return To Main Menu");
		returnToMainMenu.setFont(font);
		returnToMainMenu.addActionListener(new ActionListener(){  
			@Override
			public void actionPerformed(ActionEvent e) {
				multcoinCalcFrame.setVisible(false);
				TestCoinSorter.mainDialog.setVisible(true);
			}
		});
		
		multcoinCalcPanel.add(multcoinValue);
		multcoinCalcPanel.add(multcoinValueTextField);
		multcoinCalcPanel.add(multcoinType);
		multcoinCalcPanel.add(inputDenomination);
		multcoinCalcPanel.add(returnToMainMenu);
		multcoinCalcPanel.add(submit);
		
		multcoinCalcFrame = new FrameWindow("Multiple Coin Calculator", multcoinCalcPanel);
		multcoinCalcFrame.setVisible(true);
		TestCoinSorter.mainDialog.setVisible(false);
		multcoinCalcFrame.setLocationRelativeTo(TestCoinSorter.mainDialog);
	
		
	}

	//Coin calculator UI setup
	protected void coinCalculator() {
		var coinCalcPanel = new JPanel();
		coinCalcPanel.setLayout(new GridLayout(3,3));
		JLabel coinValue = new JLabel("Enter value "+TestCoinSorter.coinSorter.getCurrency()+": ");
		coinValue.setFont(font);
		JTextField coinValueTextField = new JTextField();
		coinValueTextField.setFont(font);
		JLabel coinType = new JLabel("Select coin type: ");
		coinType.setFont(font);
		var inputDenomination = new InputDenominationCombo().getJComoBox(TestCoinSorter.inputDenominations); 
		JButton submit = new JButton("Submit");
		submit.setFont(font);
		submit.addActionListener(new ActionListener(){  
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println(TestCoinSorter.coinSorter.getCurrency());
				if ( !validateInputValueRange(Integer.parseInt(coinValueTextField.getText())))
				{
					//Shows a message if user enters a value that's not in the range or minimum and maximum values
					JOptionPane.showMessageDialog(null, "Invalid input - Value must be in the range of Min and Max values set!");
					return;
				}
				else if(!validateInput(coinValueTextField.getText()))
				{
					//Shows a message if user enters a value that's not integer
					JOptionPane.showMessageDialog(null, "Invalid input for Coin Value - Only integers are allowed!");
					return;
				}
				else if (TestCoinSorter.coinSorter.getCurrency() == null)
				{
					//Shows a message if no currency is set
					JOptionPane.showMessageDialog(null, "Please set the currency in \n Display Program Configuration menu!");
					return;
				}
				else
				{
					var inputDenominationStr = inputDenomination.getSelectedItem().toString().substring(1);
					var coinSorter = new CoinSorter(TestCoinSorter.coinSorter.getCurrency(), TestCoinSorter.minValue, TestCoinSorter.maxValue, TestCoinSorter.coinList);
					String result = coinSorter.coinCalculator(Integer.parseInt(coinValueTextField.getText()), Integer.parseInt(inputDenominationStr) );
					JOptionPane.showMessageDialog(null, result, "Coin Calculator", JOptionPane.INFORMATION_MESSAGE);

				}
		
			}
		});
		
		JButton returnToMainMenu = new JButton("Return To Main Menu");
		returnToMainMenu.setFont(font);
		returnToMainMenu.addActionListener(new ActionListener(){  
			@Override
			public void actionPerformed(ActionEvent e) {
				coinCalcFrame.setVisible(false);
				TestCoinSorter.mainDialog.setVisible(true);
			}
		});
		
		coinCalcPanel.add(coinValue);
		coinCalcPanel.add(coinValueTextField);
		coinCalcPanel.add(coinType);
		coinCalcPanel.add(inputDenomination);
		coinCalcPanel.add(returnToMainMenu);
		coinCalcPanel.add(submit);
		
		coinCalcFrame = new FrameWindow("Coin Calculator", coinCalcPanel);
		coinCalcFrame.setVisible(true);
		TestCoinSorter.mainDialog.setVisible(false);
		coinCalcFrame.setLocationRelativeTo(TestCoinSorter.mainDialog);
		
	}
	
	//Validate input for integer
	private boolean validateInput(String input)
	{
		try {
			//return true if the input is integer
	        Integer num = Integer.valueOf(input);
	        return true;
	    } catch (NumberFormatException e) {
	    	//Display exception message if input is not integer and return false;
	    	JOptionPane.showMessageDialog(null, "Exception thrown", "Exception", JOptionPane.INFORMATION_MESSAGE);
	        return false;
	    }
	}

	//Validate that input is in the range of minimum and maximum values
	private boolean validateInputValueRange(int value)
	{
		if ( !(value >= TestCoinSorter.coinSorter.getMinCoinIn() && (value <= TestCoinSorter.coinSorter.getMaxCoinIn()) ) )
		{
			//returns false if input isn't in the range of minimum and maximum values
			return false;
		}
		//returns true if input is in the range of minimum and maximum values
		return true;
	}
}
