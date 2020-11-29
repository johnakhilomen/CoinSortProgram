package com.coinsort.johnakhilomen;

import java.awt.GridLayout;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class FrameWindow extends JFrame
{
	//A class to create a frame window when needed 
	public FrameWindow(String title, JPanel panel)
	{
		//set window's default size 
		 setSize(650, 180);  
		 //place window on the center of the screen
	     setLocationRelativeTo(null);
	     //exit application when window frame closes
	     setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
	     //title
	     this.setTitle(title);
	     //add panel to frame
		 this.add(panel);
	}
	
}
