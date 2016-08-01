package net.kikkirej.protocolagent.options.screen.defaultvalues.specificdefaultvalues;

import java.util.Locale;

import net.kikkirej.protocolagent.options.screen.defaultvalues.IDefaultValue;

public class DefaultValueCurrentLanguage implements IDefaultValue{

	@Override
	public String getDefaultValue(String Key) {
		String language = Locale.getDefault().getLanguage();
		return language;
	}

}
