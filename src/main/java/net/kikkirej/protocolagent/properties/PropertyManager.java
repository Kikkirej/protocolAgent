package net.kikkirej.protocolagent.properties;

import java.util.Properties;

/**
 * Verwaltet alle Einstellungen der Anwendung.
 * @author Kikkirej
 *
 */
public final class PropertyManager {
	private static PropertyManager instance;
	/**
	 * Java-Properties-Object, which contains Logic.
	 */
	private Properties properties;
	/**
	 * Defines whether the Properties has been loaded initally.
	 */
	private Boolean propertiesLoaded;
	/**
	 * Pfad zur aktuell definierten Properties-Datei im File-System.
	 */
	private String pathToProperties;
	/**
	 * Constructor, 
	 * generates new PropertiesObject
	 * initalizes boolean
	 * defines default properties-File (protocolagent.ini)
	 */
	private PropertyManager() {
		properties = new Properties();
		propertiesLoaded = false;
	}
	
	/**
	 * Returns the only possible instance of {@link PropertyManager}
	 * @return instance of {@link PropertyManager}
	 */
	public static synchronized PropertyManager getInstance(){
		if(instance==null){
			instance = new PropertyManager();
		}
		return instance;
	}
	/**
	 * Supported Keys are in {@link PropertyKeys}.
	 * @param propertyKey a Key to define the property
	 */
	public String getProperty(String propertyKey){
		checkLoadStatusAndLoadProperties();
		String readPropertiesForKey;
		try {
			readPropertiesForKey = readPropertiesForKey(propertyKey);
			return readPropertiesForKey;
		} catch (PropertiesNotFoundOrCorruptException e) {
			System.exit(1);
		}
		return "";
	}

	private String readPropertiesForKey(String propertyKey) throws PropertiesNotFoundOrCorruptException {
		String property = properties.getProperty(propertyKey);
		if(property == null){
			throw new PropertiesNotFoundOrCorruptException();
		}
		else{
			return property;
		}
	}

	private void checkLoadStatusAndLoadProperties() {
		if(!propertiesLoaded){
			loadProperties();
		}
	}

	private void loadProperties() {
		// TODO Hier sollen die Properties geladen werden.
		
	}
}
