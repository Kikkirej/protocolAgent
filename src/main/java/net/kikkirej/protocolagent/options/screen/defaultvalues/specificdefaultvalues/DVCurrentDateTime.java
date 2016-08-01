package net.kikkirej.protocolagent.options.screen.defaultvalues.specificdefaultvalues;

import net.kikkirej.protocolagent.options.screen.defaultvalues.DVAbstractDateTime;
import net.kikkirej.protocolagent.properties.PropertyKeys;

public class DefaultValueCurrentDateTime extends DVAbstractDateTime {
	@Override	
	protected String getFormat() {
		String dateFormat = propertyManager.get(PropertyKeys.DATEFORMAT);
		String timeFormat = propertyManager.get(PropertyKeys.TIMEFORMAT);
		return dateFormat + " - " + timeFormat;
	}

}
