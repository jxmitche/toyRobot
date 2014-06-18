package au.com.reagroup.robot.client;

import java.util.ArrayList;
import java.util.List;

import au.com.reagroup.robot.command.Command;
import au.com.reagroup.robot.command.CommandCreator;
import au.com.reagroup.robot.command.ListOfCommands;
import au.com.reagroup.robot.input.ReadFile;
import au.com.reagroup.robot.model.Tabletop;
import au.com.reagroup.robot.model.ToyRobot;
import au.com.reagroup.robot.reporting.Reporter;
import au.com.reagroup.robot.validation.NullParamValidator;

public class Setup {
	private ToyRobot robot;
	private NullParamValidator nullValidator = new NullParamValidator();
	
	public Setup(final Reporter reporter) {
		nullValidator.checkNotNull(reporter, "Reporter");
		
		final Tabletop tabletop = new Tabletop(5,5);
		this.robot = new ToyRobot(tabletop, reporter);
	}
	
	public void processCommandsFromFile(final String fileName) {
		nullValidator.checkNotNull(fileName, "FileName");
		
		final List<Command> commands = new ArrayList<Command>();
		final ListOfCommands listOfCommands = new ListOfCommands(commands);
		final CommandCreator commandCreator = new CommandCreator(robot);
		
		final ReadFile readFile = new ReadFile(fileName);
		final List<String> lines = readFile.readFile();
		
		for (String commandLine :lines) {
			final Command command = commandCreator.createCommand(commandLine);
			commands.add(command);
		}
		
		listOfCommands.execute();
	}
}
