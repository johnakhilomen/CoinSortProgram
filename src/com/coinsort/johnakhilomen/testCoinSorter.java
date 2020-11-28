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
	public static CoinSorter coinSorter; 
	public static int minValue = 0;
	public static int maxValue = 10000;
	public static ArrayList<String> coinList;
	public static  String[] inputDenominationsMultiplecoins = new String[] {"P200","P100", "P50", "P30","P20","P10"};
	public static  String[] inputDenominations = new String[] {"£2", "£1", "P200","P100", "P50", "P30","P20","P10"};
	public static void main(String[] args) {
		String[] buttonNames = new String[] {"Coin calculator", "Multiple coin calculators", "Print coin list", "Set details",
				"Display program configurations", "Quit the program"};
		coinList = new ArrayList<String>(Arrays.asList(inputDenominations));
		coinSorter = new CoinSorter("£", 0, 10000, coinList);
		mainPanel = new MainPanel(buttonNames);
		mainDialog = new FrameWindow("Shopping List Program", mainPanel);
		mainDialog.setVisible(true);
		
	}
	
}
