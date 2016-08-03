package net.kikkirej.protocolagent;

import net.kikkirej.protocolagent.flags.FlagInterpreter;
import net.kikkirej.protocolagent.options.screen.OptionsScreen;
import net.kikkirej.protocolagent.properties.PropertyKeys;
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
		}
		if(PropertyManager.getInstance().get(PropertyKeys.BACKGROUNDMODE).equals("true")){
			//TODO Backgroundmode implementieren.
		}else{
			new OptionsScreen();
		}
	}
}
