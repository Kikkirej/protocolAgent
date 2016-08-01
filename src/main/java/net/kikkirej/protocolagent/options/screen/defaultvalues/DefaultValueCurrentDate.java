package net.kikkirej.protocolagent.options.screen.defaultvalues;

import net.kikkirej.protocolagent.properties.PropertyKeys;

public class DefaultValueCurrentDate extends DVAbstractDateTime {

	@Override
	protected String getFormat() {
		String dateFormat = propertyManager.get(PropertyKeys.DATEFORMAT);
		return dateFormat;
	}

}
