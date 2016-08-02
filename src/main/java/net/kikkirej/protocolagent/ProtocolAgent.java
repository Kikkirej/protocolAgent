package net.kikkirej.protocolagent;

import net.kikkirej.protocolagent.flags.FlagInterpreter;
import net.kikkirej.protocolagent.options.screen.OptionsScreen;
import net.kikkirej.protocolagent.properties.PropertyManager;

public class ProtocolAgent {

	/**
	 * Main-Method, here starts everything.
	 * <b>Flags</b>
	 * -c [Path]	Settings
	 * -h			Help
	 * @param args User-Arguments.(Supported Argument is the Path to the *.ini.)
	 */
	public static void main(String[] args) {
		if(args.length > 0){
			FlagInterpreter flagInterpreter = new FlagInterpreter();
			flagInterpreter.interpretArgs(args);
		}else{
			new OptionsScreen();
		}
	}

	private void initalize(String[] args) {
		if(args[0].equals("-c")){
			PropertyManager propertyManager = PropertyManager.getInstance();
			propertyManager.setPropertyPath(args[1]);
		} else if(args[0].equals("-h")){
			//TODO implement help Dialog...
		}
	}
	
}
