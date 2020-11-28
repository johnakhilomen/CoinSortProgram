package com.coinsort.johnakhilomen;

import javax.swing.JComboBox;

public class inputDenominationCombo{

	public JComboBox getJComoBox(String[] denominations) {
		JComboBox inputDenomination = new JComboBox(denominations); 
		inputDenomination.setFont(MainPanel.font);
		return inputDenomination;
	}
	
}
