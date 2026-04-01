package logging_system;

public class Client {

    public static void main(String[] args) {
        // Create a logger
        Logger logger = Logger.getInstance();

        // Log messages
        logger.info("Info logger");
        logger.error("Error logger");
        logger.debug("Debug logger");
    }
}
