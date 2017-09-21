package net.kikkirej.protocolagent.followtask.commandreplacement.replacer.impl;

import java.io.File;

import net.kikkirej.protocolagent.followtask.commandreplacement.replacer.abstr.IWrittenFileReplacer;

public class FilenameReplacer implements IWrittenFileReplacer{

	private File writtenFile;

	@Override
	public String replace(String command, String replacekey) {
		if(writtenFile != null) {
			command = command.replace(replacekey, writtenFile.getName());
		}else {
			command = command.replace(replacekey, "");
		}
		return command;
	}

	@Override
	public void setFile(File writtenFile) {
		this.writtenFile = writtenFile;
	}

}
