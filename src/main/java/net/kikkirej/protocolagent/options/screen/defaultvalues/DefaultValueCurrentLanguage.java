package net.kikkirej.protocolagent.options.screen.defaultvalues;

import java.util.Locale;

public class DefaultValueCurrentLanguage implements IDefaultValue{

	@Override
	public String getDefaultValue(String Key) {
		String language = Locale.getDefault().getLanguage();
		return language;
	}

}
