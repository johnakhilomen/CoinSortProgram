package com.coinsort.johnakhilomen;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


public class testCoinSorter {

	public static MainPanel mainPanel; 
	public static JFrame mainDialog;
	public static CoinSorter coinSorter = new CoinSorter(); 
	public static void main(String[] args) {
		String[] buttonNames = new String[] {"Coin calculator", "Multiple coin calculators", "Print coin list", "Set details",
				"Display program configurations", "Quit the program"};
		mainPanel = new MainPanel(buttonNames);
		mainDialog = new FrameWindow("Shopping List Program", mainPanel);
		mainDialog.setVisible(true);
		
	}

	
	
}
