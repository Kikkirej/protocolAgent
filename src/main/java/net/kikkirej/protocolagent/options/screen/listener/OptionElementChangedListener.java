package net.kikkirej.protocolagent.options.screen.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import net.kikkirej.protocolagent.options.Value;

public class OptionElementChangedListener implements DocumentListener {

	private Value value;
	private JTextField wert;

	public OptionElementChangedListener(Value value, JTextField wert) {
		this.value = value;
		this.wert = wert;
	}

	@Override
	public void insertUpdate(DocumentEvent e) {
		value.setValue(wert.getText());
		
	}

	@Override
	public void removeUpdate(DocumentEvent e) {
		value.setValue(wert.getText());
		
	}

	@Override
	public void changedUpdate(DocumentEvent e) {
		value.setValue(wert.getText());
		
	}

}
