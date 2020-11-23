package com.coinsort.johnakhilomen;

import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class OptionPaneDialog extends JOptionPane
{
	private String _title;
	public OptionPaneDialog(String title, JPanel panel, boolean isInput)
	{
		_title = title;
		this.setMessageType(JOptionPane.INFORMATION_MESSAGE );
		this.setMessage(panel);
		this.setWantsInput(isInput);
	}
	
	public JDialog getDialog()
	{
		JDialog dialog =  this.createDialog(null, _title);
		dialog.setAlwaysOnTop(true);
		return dialog;
	}
}
