package Login;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;



public class Log4j2 {
	
	private static final Logger logger =  LogManager.getLogger(Log4j2.class);

	public static void main(String[] args) {

			//different logging levels
			 logger.fatal("Hello fatal");
			 logger.error("Hello error");
			 logger.warn("Hello warn");
			 logger.info("Hello info");
			 logger.debug("Hello debug");
			 logger.trace("Hellotrace ");
			
		}

}
