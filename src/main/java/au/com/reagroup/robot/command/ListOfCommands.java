package au.com.reagroup.robot.command;

import java.util.List;

import au.com.reagroup.robot.validation.NullParamValidator;

public class ListOfCommands implements Command {
	private NullParamValidator nullValidator = new NullParamValidator();;
	private List<Command> commands;
	
	public ListOfCommands(final List<Command> commands) {
		nullValidator.checkNotNull(commands, "Commands");
		
		this.commands = commands;
	}
	
	@Override
	public void execute() {
		for (Command command : commands) {
			command.execute();
		}
	}
}
