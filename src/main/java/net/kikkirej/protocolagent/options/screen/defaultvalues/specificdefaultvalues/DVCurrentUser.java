package net.kikkirej.protocolagent.options.screen.defaultvalues.specificdefaultvalues;

import net.kikkirej.protocolagent.options.screen.defaultvalues.IDefaultValue;

public class DVCurrentUser implements IDefaultValue{

	@Override
	public String getDefaultValue(String Key) {

		return System.getProperty("user.name");
	}

}
