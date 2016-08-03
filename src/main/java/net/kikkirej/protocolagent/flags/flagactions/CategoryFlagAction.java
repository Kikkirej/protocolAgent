package net.kikkirej.protocolagent.flags.flagactions;

import net.kikkirej.protocolagent.flags.Flag;
import net.kikkirej.protocolagent.properties.PropertyKeys;
import net.kikkirej.protocolagent.properties.PropertyManager;

public class CategoryFlagAction implements IFlagAction {

	@Override
	public void execute(Flag f) {
		PropertyManager propertyManager = PropertyManager.getInstance();
		propertyManager.set(PropertyKeys.DEFAULTCATEGORY, f.getFlagvalue());
	}

}
