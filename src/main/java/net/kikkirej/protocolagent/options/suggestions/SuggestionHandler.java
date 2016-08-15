package net.kikkirej.protocolagent.options.suggestions;

import java.util.ArrayList;

public class SuggestionHandler {
	ArrayList<SuggestionCollection> suggestionCollections = new ArrayList<>();
	
	public SuggestionHandler() {
		// TODO Alle suggestionCollections einlesen
	}
	
	/**
	 * ist fertig
	 * @param fieldName
	 * @return
	 */
	public SuggestionCollection getSuggestioCollection(String fieldName){
		for (int i = 0; i < suggestionCollections.size(); i++) {
			if(suggestionCollections.get(i).getFeldName().equals(fieldName)){
				return suggestionCollections.get(i);
			}
		}
		SuggestionCollection defaultSuggestionCollection = new SuggestionCollection("");
		defaultSuggestionCollection.setCount(0);
		return defaultSuggestionCollection;
	}
}
