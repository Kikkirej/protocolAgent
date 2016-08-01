package net.kikkirej.protocolagent.options.screen.defaultvalues;

import java.util.HashMap;

import net.kikkirej.protocolagent.options.screen.defaultvalues.specificdefaultvalues.DefaultValueCurrentDate;
import net.kikkirej.protocolagent.options.screen.defaultvalues.specificdefaultvalues.DefaultValueCurrentDateTime;
import net.kikkirej.protocolagent.options.screen.defaultvalues.specificdefaultvalues.DefaultValueCurrentLanguage;
import net.kikkirej.protocolagent.options.screen.defaultvalues.specificdefaultvalues.DefaultValueCurrentTime;
import net.kikkirej.protocolagent.options.screen.defaultvalues.specificdefaultvalues.DefaultValueCurrentUser;

public class DefaultValues {
	private HashMap<String, IDefaultValue> hashMap;

	public DefaultValues() {
		hashMap = new HashMap<>();
		fillHashMap();
	}

	private void fillHashMap() {
		hashMap.put("$CurrentUser", new DefaultValueCurrentUser());
		hashMap.put("$CurrentDateTime", new DefaultValueCurrentDateTime());
		hashMap.put("$CurrentDate", new DefaultValueCurrentDate());
		hashMap.put("$CurrentTime", new DefaultValueCurrentTime());
		hashMap.put("$CurrentLanguage", new DefaultValueCurrentLanguage());
	}
	
	public String get(String key){
		IDefaultValue defaultValueOfInterface = hashMap.getOrDefault(key, new NullDefaultValue());
		return defaultValueOfInterface.getDefaultValue(key);
	}
}
