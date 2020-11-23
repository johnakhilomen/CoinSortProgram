package com.coinsort.johnakhilomen;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


public class testCoinSorter {

	public static JDialog mainDialog;
	public static CoinSorter coinSorter; 
	public static void main(String[] args) {
		
		  int p200 = 0;
		  int p100 = 0;
		  int p50 = 0;
		  int p30 = 0;
		  int p10 = 0;
		  
		Integer[] intArr = new Integer[] {200,100,50,30,10};
		
		coinSorter = new CoinSorter("P", 0, 562, new ArrayList<Integer>(Arrays.asList(intArr)));
		System.out.println(coinSorter.multiCoinCalculator(562, 50));
		
		/*coinSorter.toCoins(562, new ArrayList<Integer>(Arrays.asList(intArr)));
		var yy = coinSorter.y;
		for (int i = 0; i < yy.size(); i++)
		{
			//System.out.print(result.get(i));
			if(yy.get(i)==200)
		      {
		        p200++;
		      }
		      else if(yy.get(i)==100)
		      {
		        p100++;
		      }
		      else if(yy.get(i)==50)
		      {
		        p50++;
		      }
		      else if(yy.get(i)==30)
		      {
		        p30++;
		      }
		      else if(yy.get(i)==10)
		      {
		        p10++;
		      }
		}*/
		
		/*var result = toCoins(562, new ArrayList<Integer>(Arrays.asList(intArr)));
		for (int i = 0; i < y.size(); i++)
		{
			//System.out.print(result.get(i));
			if(y.get(i)==200)
		      {
		        p200++;
		      }
		      else if(y.get(i)==100)
		      {
		        p100++;
		      }
		      else if(y.get(i)==50)
		      {
		        p50++;
		      }
		      else if(y.get(i)==30)
		      {
		        p30++;
		      }
		      else if(y.get(i)==10)
		      {
		        p10++;
		      }
		}
		*/
		System.out.println(p200);
		System.out.println(p100);
		String[] buttonNames = new String[] {"Coin calculator", "Multiple coin calculators", "Print coin list", "Set details",
				"Display program configurations", "Quit the program"};
		
		mainDialog = new OptionPaneDialog("Shopping List Program", new MainPanel(buttonNames), false).getDialog();
		mainDialog.show();
		
		//dialog.dispose();
		
			

	}

	
	
}
