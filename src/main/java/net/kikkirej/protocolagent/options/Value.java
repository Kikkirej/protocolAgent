package net.kikkirej.protocolagent.options;

public class Value {
	private String fieldName;
	private String value;
	private Boolean neededValue;
	
	public Value(String value, String fieldName){
		this.value = value;
		this.fieldName = fieldName;
		this.setNeededValue(false);
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getFieldName() {
		return fieldName;
	}

	public Boolean isNeededValue() {
		return neededValue;
	}

	public void setNeededValue(Boolean neededValue) {
		this.neededValue = neededValue;
	}
	
}
