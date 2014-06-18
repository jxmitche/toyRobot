package au.com.reagroup.robot.client;

import au.com.reagroup.robot.reporting.Reporter;
import au.com.reagroup.robot.reporting.SystemOutReporter;
import au.com.reagroup.robot.validation.NullParamValidator;

public class ReadMeRunMe {
	private static NullParamValidator nullValidator = new NullParamValidator();
	
	public static void main(String[] args) {
		nullValidator.checkNotNull(args, "args");
		final Reporter reporter = new SystemOutReporter();
		final Setup setup = new Setup(reporter);
		
		//take file name as first param
		final String fileName = args[0];
		setup.processCommandsFromFile(fileName);
	}
}
