package com.coinsort.johnakhilomen;

import javax.swing.JComboBox;

public class InputDenominationCombo{

	public JComboBox getJComoBox(String[] denominations) {
		JComboBox inputDenomination = new JComboBox(denominations); 
		inputDenomination.setFont(MainPanel.font);
		return inputDenomination;
	}
	
}
