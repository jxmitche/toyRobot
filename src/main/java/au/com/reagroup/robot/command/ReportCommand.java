package au.com.reagroup.robot.command;

import au.com.reagroup.robot.model.ToyRobot;

public class ReportCommand extends AbstractCommand {
	
	public ReportCommand(final ToyRobot robot) {
		super(robot);
	}

	@Override
	public void execute() {
		robot.report();
	}
}
