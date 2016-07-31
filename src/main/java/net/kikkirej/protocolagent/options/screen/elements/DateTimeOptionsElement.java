package net.kikkirej.protocolagent.options.screen.elements;

import javax.swing.JLabel;
import javax.swing.JTextField;

import net.kikkirej.protocolagent.options.Value;

public class DateTimeOptionsElement extends OptionsElement {

	public DateTimeOptionsElement(String bezeichner) {
		super(bezeichner);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Value generateElement() {
		JLabel label = getLabel(name);
		JTextField jTextField = new JTextField(defaultValue);
		
		frame.add(label);
		frame.add(jTextField);
		return null;
	}

	@Override
	public void setValue(String value) {
		// TODO Auto-generated method stub

	}

}
