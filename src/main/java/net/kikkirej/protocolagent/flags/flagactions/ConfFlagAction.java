package net.kikkirej.protocolagent.flags.flagactions;

import net.kikkirej.protocolagent.flags.Flag;
import net.kikkirej.protocolagent.options.screen.OptionsScreen;
import net.kikkirej.protocolagent.properties.PropertyManager;

public class ConfFlagAction implements IFlagAction {

	@Override
	public void execute(Flag flag) {
		PropertyManager propertyManager = PropertyManager.getInstance();
		propertyManager.setPropertyPath(flag.getFlagvalue());
		new OptionsScreen();
	}

}
