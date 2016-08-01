package net.kikkirej.protocolagent.options.screen.defaultvalues;

import java.util.HashMap;

import net.kikkirej.protocolagent.options.screen.defaultvalues.specificdefaultvalues.DVCurrentDate;
import net.kikkirej.protocolagent.options.screen.defaultvalues.specificdefaultvalues.DVCurrentDateTime;
import net.kikkirej.protocolagent.options.screen.defaultvalues.specificdefaultvalues.DVCurrentLanguage;
import net.kikkirej.protocolagent.options.screen.defaultvalues.specificdefaultvalues.DVCurrentTime;
import net.kikkirej.protocolagent.options.screen.defaultvalues.specificdefaultvalues.DVCurrentUser;

public class DefaultValues {
	private HashMap<String, IDefaultValue> hashMap;

	public DefaultValues() {
		hashMap = new HashMap<>();
		fillHashMap();
	}

	private void fillHashMap() {
		hashMap.put("$CurrentUser", new DVCurrentUser());
		hashMap.put("$CurrentDateTime", new DVCurrentDateTime());
		hashMap.put("$CurrentDate", new DVCurrentDate());
		hashMap.put("$CurrentTime", new DVCurrentTime());
		hashMap.put("$CurrentLanguage", new DVCurrentLanguage());
	}
	
	public String get(String key){
		IDefaultValue defaultValueOfInterface = hashMap.getOrDefault(key, new NullDefaultValue());
		return defaultValueOfInterface.getDefaultValue(key);
	}
}
