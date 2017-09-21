package net.kikkirej.protocolagent.followtask;

import java.io.File;
import java.io.IOException;

import net.kikkirej.protocolagent.followtask.commandreplacement.Commandreplacer;
import net.kikkirej.protocolagent.properties.PropertyKeys;
import net.kikkirej.protocolagent.properties.PropertyManager;

public class Followtask {

	private Boolean active;
	private String command;
	private File writtenFile;

	public Followtask(File writtenFile) {
		this.writtenFile = writtenFile;
		active = getActivationState();
		if (active) {
			command = getCommand();
			executeCommand();
		}
	}

	private void executeCommand() {
		try {
			Runtime.getRuntime().exec(command);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private Boolean getActivationState() {
		PropertyManager propertyManager = PropertyManager.getInstance();
		String property = propertyManager.get(PropertyKeys.FOLLOWINGTASK_ACTIVE);
		if(property != null && property.equalsIgnoreCase("true")) {
			return true;
		}
		return false;
	}

	private String getCommand() {
		PropertyManager propertyManager = PropertyManager.getInstance();
		String property = propertyManager.get(PropertyKeys.FOLLOWINGTASK_COMMAND);
		String command = replaceCommandPlacholder(property);
		return command;
	}

	private String replaceCommandPlacholder(String property) {
		Commandreplacer commandreplacer = new Commandreplacer(writtenFile);
		String replacedCommand = commandreplacer.replace(command);
		return replacedCommand;
	}
}
