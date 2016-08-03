package net.kikkirej.protocolagent.properties;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URL;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;

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
		InputStream resourceAsStream = PropertyFile.class.getResourceAsStream("/net/kikkirej/protocolagent/properties/propertiesModel.ini");
		final File tempFile = File.createTempFile("protcolAgentModel", ".ini");
        tempFile.deleteOnExit();
        try (FileOutputStream out = new FileOutputStream(tempFile)) {
            IOUtils.copy(resourceAsStream, out);
        }
		PropertyFile propertyTemplateFile = new PropertyFile(tempFile.getAbsolutePath());
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
