package net.kikkirej.protocolagent.followtask.commandreplacement.replacer.abstr;

import java.io.File;

public interface IWrittenFileReplacer extends ICommandReplacer {

	void setFile(File writtenFile);
	
}
