package net.kikkirej.protocolagent.properties;
/**
 * Keys for the possible Properties.
 * @author Kikkirej
 *
 * For a new Property you need to do the following steps:
 * 1. define a new unique Key in this File
 * 2. Add default value to "defaultProperties.ini" if required.
 * 3. Add default value to "propertiesModel.ini" if required.
 * Hint: in at Least one of these files a template should exist
 * 4. Write it down on the Wiki on Github.
 */
public class PropertyKeys {
	/**
	 * Name of the Labels 
	 */
	public static final String CATEGORYLABEL="nameOfCategoryLabel";
	
	public static final String CATEGORYPATH="categoryPath";

	public static final String ALLFIELDSANDARTS="allFieldsAndArts";
	
	public static final String DEFAULTVALUES="defaultValues";
	
	public static final String NEEDEDVALUES ="neededValues";
	
	public static final String SAVEBUTTONTEXT = "saveButton";
	
	public static final String FRAMETITLE = "frameTitle";
	
	public static final String DATEFORMAT = "dateFormat";
	
	public static final String TIMEFORMAT = "timeFormat";
	
	public static final String PATHTOSAVEDLOGS= "pathToSavedLogs";
}
