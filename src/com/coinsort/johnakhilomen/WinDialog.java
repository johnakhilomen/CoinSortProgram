package com.coinsort.johnakhilomen;

import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class WinDialog extends JOptionPane
{
	private String _title;
	public WinDialog(String title, JPanel panel)
	{
		this.setMessageType(JOptionPane.INFORMATION_MESSAGE );
		//this.setMessage(new Panel(buttonNames));
		this.setMessage(panel);
	}
	
	public JDialog getDialog()
	{
		return this.createDialog(null, _title);
	}
}
