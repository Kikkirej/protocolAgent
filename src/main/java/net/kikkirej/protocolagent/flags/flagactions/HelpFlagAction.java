package net.kikkirej.protocolagent.flags.flagactions;

import net.kikkirej.protocolagent.flags.Flag;

public class HelpFlagAction implements IFlagAction {

	@Override
	public void execute(Flag f) {
		System.out.println("Hilfe muss noch implementiert werden.");
		System.exit(0);
	}

}
