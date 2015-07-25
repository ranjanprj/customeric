/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.com.bc.wicket.utils;

import org.apache.log4j.AsyncAppender;
import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.Logger;

public class AsyncLogging {

  private static Logger logger = Logger.getLogger("name");

  private AsyncAppender asyncAppender = null;

  private ConsoleAppender consoleAppender = null;

  /** Creates a new instance of AsyncLogging */
  public AsyncLogging() {
    try {
      logger.setAdditivity(true);
      asyncAppender = (AsyncAppender) logger.getRootLogger().getAppender(
          "ASYNC");
      asyncAppender.setBufferSize(4);
      
    } catch (Exception e) {
      System.out.println("error: " + e.toString());
    }

  }

  /**
   * This method simply logs the messages
   */
  public void doLogging() {
      System.out.println("===");
//    logger.info("hello info");
    logger.error("Hello 1");
    logger.debug("Hello 2");
    logger.debug("Hello 3");
    
    //logger.debug("Hello 4");
    //logger.debug("Hello 5");
  }

  /**
   * the main method
   */
  public static void main(String args[]) {
//    AsyncLogging demo = new AsyncLogging();
//    demo.doLogging();
//      System.out.println("doing logging");
  }
}
