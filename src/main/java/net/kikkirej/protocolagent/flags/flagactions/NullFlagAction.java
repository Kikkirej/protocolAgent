package net.kikkirej.protocolagent.flags.flagactions;

import net.kikkirej.protocolagent.flags.Flag;

public class NullFlagAction implements IFlagAction {

	@Override
	public void execute(Flag flag) {
		System.out.println("NullFlagAction.execute()");
	}

}
