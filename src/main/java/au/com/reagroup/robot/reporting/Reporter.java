package au.com.reagroup.robot.reporting;

import au.com.reagroup.robot.model.Coordinates;
import au.com.reagroup.robot.model.Direction;

public interface Reporter {
	void report(final Coordinates coordinates, final Direction facing);
}
