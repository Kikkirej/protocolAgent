package net.kikkirej.protocolagent.options;

public class Value {
	private String fieldName;
	private String value;
	
	public Value(String value, String fieldName){
		this.value = value;
		this.fieldName = fieldName;
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
	
}
