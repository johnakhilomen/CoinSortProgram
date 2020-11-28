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

public class MainPanel extends JPanel{
	public static Font font = new Font("Verdana", Font.PLAIN, 16);
	private static FrameWindow coinCalcFrame, multcoinCalcFrame;
	private String[] _buttonNames;
	public static JLabel _currencyLabel = new JLabel();
	public static JLabel _minInputLabel = new JLabel();
	public static JLabel _maxInputLabel = new JLabel();
	public static JFrame subMenudialog;
	public MainPanel(String[] buttonNames)
	{
		_buttonNames = buttonNames;
		setLayout(new GridLayout(3,3));
		setupLabels();
		setupButtons();
	}

	private void setupLabels()
	{
		_currencyLabel.setText("Currecncy: "+testCoinSorter.coinSorter.getCurrency());
		_currencyLabel.setForeground(Color.red);
		_minInputLabel.setText("Min Input: "+testCoinSorter.coinSorter.getMinCoinIn());
		_minInputLabel.setForeground(Color.red);
		_maxInputLabel.setText("Max Input: "+testCoinSorter.coinSorter.getMaxCoinIn());
		_maxInputLabel.setForeground(Color.red);
		add(_currencyLabel);
		add(_minInputLabel);
		add(_maxInputLabel);
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
		String info = "Min Value :" + testCoinSorter.minValue +"\n"
				+"Max Value : "+ testCoinSorter.maxValue+"\n"
				+"Currency :" + testCoinSorter.coinSorter.getCurrency();
		JOptionPane.showMessageDialog(null, info, "Display Program Configuration", JOptionPane.INFORMATION_MESSAGE);
	}

	protected void setDetails() {
		String[] subMenuButtonNames = new String[] {"Set currency", "Set minimum coin input value", "Set maximum coin input value",
		"Return to main menu"};
		subMenudialog = new FrameWindow("Set Details Sub-Menu", new DisplayProgramConfigurationsPanel(subMenuButtonNames));
		testCoinSorter.mainDialog.setVisible(false);
		subMenudialog.setVisible(true);	
	}

	protected void printCoinList() {
		JOptionPane.showMessageDialog(null, testCoinSorter.coinSorter.printCoinList());
	}

	protected void multipleCoinCalculator() {
		
		var multcoinCalcPanel = new JPanel();
		multcoinCalcPanel.setLayout(new GridLayout(3,3));
		JLabel multcoinValue = new JLabel("Enter value "+testCoinSorter.coinSorter.getCurrency()+": ");
		multcoinValue.setFont(font);
		JTextField multcoinValueTextField = new JTextField();
		multcoinValueTextField.setFont(font);
		JLabel multcoinType = new JLabel("Enter coin type to exclude: ");
		multcoinType.setFont(font);
		//JTextField multcoinTypeTextField = new JTextField();
		//multcoinTypeTextField.setFont(font);
		
		var inputDenomination = new inputDenominationCombo().getJComoBox(testCoinSorter.inputDenominationsMultiplecoins);
		JButton submit = new JButton("Submit");
		submit.setFont(font);
		submit.addActionListener(new ActionListener(){  
			@Override
			public void actionPerformed(ActionEvent e) {
				//System.out.println(testCoinSorter.coinSorter.getCurrency());
				
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
				else if (testCoinSorter.coinSorter.getCurrency() == null)
				{
					JOptionPane.showMessageDialog(null, "Please set the currency in \n Display Program Configuration menu!");
					return;
				}
				else
				{
					var inputDenominationStr = inputDenomination.getSelectedItem().toString().substring(1);
					testCoinSorter.coinList = new ArrayList<String>(Arrays.asList(testCoinSorter.inputDenominationsMultiplecoins));
					var coinSorter = new CoinSorter(testCoinSorter.coinSorter.getCurrency(), testCoinSorter.minValue, testCoinSorter.maxValue, testCoinSorter.coinList);
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
				testCoinSorter.mainDialog.setVisible(true);
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
		testCoinSorter.mainDialog.setVisible(false);
		multcoinCalcFrame.setLocationRelativeTo(testCoinSorter.mainDialog);
	
		
	}

	protected void coinCalculator() {
		var coinCalcPanel = new JPanel();
		coinCalcPanel.setLayout(new GridLayout(3,3));
		JLabel coinValue = new JLabel("Enter value "+testCoinSorter.coinSorter.getCurrency()+": ");
		coinValue.setFont(font);
		JTextField coinValueTextField = new JTextField();
		coinValueTextField.setFont(font);
		JLabel coinType = new JLabel("Enter coin type: ");
		coinType.setFont(font);
		var inputDenomination = new inputDenominationCombo().getJComoBox(testCoinSorter.inputDenominations); 
		JButton submit = new JButton("Submit");
		submit.setFont(font);
		submit.addActionListener(new ActionListener(){  
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println(testCoinSorter.coinSorter.getCurrency());
				if ( !validateInputValueRange(Integer.parseInt(coinValueTextField.getText())))
				{
					JOptionPane.showMessageDialog(null, "Invalid input - Value must be in the range of Min and Max values set!");
					return;
				}
				else if(!validateInput(coinValueTextField.getText()))
				{
					JOptionPane.showMessageDialog(null, "Invalid input for Coin Value - Only integers are allowed!");
					return;
				}
				else if (testCoinSorter.coinSorter.getCurrency() == null)
				{
					JOptionPane.showMessageDialog(null, "Please set the currency in \n Display Program Configuration menu!");
					return;
				}
				else
				{
					var inputDenominationStr = inputDenomination.getSelectedItem().toString().substring(1);
					var coinSorter = new CoinSorter(testCoinSorter.coinSorter.getCurrency(), testCoinSorter.minValue, testCoinSorter.maxValue, testCoinSorter.coinList);
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
				testCoinSorter.mainDialog.setVisible(true);
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
		testCoinSorter.mainDialog.setVisible(false);
		coinCalcFrame.setLocationRelativeTo(testCoinSorter.mainDialog);
		
	}
	
	private boolean validateInput(String input)
	{
		try {
	        Integer num = Integer.valueOf(input);
	        //System.out.println("is a number");
	        return true;
	    } catch (NumberFormatException e) {
	        // TODO: handle exception
	        //System.out.println("is not a number");
	        return false;
	    }
	}

	private boolean validateInputValueRange(int value)
	{
		if ( !(value >= testCoinSorter.coinSorter.getMinCoinIn() && (value <= testCoinSorter.coinSorter.getMaxCoinIn()) ) )
		{
			return false;
		}	
		return true;
	}
}
