package au.com.reagroup.robot.command;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

import au.com.reagroup.robot.model.Coordinates;
import au.com.reagroup.robot.model.Direction;
import au.com.reagroup.robot.model.DirectionToTurn;
import au.com.reagroup.robot.model.Tabletop;
import au.com.reagroup.robot.model.ToyRobot;
import au.com.reagroup.robot.reporting.MockReporter;

public class TurnCommandTest {
	private Command turnCommand;
	private ToyRobot robot;
	private Tabletop tabletop;
	private MockReporter reporter;
	private Coordinates currentPosition;
	private Direction facing;
	
	@Before
	public void setup() {
		tabletop = new Tabletop(5,5);
		reporter = new MockReporter();
		robot = new ToyRobot(tabletop, reporter);
		currentPosition = new Coordinates(1,2);
		facing = Direction.EAST;
		robot.place(currentPosition, facing);
		turnCommand = new TurnCommand(robot, DirectionToTurn.LEFT);
	}
	
	@Test
	public void check_turn() {
		turnCommand.execute();
		
		robot.report();
		
		assertEquals(1, reporter.coordinates.getX());
		assertEquals(2, reporter.coordinates.getY());
		assertEquals(Direction.NORTH, reporter.facing);
	}
	
	@Test
	public void check_NullRobot() {
		try {
			new TurnCommand(null, DirectionToTurn.LEFT);
			fail("should not reach here");
		} catch (IllegalArgumentException ex) {
			assertEquals("Robot must not be null", ex.getMessage());
		}
	}
	
	@Test
	public void check_NullCoordinates() {
		try {
			new TurnCommand(robot, null);
			fail("should not reach here");
		} catch (IllegalArgumentException ex) {
			assertEquals("DirectionToTurn must not be null", ex.getMessage());
		}
	}
}
