package au.com.reagroup.robot.reporting;

import au.com.reagroup.robot.model.Coordinates;
import au.com.reagroup.robot.model.Direction;

public class MockReporter implements Reporter {
	public Coordinates coordinates;
	public Direction facing;
	
	@Override
	public void report(Coordinates coordinates, Direction facing) {
		this.coordinates = coordinates;
		this.facing = facing;
	}
}
