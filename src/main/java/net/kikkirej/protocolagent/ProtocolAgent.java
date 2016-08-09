package net.kikkirej.protocolagent;

import net.kikkirej.protocolagent.flags.FlagInterpreter;
import net.kikkirej.protocolagent.options.screen.OptionsScreen;
import net.kikkirej.protocolagent.properties.PropertyKeys;
import net.kikkirej.protocolagent.properties.PropertyManager;

public class ProtocolAgent {

	/**
	 * Main-Method, here starts everything.
	 * @param args User-Arguments.(Supported Arguments are in the wiki on Github.)
	 */
	public static void main(String[] args) {
		new ProtocolAgent().run(args);
	}

	private void run(String[] args) {
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
