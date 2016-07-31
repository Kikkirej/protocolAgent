package net.kikkirej.protocolagent.options.screen.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;

import net.kikkirej.protocolagent.options.Value;

public class CategoryChangedListener implements ActionListener {

	private JComboBox<String> comboBox;
	private Value value;

	public CategoryChangedListener(JComboBox<String> comboBox, Value value) {
		this.comboBox = comboBox;
		this.value = value;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object selectedItem = comboBox.getSelectedItem();
		if (selectedItem instanceof String) {
			String newCategoryValue = (String) selectedItem;
			this.value.setValue(newCategoryValue);
		}
	}

}
