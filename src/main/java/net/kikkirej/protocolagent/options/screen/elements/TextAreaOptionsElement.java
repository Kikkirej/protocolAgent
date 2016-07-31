package net.kikkirej.protocolagent.options.screen.elements;

import javax.swing.JLabel;
import javax.swing.JTextField;

import net.kikkirej.protocolagent.options.Value;
import net.kikkirej.protocolagent.options.screen.listener.OptionElementChangedListener;

public class TextAreaOptionsElement extends OptionsElement {

	public TextAreaOptionsElement(String bezeichner) {
		super(bezeichner);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Value generateElement() {
		JLabel label = getLabel(name);
		JTextField jTextArea = new JTextField(defaultValue);
		//jTextArea.setLineWrap(true);
		//jTextArea.setWrapStyleWord(true);
		frame.add(label);
		frame.add(jTextArea);
		Value value = new Value(defaultValue, name);
		
		jTextArea.getDocument().addDocumentListener(new OptionElementChangedListener(value, jTextArea));

		value.setNeededValue(isNeeded);

		return value;
	}

	@Override
	public void setValue(String value) {
		// TODO Auto-generated method stub

	}

}
