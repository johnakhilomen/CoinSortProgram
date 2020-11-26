package com.coinsort.johnakhilomen;

import java.awt.GridLayout;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class FrameWindow extends JFrame
{
	public FrameWindow(String title, JPanel panel)
	{
		 setSize(650, 180);  
	     setLocationRelativeTo(null);  
	     setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
	     this.setTitle(title);
		 this.add(panel);
	}
	
}
