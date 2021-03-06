package io.mycat.mcache.command;

import java.util.HashMap;
import java.util.Map;


/**
 * 命令上下文
 * @author lyj
 *
 */
public class CommandContext {
	
	private static Map<CommandType,Command> commandMap = new HashMap<>();
	
	static {
		commandMap.put(CommandType.set, new SetCommand());
	}
	
	private CommandContext(){}
	
	public static Command getCommand(Byte key){
		CommandType type = CommandType.getType(key);
		if(type==null){
			return null;
		}
		return commandMap.get(type);
	}
	
	public static Command getCommand(String key){
		CommandType type = CommandType.valueOf(key);
		if(type==null){
			return null;
		}
		return commandMap.get(type);
	}
}
