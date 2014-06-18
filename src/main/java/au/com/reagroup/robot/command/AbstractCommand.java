package au.com.reagroup.robot.command;

import au.com.reagroup.robot.model.ToyRobot;
import au.com.reagroup.robot.validation.NullParamValidator;

public abstract class AbstractCommand implements Command {
	protected ToyRobot robot;
	protected NullParamValidator nullValidator = new NullParamValidator();
	
	public AbstractCommand(final ToyRobot robot) {
		nullValidator.checkNotNull(robot, "Robot");
		
		this.robot = robot;
	}
	
	abstract public void execute();

}
