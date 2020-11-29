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


public class TestCoinSorter {

	//main panel for the main window
	public static MainPanel mainPanel; 
	//main frame for main window
	public static JFrame mainDialog;
	//a static object for instantiating coin sorter
	public static CoinSorter coinSorter; 
	//default minimum value set to 0
	public static int minValue = 0;
	//default maximum value set to 10000
	public static int maxValue = 10000;
	public static ArrayList<String> coinList;
	//default coin list for multiple coin calculator
	public static  String[] inputDenominationsMultiplecoins = new String[] {"P200","P100", "P50", "P30","P20","P10"};
	//default coin list for coin calculator
	public static  String[] inputDenominations = new String[] {"£2", "£1", "P200","P100", "P50", "P30","P20","P10"};
	public static void main(String[] args) {
		//default menus  
		String[] buttonNames = new String[] {"Coin calculator", "Multiple coin calculator", "Print coin list", "Set details",
				"Display program configurations", "Quit the program"};
		coinList = new ArrayList<String>(Arrays.asList(inputDenominations));
		coinSorter = new CoinSorter("£", 0, 10000, coinList);
		//Lets create main panel with buttons
		mainPanel = new MainPanel(buttonNames);
		//Lets add main panel to the main frame or main window
		mainDialog = new FrameWindow("Coin sorting program", mainPanel);
		//show main frame or main window when the program starts
		mainDialog.setVisible(true);
	}
	
}
