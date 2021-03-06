package net.kikkirej.protocolagent.options.screen.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.JOptionPane;

import net.kikkirej.protocolagent.followtask.Followtask;
import net.kikkirej.protocolagent.options.Value;
import net.kikkirej.protocolagent.options.output.CSVOutput;
import net.kikkirej.protocolagent.options.output.IOutput;

public class SaveEvent implements ActionListener {

	private Value[] values;
	private IOutput csvUtil;

	public SaveEvent(Value[] values) {
		this.values = values;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String allNeededValuesFilled = allNeededValuesFilled(values);
		if(allNeededValuesFilled == null){
			File writtenFile = writeToFile();
			startFollowingTask(writtenFile);
			System.exit(0);
		}else{
			JOptionPane.showMessageDialog(null, "The Value of the field " +allNeededValuesFilled +" must not be emtpy." , "ERROR", JOptionPane.ERROR_MESSAGE);
		}
	}

	private void startFollowingTask(File writtenFile) {
		try {
			new Followtask(writtenFile);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	private File writeToFile() {
		csvUtil = new CSVOutput();
			try {
				return csvUtil.writeValue(values);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		return null;
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
