package net.kikkirej.protocolagent.options.suggestions;

import java.util.ArrayList;

public class SuggestionCollection {
	ArrayList<Suggestion> suggestions = new ArrayList<>();
	private Integer count;
	public SuggestionCollection() {
		count = 5;
	}
	
	private void addSuggestion(Suggestion suggestion){
		suggestions.add(suggestion);
	}
	
	private void setCount(Integer count){
		this.count = count;
	}
}
