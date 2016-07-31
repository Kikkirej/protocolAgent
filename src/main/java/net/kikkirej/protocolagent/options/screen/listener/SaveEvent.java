package net.kikkirej.protocolagent.options.screen.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import net.kikkirej.protocolagent.options.Value;
import net.kikkirej.protocolagent.options.csv.CSVUtil;

public class SaveEvent implements ActionListener {

	private Value[] values;
	private CSVUtil csvUtil;

	public SaveEvent(Value[] values) {
		this.values = values;
		// TODO Auto-generated constructor stub
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		csvUtil = new CSVUtil();
			try {
				csvUtil.writeValue(values);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
	}
}
