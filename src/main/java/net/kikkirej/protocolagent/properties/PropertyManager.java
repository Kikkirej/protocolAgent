package net.kikkirej.protocolagent.properties;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.commons.io.IOUtils;

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
	private String propertiesPath;
	private PropertyFile propertyFile;
	
	/**
	 * Constructor, 
	 * generates new PropertiesObject
	 * initalizes boolean
	 * defines default properties-File (protocolagent.ini)
	 */
	private PropertyManager() {
		properties = new Properties();
		propertiesLoaded = false;
		propertiesPath = "properties.ini";
		propertyFile = new PropertyFile(propertiesPath);
		loadDefaultProperties();
	}
	
	private void loadDefaultProperties() {
		try {
			InputStream resourceAsStream = PropertyManager.class.getResourceAsStream("/net/kikkirej/protocolagent/properties/defaultProperties.ini");
			final File tempFile = File.createTempFile("protocolAgentDefault", ".ini");
	        tempFile.deleteOnExit();
	        try (FileOutputStream out = new FileOutputStream(tempFile)) {
	            IOUtils.copy(resourceAsStream, out);
	        }
			properties = new PropertyFile(tempFile.getAbsolutePath()).loadProperties(properties);
		} catch (IOException e) {
			e.printStackTrace();
		}
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
	
	public String get(String key){
		loadPropertiesIfNotLoaded();
		return properties.getProperty(key, "");
	}
	
	public void set(String key, String value){
		loadPropertiesIfNotLoaded();
		properties.setProperty(key, value);
	}
	
	private void loadPropertiesIfNotLoaded() {
		if(!propertiesLoaded){
			try {
				properties = propertyFile.loadProperties(properties);
				propertiesLoaded = true;
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void setPropertyPath(String propertiesPath){
		this.propertiesPath = propertiesPath;
		this.propertyFile = new PropertyFile(this.propertiesPath);
		try {
			properties = propertyFile.loadProperties(properties);
			propertiesLoaded= true;
		} catch (IOException e) {
			try {
				this.propertyFile = PropertyFile.initFile(propertiesPath);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
	
}
