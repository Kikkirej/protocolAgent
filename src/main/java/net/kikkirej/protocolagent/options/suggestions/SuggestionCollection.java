package net.kikkirej.protocolagent.options.suggestions;

import java.util.ArrayList;

public class SuggestionCollection {
	private ArrayList<Suggestion> suggestions = new ArrayList<>();
	private Integer count;
	private String feldName;
	public String getFeldName() {
		return feldName;
	}

	public SuggestionCollection(String feldName) {
		this.feldName = feldName;
		count = 5;
	}
	
	public void addSuggestion(Suggestion suggestion){
		suggestions.add(suggestion);
	}
	
	public void setCount(Integer count){
		this.count = count;
	}
}
