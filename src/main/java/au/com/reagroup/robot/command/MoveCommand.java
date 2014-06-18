package au.com.reagroup.robot.command;

import au.com.reagroup.robot.model.ToyRobot;

public class MoveCommand extends AbstractCommand {
	
	public MoveCommand(final ToyRobot robot) {
		super(robot);
	}
	
	@Override
	public void execute() {
		robot.move();
	}
}
