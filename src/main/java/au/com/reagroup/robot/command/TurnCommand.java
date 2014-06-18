package au.com.reagroup.robot.command;

import au.com.reagroup.robot.model.DirectionToTurn;
import au.com.reagroup.robot.model.ToyRobot;

public class TurnCommand extends AbstractCommand {
	private DirectionToTurn directionToTurn;
	
	public TurnCommand(final ToyRobot robot, final DirectionToTurn directionToTurn) {
		super(robot);
		
		nullValidator.checkNotNull(directionToTurn, "DirectionToTurn");
		
		this.directionToTurn = directionToTurn;
	}

	@Override
	public void execute() {
		robot.turn(directionToTurn);
	}
}
