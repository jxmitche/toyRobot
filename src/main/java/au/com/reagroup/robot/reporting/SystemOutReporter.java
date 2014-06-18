package au.com.reagroup.robot.reporting;

import au.com.reagroup.robot.model.Coordinates;
import au.com.reagroup.robot.model.Direction;

public class SystemOutReporter implements Reporter {

	@Override
	public void report(Coordinates coordinates, Direction facing) {
		System.out.println(coordinates.getX() + "," + coordinates.getY() + "," + facing);
	}

}
