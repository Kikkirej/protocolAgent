package net.kikkirej.protocolagent.followtask.commandreplacement;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import net.kikkirej.protocolagent.followtask.commandreplacement.replacer.abstr.ICommandReplacer;
import net.kikkirej.protocolagent.followtask.commandreplacement.replacer.abstr.IWrittenFileReplacer;
import net.kikkirej.protocolagent.followtask.commandreplacement.replacer.impl.FilenameReplacer;
import net.kikkirej.protocolagent.followtask.commandreplacement.replacer.impl.FilepathReplacer;
import net.kikkirej.protocolagent.followtask.commandreplacement.replacer.impl.UsernameReplacer;

public class Commandreplacer {

	private File writtenFile;
	private Map<String, ICommandReplacer> possibleReplacer;

	public Commandreplacer(File writtenFile) {
		this.writtenFile = writtenFile;
		possibleReplacer = getPossibleReplacer();
	}
	
	public String replace(String command) {
		for (String key : possibleReplacer.keySet()) {
			handleKey(key, command);
		}
		return command;
	}
	
	private void handleKey(String key, String command) {
		String checkedKey = getCheckedKey(key);
		if(command.contains(checkedKey)) {
			command = replaceWithKey(key, command);
		}
	}

	private String replaceWithKey(String key, String command) {
		ICommandReplacer commandReplacer = possibleReplacer.get(key);
		setMetaData(commandReplacer);
		return commandReplacer.replace(command, getCheckedKey(key));
	}

	private void setMetaData(ICommandReplacer iCommandReplacer) {
		if (iCommandReplacer instanceof IWrittenFileReplacer) {
			IWrittenFileReplacer writtenFileReplacer = (IWrittenFileReplacer) iCommandReplacer;
			writtenFileReplacer.setFile(writtenFile);
		}
	}

	private String getCheckedKey(String key) {
		return "%" + key + "%";
	}

	private Map<String, ICommandReplacer> getPossibleReplacer(){
		Map<String, ICommandReplacer> map = new HashMap<>();
		map.put("filename", new FilenameReplacer());
		map.put("filepath", new FilepathReplacer());
		map.put("username", new UsernameReplacer());	
		return map;
	}
}
