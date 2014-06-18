package au.com.reagroup.robot.client;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

import au.com.reagroup.robot.model.Direction;
import au.com.reagroup.robot.reporting.MockReporter;

public class SetupTest {
	private MockReporter reporter;
	private Setup setup;
	
	@Before
	public void setup() {
		reporter = new MockReporter();
		setup = new Setup(reporter);
	}
	
	@Test
	public void checkMove1() {
		setup.processCommandsFromFile(TestFilesLocation.TEST_DIRECTORY + "cmds1.txt");
		
		checkRobotPosition(0, 1, Direction.NORTH);
	}
	
	@Test
	public void checkIgnoreCmdsBeforePlaceAndPlaceTwice() {
		setup.processCommandsFromFile(TestFilesLocation.TEST_DIRECTORY + "cmds4.txt");
		
		checkRobotPosition(2, 4, Direction.WEST);
	}
	
	@Test
	public void checkPlaceAndMoveOffBoardEast() {
		setup.processCommandsFromFile(TestFilesLocation.TEST_DIRECTORY + "cmds5.txt");
		
		checkRobotPosition(0, 1, Direction.WEST);
	}
	
	@Test
	public void checkPlaceAndMoveOffBoardWest() {
		setup.processCommandsFromFile(TestFilesLocation.TEST_DIRECTORY + "cmds6.txt");
		
		checkRobotPosition(4, 2, Direction.EAST);
	}
	
	@Test
	public void checkPlaceAndMoveOffBoardNorth() {
		setup.processCommandsFromFile(TestFilesLocation.TEST_DIRECTORY + "cmds7.txt");
		
		checkRobotPosition(3, 4, Direction.NORTH);
	}
	
	@Test
	public void checkPlaceAndMoveOffBoardSouth() {
		setup.processCommandsFromFile(TestFilesLocation.TEST_DIRECTORY + "cmds8.txt");
		
		checkRobotPosition(3, 0, Direction.SOUTH);
	}
	
	@Test
	public void checkPlaceOffBoard() {
		setup.processCommandsFromFile(TestFilesLocation.TEST_DIRECTORY + "cmds9.txt");
		
		//checkRobotPosition(3, 0, Direction.SOUTH);
		assertNull(reporter.coordinates);
		assertNull(reporter.facing);
	}
	@Test
	public void check_NullReporter() {
		try {
			new Setup(null);
			fail("should not reach here");
		} catch (IllegalArgumentException ex) {
			assertEquals("Reporter must not be null", ex.getMessage());
		}
	}
	
	@Test
	public void check_NullFileName() {
		try {
			setup.processCommandsFromFile(null);
			fail("should not reach here");
		} catch (IllegalArgumentException ex) {
			assertEquals("FileName must not be null", ex.getMessage());
		}
	}
	
	private void checkRobotPosition(final int x, final int y, final Direction direction) {
		assertEquals(x, reporter.coordinates.getX());
		assertEquals(y, reporter.coordinates.getY());
		assertEquals(direction, reporter.facing);
	}
}
