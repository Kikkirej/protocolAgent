package net.kikkirej.protocolagent.properties;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URI;
import java.net.URL;
import java.util.Properties;

import org.apache.commons.io.FileUtils;

public class PropertyFile extends File {

	private static final long serialVersionUID = 7832464646040414984L;

	public PropertyFile(String arg0) {
		super(arg0);
	}

	public PropertyFile(URI arg0) {
		super(arg0);
	}

	public PropertyFile(String arg0, String arg1) {
		super(arg0, arg1);
	}

	public PropertyFile(File arg0, String arg1) {
		super(arg0, arg1);
	}
	
	@Deprecated
	public static PropertyFile initFile() throws IOException{
		return initFile("properties.ini");
	}
	
	public static PropertyFile initFile(String pathToFile) throws IOException{
		URL resource = PropertyFile.class.getResource("/net/kikkirej/protocolagent/properties/propertiesModel.ini");
		String filePath = resource.getFile();
		PropertyFile propertyTemplateFile = new PropertyFile(filePath);
		PropertyFile propertyFile = new PropertyFile(pathToFile);
		FileUtils.copyFile(propertyTemplateFile, propertyFile);
		return propertyFile;
	}
	
	@Deprecated
	public Properties loadProperties() throws IOException{
		Properties properties = new Properties();
		return loadProperties(properties);
	}
	
	public Properties loadProperties(Properties oldProperties) throws IOException{
		Properties newProperties = new Properties();
		FileReader fileReader = new FileReader(this);
		newProperties.load(fileReader);
		Properties mergedProperties = new Properties();
		mergedProperties.putAll(oldProperties);
		mergedProperties.putAll(newProperties);		
		return mergedProperties;
	}
}
