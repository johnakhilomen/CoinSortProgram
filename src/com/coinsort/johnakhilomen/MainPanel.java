package com.coinsort.johnakhilomen;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MainPanel extends JPanel{
	private Font font = new Font("Verdana", Font.PLAIN, 16);
	private static FrameWindow coinCalcFrame;
	private String[] _buttonNames;
	public static JLabel _currencyLabel = new JLabel("Currency");
	public static JLabel _minInputLabel = new JLabel("Min Input");
	public static JLabel _maxInputLabel = new JLabel("Max Input");
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
		_currencyLabel.setForeground(Color.red);
		_minInputLabel.setForeground(Color.red);
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
		String[] subMenuButtonNames = new String[] {"Set currency", "Set minimum coin input value", "Set maximum coin input value",
		"Return to main menu"};
		subMenudialog = new FrameWindow("Set Details Sub-Menu", new DisplayProgramConfigurationsPanel(subMenuButtonNames));
		testCoinSorter.mainDialog.setVisible(false);
		subMenudialog.setVisible(true);
	}

	protected void setDetails() {
		// TODO Auto-generated method stub
		
	}

	protected void printCoinList() {
		// TODO Auto-generated method stub
		//_currencyLabel.setText(testCoinSorter.coinSorter.getCurrency());
	}

	protected void multipleCoinCalculator() {
		// TODO Auto-generated method stub
		
	}

	protected void coinCalculator() {
		var coinCalcPanel = new JPanel();
		coinCalcPanel.setLayout(new GridLayout(3,3));
		JLabel coinValue = new JLabel("Enter value: ");
		coinValue.setFont(font);
		JTextField coinValueTextField = new JTextField();
		coinValueTextField.setFont(font);
		JLabel coinType = new JLabel("Enter coin type: ");
		coinType.setFont(font);
		JTextField coinTypeTextField = new JTextField();
		coinTypeTextField.setFont(font);
		JButton submit = new JButton("Submit");
		submit.setFont(font);
		submit.addActionListener(new ActionListener(){  
			@Override
			public void actionPerformed(ActionEvent e) {
				if(!validateInput(coinValueTextField.getText()))
				{
					JOptionPane.showMessageDialog(null, "Invalid input for Coin Value - Only integers are allowed!");
					return;
				}
				else if(!validateInput(coinTypeTextField.getText()) )
				{
					JOptionPane.showMessageDialog(null, "Invalid input for Coin type - Only integers are allowed!");
					return;
				}
				else
				{
					String result = testCoinSorter.coinSorter.coinCalculator(Integer.parseInt(coinValueTextField.getText()), Integer.parseInt(coinTypeTextField.getText()) );
					JOptionPane.showMessageDialog(null, result);
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
		coinCalcPanel.add(coinTypeTextField);
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

}
