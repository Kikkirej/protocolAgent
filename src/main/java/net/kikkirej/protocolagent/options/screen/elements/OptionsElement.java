package net.kikkirej.protocolagent.options.screen.elements;

import javax.swing.JFrame;
import javax.swing.JLabel;

import net.kikkirej.protocolagent.options.Value;
import net.kikkirej.protocolagent.options.screen.defaultvalues.DefaultValues;
import net.kikkirej.protocolagent.options.suggestions.SuggestionCollection;

public abstract class OptionsElement {

	protected String name;
	protected String defaultValue;
	protected Boolean isNeeded;
	protected JFrame frame;
	protected SuggestionCollection suggestionCollection;

	public OptionsElement(String bezeichner) {
		this.name = bezeichner;
		this.defaultValue="";
		this.isNeeded=false;
	}
	
	public abstract Value generateElement();
	
	public abstract void setValue(String value);
	
	protected JLabel getLabel(String name) {
		JLabel jLabel = new JLabel(name + ":"); 
		if(isNeeded){
			jLabel.setText(name + "*:");
		}
		return jLabel;
	}
	
	public String getName() {
		return name;
	}
	
	public void setDefaultValue(String defaultValue) {
		this.defaultValue = new DefaultValues().get(defaultValue);
	}
	
	public void setNeeded(Boolean isNeeded) {
		this.isNeeded = isNeeded;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

	public void setSuggestionCollection(SuggestionCollection suggestionCollection) {
		this.suggestionCollection = suggestionCollection;
	}
}
