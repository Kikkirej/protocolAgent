package net.kikkirej.protocolagent.options.csv;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import net.kikkirej.protocolagent.options.Value;
import net.kikkirej.protocolagent.properties.PropertyKeys;
import net.kikkirej.protocolagent.properties.PropertyManager;

public class CSVUtil {

	private static final String A = "\"";
	private static final String T = ";";
	private static final String ATA = A+T+A;
	
	public void writeValue(Value[] values) throws IOException {
		String pathToProtocolFile = getPathToProtocolFile(values);
		File protocolFile = new File(pathToProtocolFile);
		if(!protocolFile.exists()){
			protocolFile.createNewFile();
			writeLineToProtocolFile(generateCSVHeader(values),protocolFile);
		}
		writeLineToProtocolFile(generateCSVValues(values),protocolFile);
	}

	private String generateCSVValues(Value[] values) {
		String valueString = A;
		for (int i = 1; i < values.length; i++) {
			valueString+=values[i].getValue()+ATA;
		}
		valueString = valueString.substring(0, valueString.length()-2);
		return valueString;
	}

	@Deprecated
	private void writeLineToProtocolFile(String generatedCSVHeader, File protocolFile) throws IOException {
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(protocolFile, true));
		bufferedWriter.append(generatedCSVHeader +"\n");
		bufferedWriter.close();
	}

	private String getPathToProtocolFile(Value[] values) {
		String pathToSavedLogs = PropertyManager.getInstance().get(PropertyKeys.PATHTOSAVEDLOGS);
		File file = new File(pathToSavedLogs);
		file.mkdirs();
		pathToSavedLogs = file.getAbsolutePath();
		pathToSavedLogs += File.separator+maskName(values[0].getValue()) + ".csv";
		return pathToSavedLogs;
	}

	private String maskName(String value) {
		value = value.replace(" ", "_");
		if(value.isEmpty()){
			value="stout";	
		}
		return value;
	}

	private String generateCSVHeader(Value[] values) {
		String headerString = A;
		for (int i = 1; i < values.length; i++) {
			headerString+=values[i].getFieldName()+ATA;
		}
		headerString = headerString.substring(0, headerString.length()-2);
		return headerString;
	}

}
