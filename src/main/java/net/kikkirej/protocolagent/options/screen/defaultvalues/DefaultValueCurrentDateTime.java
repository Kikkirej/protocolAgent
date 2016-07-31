package net.kikkirej.protocolagent.options.screen.defaultvalues;

import java.text.SimpleDateFormat;
import java.util.Date;

import net.kikkirej.protocolagent.properties.PropertyKeys;
import net.kikkirej.protocolagent.properties.PropertyManager;

public class DefaultValueCurrentDateTime implements IDefaultValue {

	@Override
	public String getDefaultValue(String Key) {
		SimpleDateFormat formatter = new SimpleDateFormat( 
                PropertyManager.getInstance().get(PropertyKeys.DATEFORMAT)); 
        Date currentTime = new Date(); 
        return formatter.format(currentTime); 
	}

}
