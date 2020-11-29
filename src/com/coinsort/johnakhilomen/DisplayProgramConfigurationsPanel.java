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
					
					if(e.getActionCommand() == "Set currency")
					{
						setCurrency();
						
					} 
					else if(e.getActionCommand() == "Set minimum coin input value")
					{
						setMinCoinInput();
					} 
					else if(e.getActionCommand() == "Set maximum coin input value")
					{
						setMaxCoinInput();
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

	protected void setMaxCoinInput() {
		String input= JOptionPane.showInputDialog("Index number: ");
		TestCoinSorter.coinSorter.setMaxCoinIn(Integer.parseInt(input));
		
		
	}

	protected void setMinCoinInput() {
		String minInput = JOptionPane.showInputDialog("Enter currency");
		TestCoinSorter.coinSorter.setMinCoinIn(Integer.parseInt(minInput));
		
	}

	protected void setCurrency() {
		String currencies[] = {"£", "P"}; 
		currencyCombo = new JComboBox(currencies); 
		currencyCombo.addItemListener(new ItemListener(){

			@Override
			public void itemStateChanged(ItemEvent e) {
				 if (e.getSource() == currencyCombo) { 
					  
					 TestCoinSorter.coinSorter.setCurrency(currencyCombo.getSelectedItem().toString());
						
			        } 
				
			}  
					
			}); 
		JOptionPane.showMessageDialog(null, currencyCombo, "Set Currency", JOptionPane.INFORMATION_MESSAGE);
		
	}

	protected void returnToMainMenu() {
		MainPanel.subMenudialog.setVisible(false);
		TestCoinSorter.mainDialog.setVisible(true);
	}
	
}
