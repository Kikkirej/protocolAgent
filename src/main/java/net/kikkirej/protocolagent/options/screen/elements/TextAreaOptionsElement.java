package net.kikkirej.protocolagent.options.screen.elements;

import javax.swing.JLabel;
import javax.swing.JTextField;

import net.kikkirej.protocolagent.options.Value;

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
		return null;
	}

	@Override
	public void setValue(String value) {
		// TODO Auto-generated method stub

	}

}
