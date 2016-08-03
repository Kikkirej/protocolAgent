package net.kikkirej.protocolagent.flags.flagactions;

import net.kikkirej.protocolagent.flags.Flag;
import net.kikkirej.protocolagent.properties.PropertyKeys;
import net.kikkirej.protocolagent.properties.PropertyManager;

public class ValueFlagAction implements IFlagAction {

	@Override
	public void execute(Flag f) {
		PropertyManager propertyManager = PropertyManager.getInstance();
		String definedFields = f.getFlagvalue();
		String defaultValues = propertyManager.get(PropertyKeys.DEFAULTVALUES);
		if(!defaultValues.isEmpty()){
			defaultValues += ";";
		}
		defaultValues += definedFields;
		propertyManager.set(PropertyKeys.DEFAULTVALUES, defaultValues);
	}
}
