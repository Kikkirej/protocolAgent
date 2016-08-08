package net.kikkirej.protocolagent.options.screen;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

import net.kikkirej.protocolagent.options.Value;
import net.kikkirej.protocolagent.options.screen.elements.DateTimeOptionsElement;
import net.kikkirej.protocolagent.options.screen.elements.OptionsElement;
import net.kikkirej.protocolagent.options.screen.elements.TextAreaOptionsElement;
import net.kikkirej.protocolagent.options.screen.elements.TextOptionsElement;
import net.kikkirej.protocolagent.options.screen.listener.CategoryChangedListener;
import net.kikkirej.protocolagent.options.screen.listener.SaveEvent;
import net.kikkirej.protocolagent.properties.PropertyKeys;
import net.kikkirej.protocolagent.properties.PropertyManager;

public class FormBuilder {

	private PropertyManager propertyManager;
	private JFrame frame;

	public FormBuilder(JFrame frame) {
		this.frame = frame;
		
	}
	/**
	 * fills the frame
	 * @return 
	 */
	public Value[] build() {
		OptionsElement[] optionsElements = getOptionsElements();
		Value valueCategoryField = initCategoryField();
		Value[] valuesOfTheOptions = fillOptionsElementsInFrame(optionsElements);
		valuesOfTheOptions[0] = valueCategoryField;
		createFinalButtons(valuesOfTheOptions);
		return valuesOfTheOptions;
	}

	private void createFinalButtons(Value[] values) {
		String saveButtonText = propertyManager.get(PropertyKeys.SAVEBUTTONTEXT);
		JButton saveButton = new JButton(saveButtonText);
		saveButton.setToolTipText("Save");
		saveButton.addActionListener(new SaveEvent(values));
		frame.add(saveButton);
	}

	private Value[] fillOptionsElementsInFrame(OptionsElement[] optionsElements) {
		Value[] values = new Value[optionsElements.length+1];
		
		for (int j = 0; j < optionsElements.length; j++) {
			optionsElements[j].setFrame(this.frame);
			values[j+1] = optionsElements[j].generateElement();
		}
		return values;
	}

	private Value initCategoryField() {
		String categoryLabel = propertyManager.get(PropertyKeys.CATEGORYLABEL);
		JLabel label = new JLabel(categoryLabel + "*:");
		JComboBox<String> comboBox = new JComboBox<>();
		fillComboBox(comboBox);
		Value value = new Value("", categoryLabel);
		value.setNeededValue(true);
		comboBox.addActionListener(new CategoryChangedListener(comboBox, value));
		frame.add(label);
		frame.add(comboBox);
		return value;
	}

	private void fillComboBox(JComboBox<String> comboBox) {
		
		comboBox.addItem("");
		try {
			BufferedReader bufferedReader = readCategoryFile();
	        List<String> lines = new ArrayList<String>();
	        String line = null;
	        while ((line = bufferedReader.readLine()) != null) {
	            lines.add(line);
	        }
	        bufferedReader.close();
	        String[] categoryEntries = lines.toArray(new String[lines.size()]);
	        for (int i = 0; i < categoryEntries.length; i++) {
				comboBox.addItem(categoryEntries[i]);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		setDefaultCategory(comboBox);
	}
	private BufferedReader readCategoryFile() throws IOException, FileNotFoundException {
		String pathToCategories = propertyManager.get(PropertyKeys.CATEGORYPATH);
		File categoryFile = new File(pathToCategories);
		if(!categoryFile.exists()){
			categoryFile.createNewFile();
		}
		FileReader fileReader = new FileReader(categoryFile);
		BufferedReader bufferedReader = new BufferedReader(fileReader);
		return bufferedReader;
	}

	private void setDefaultCategory(JComboBox<String> comboBox) {
		String defaultCategory = propertyManager.get(PropertyKeys.DEFAULTCATEGORY);
		ComboBoxModel<String> model = comboBox.getModel();
		for (int i = 0; i < model.getSize(); i++) {
			String categoryElement = model.getElementAt(i);
			if(categoryElement.replace(" ", "").equals(defaultCategory.replace(" ", ""))){
				model.setSelectedItem(categoryElement);
			}
		}
	}
	/**
	 * loads the elements
	 * @return
	 */
	private OptionsElement[] getOptionsElements() {
		propertyManager = PropertyManager.getInstance();
		String allFieldsAndArts = propertyManager.get(PropertyKeys.ALLFIELDSANDARTS);
		String defaultFieldValues = propertyManager.get(PropertyKeys.DEFAULTVALUES);
		String neededValues = propertyManager.get(PropertyKeys.NEEDEDVALUES);
		OptionsElement[] generatedInitialOptionsElements = generateInitialOptionsElements(allFieldsAndArts);
		fillDefaultSettings(defaultFieldValues, generatedInitialOptionsElements);
		fillNeededValues(neededValues, generatedInitialOptionsElements);
		return generatedInitialOptionsElements;
	}

	private void fillNeededValues(String neededValues, OptionsElement[] generatedInitialOptionsElements) {
		String[] fieldsWhichAreNeeded = neededValues.split(";");
		for (int i = 0; i < fieldsWhichAreNeeded.length; i++) {
			for (int j = 0; j < generatedInitialOptionsElements.length; j++) {
				if (generatedInitialOptionsElements[j].getName().equals(fieldsWhichAreNeeded[i])) {
					generatedInitialOptionsElements[j].setNeeded(true);
				}
			}
		}
	}

	private void fillDefaultSettings(String defaultFieldValues, OptionsElement[] optionsElements) {
		String[] splittedDefaultValues = defaultFieldValues.split(";");
		for (int i = 0; i < splittedDefaultValues.length; i++) {
			String[] singleField = splittedDefaultValues[i].split(":");
			String value = getCompleteValueAfterColon(singleField);
			setDefaultValueForField(singleField[0], value, optionsElements);
		}
		
	}
	
	private String getCompleteValueAfterColon(String[] singleField){
		String value= "";
		for (int i = 1; i < singleField.length; i++) {
			value += singleField[i] + ":";
		}
		value = value.substring(0, value.length()-1);
		return value;
	}

	private void setDefaultValueForField(String fieldName, String defaultValue, OptionsElement[] optionsElements) {
		for (int i = 0; i < optionsElements.length; i++) {
			OptionsElement optionsElementOutOfList = optionsElements[i];
			if(optionsElementOutOfList.getName().equals(fieldName)){
				optionsElementOutOfList.setDefaultValue(defaultValue);
			}
		}
	}

	private OptionsElement[] generateInitialOptionsElements(String allFieldsAndArts) {
		String[] splitedFields = allFieldsAndArts.split(";");
		OptionsElement[] optionsElements = new OptionsElement[splitedFields.length];
		for (int i = 0; i < splitedFields.length; i++) {
			String[] singleField = splitedFields[i].split(":");
			optionsElements[i] = returnNeededObjectWithName(singleField[0], singleField[1]);
		}
		return optionsElements;
	}

	@Deprecated
	private OptionsElement returnNeededObjectWithName(String typeName, String typeDescriber) {
		typeDescriber=typeDescriber.toLowerCase();
		switch (typeDescriber) {
		case "datetime":
			return new DateTimeOptionsElement(typeName);

		case "textarea":
			return new TextAreaOptionsElement(typeName);
			
		default:
			return new TextOptionsElement(typeName);
		}
	}

}
