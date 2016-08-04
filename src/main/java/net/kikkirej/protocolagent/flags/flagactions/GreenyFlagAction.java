package net.kikkirej.protocolagent.flags.flagactions;

import net.kikkirej.protocolagent.flags.Flag;

public class GreenyFlagAction implements IFlagAction {

	@Override
	public void execute(Flag f) {
		System.out.println("Du hast ein gruenes Easteregg gefunden!");

	}

}
