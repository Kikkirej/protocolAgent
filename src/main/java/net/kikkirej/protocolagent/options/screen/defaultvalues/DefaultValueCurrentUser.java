package net.kikkirej.protocolagent.options.screen.defaultvalues;

public class DefaultValueCurrentUser implements IDefaultValue{

	@Override
	public String getDefaultValue(String Key) {

		return System.getProperty("user.name");
	}

}
