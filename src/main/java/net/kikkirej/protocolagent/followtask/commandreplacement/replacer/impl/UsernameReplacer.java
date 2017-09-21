package net.kikkirej.protocolagent.followtask.commandreplacement.replacer.impl;

import net.kikkirej.protocolagent.followtask.commandreplacement.replacer.abstr.ICommandReplacer;

public class UsernameReplacer implements ICommandReplacer{

	@Override
	public String replace(String command, String replacekey) {
		command.replace(replacekey, getUsername());
		return null;
	}

	private CharSequence getUsername() {
		return System.getProperty("user.name");
	}
	
}
