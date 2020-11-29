package com.coinsort.johnakhilomen;

import javax.swing.JComboBox;

public class InputDenominationCombo{

	//A class to create a combo box when needed
	public JComboBox getJComoBox(String[] denominations) {
		JComboBox inputDenomination = new JComboBox(denominations); 
		inputDenomination.setFont(MainPanel.font);
		return inputDenomination;
	}
	
}
