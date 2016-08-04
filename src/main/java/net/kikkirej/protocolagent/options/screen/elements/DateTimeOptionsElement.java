package net.kikkirej.protocolagent.options.screen.elements;

import javax.swing.JLabel;
import javax.swing.JTextField;

import net.kikkirej.protocolagent.options.Value;
import net.kikkirej.protocolagent.options.screen.listener.OptionElementChangedListener;

public class DateTimeOptionsElement extends OptionsElement {

	public DateTimeOptionsElement(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Value generateElement() {
		JLabel label = getLabel(name);
		JTextField jTextField = new JTextField(defaultValue);

		frame.add(label);
		frame.add(jTextField);

		Value value = new Value(defaultValue, name);

		jTextField.getDocument().addDocumentListener(new OptionElementChangedListener(value, jTextField));

		value.setNeededValue(isNeeded);

		return value;
	}

	@Override
	public void setValue(String value) {
		// TODO Auto-generated method stub
	}

}
