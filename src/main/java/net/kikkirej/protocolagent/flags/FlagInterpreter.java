package net.kikkirej.protocolagent.flags;

import java.util.ArrayList;
import java.util.HashMap;

import net.kikkirej.protocolagent.flags.flagactions.*;

public class FlagInterpreter {
	private static final String REGEXFLAG = "[-,/][a-z,A-Z]{1,5}";

	public void interpretArgs(String[] args){
		ArrayList<Flag> allFlags = getAllFlags(args);
		HashMap<String, IFlagAction> flagActions = fillHashMap();
		executeFlagActions(allFlags, flagActions);
	}

	private ArrayList<Flag> getAllFlags(String[] args) {
		ArrayList<Flag> arrayList = new ArrayList<Flag>();
		for (int i = 0; i < args.length; i++) {
			if(args[i].matches(REGEXFLAG)){
				Flag flag = getSpecificOption(args, i);
				arrayList.add(flag);
			}
		}
		return arrayList;
	}

	private Flag getSpecificOption(String[] args, int index) {
		Flag flag = new Flag();
		flag.setFlagname(args[index].substring(1, args[index].length()));
		String flagvalue="";
		for (int j = index+1; j < args.length; j++) {
			if(!args[j].matches(REGEXFLAG)){
				flagvalue += args[j]+ " ";
			}
			else{
				flag.setFlagvalue(flagvalue.substring(0, flagvalue.length()-1));
				return flag;
			}
		}
		flag.setFlagvalue(flagvalue);
		return flag;
	}

	private HashMap<String, IFlagAction> fillHashMap() {
		HashMap<String, IFlagAction> flagActions = new HashMap<>();
		flagActions.put("c", new ConfFlagAction());
		flagActions.put("h", new HelpFlagAction());
		ValueFlagAction valueFlagAction = new ValueFlagAction();
		flagActions.put("v", valueFlagAction);
		flagActions.put("dv", valueFlagAction);
		flagActions.put("k", new CategoryFlagAction());
		flagActions.put("gruen", new GreenyFlagAction());
		return flagActions;
	}

	private void executeFlagActions(ArrayList<Flag> allFlags, HashMap<String, IFlagAction> flagActions) {
		for(Flag f: allFlags){
			IFlagAction flagAction = flagActions.getOrDefault(f.getFlagname(),new NullFlagAction());
			flagAction.execute(f);
		}
	}
}
