package net.kikkirej.protocolagent.options.screen.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JOptionPane;

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
		String allNeededValuesFilled = allNeededValuesFilled(values);
		if(allNeededValuesFilled == null){
			writeToFile();
			System.exit(0);
		}else{
			JOptionPane.showMessageDialog(null, "The Value of the field " +allNeededValuesFilled +" must not be emtpy." , "ERROR", JOptionPane.ERROR_MESSAGE);
		}
	}

	private void writeToFile() {
		csvUtil = new CSVUtil();
			try {
				csvUtil.writeValue(values);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
	}
	
	private String allNeededValuesFilled(Value[] values) {
		for (Value v : values) {
			if(v.isNeededValue()){
				if(v.getValue().isEmpty()){
					return v.getFieldName();
				}
			}
		}
		return null;
	}
}
