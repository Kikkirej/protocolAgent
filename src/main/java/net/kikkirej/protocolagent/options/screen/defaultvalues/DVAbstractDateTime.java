package net.kikkirej.protocolagent.options.screen.defaultvalues;

import java.text.SimpleDateFormat;
import java.util.Date;

import net.kikkirej.protocolagent.properties.PropertyManager;

public abstract class DVAbstractDateTime implements IDefaultValue{
	protected PropertyManager propertyManager;

	public DVAbstractDateTime() {
		propertyManager = PropertyManager.getInstance();
	}
	
	@Override
	public String getDefaultValue(String Key) {
		String format=getFormat();
		SimpleDateFormat formatter = new SimpleDateFormat( 
                format); 
        Date currentTime = new Date(); 
        return formatter.format(currentTime); 
	}

	protected abstract String getFormat();
}
