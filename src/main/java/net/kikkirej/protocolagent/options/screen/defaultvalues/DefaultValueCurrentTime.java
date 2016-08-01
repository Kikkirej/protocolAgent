package net.kikkirej.protocolagent.options.screen.defaultvalues;

import net.kikkirej.protocolagent.properties.PropertyKeys;

public class DefaultValueCurrentTime extends DVAbstractDateTime{

	@Override
	protected String getFormat() {
		String timeFormat = propertyManager.get(PropertyKeys.TIMEFORMAT);
		return timeFormat;
	}


}
