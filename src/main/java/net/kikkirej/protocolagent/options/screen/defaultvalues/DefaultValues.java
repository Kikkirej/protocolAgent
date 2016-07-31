package net.kikkirej.protocolagent.options.screen.defaultvalues;

import java.util.HashMap;

public class DefaultValues {
	private HashMap<String, IDefaultValue> hashMap;

	public DefaultValues() {
		hashMap = new HashMap<>();
		fillHashMap();
	}

	private void fillHashMap() {
		hashMap.put("$CurrentUser", new DefaultValueCurrentUser());
		hashMap.put("$CurrentDateTime", new DefaultValueCurrentDateTime());
	}
	
	public String get(String key){
		IDefaultValue defaultValueOfInterface = hashMap.getOrDefault(key, new NullDefaultValue());
		return defaultValueOfInterface.getDefaultValue(key);
	}
}
