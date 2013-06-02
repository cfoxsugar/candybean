/*
 * Basic.java --
 *
 *      The class in this file demonstrates the most basic of Voodoo
 *      functionality.
 */

package com.sugarcrm.voodoo.examples;

import com.sugarcrm.voodoo.automation.VInterface;
import com.sugarcrm.voodoo.automation.Voodoo;
import com.sugarcrm.voodoo.configuration.Configuration;

/**
 * Basic example class.
 *
 * <p>The Basic class demonstrates the most basic usage of VDD.  It
 * uses a Voodoo object to get the Selenium interface object.  With
 * that, it simply starts and then stops a WebDriver session.</p>
 *
 * @author Jon duSaint
 */

public class Basic {

	/**
	 * Log a message
	 *
	 * @param m  the message
	 */

	protected void log(String m) {
		System.out.println(m);
	}

	/**
	 * Log a Voodoo exception.
	 *
	 * <p>Every method in the Voodoo class and IInterface throws {@link
	 * Exception}.  Rather than boilerplate logging a message and the
	 * stack trace, this method combines those two functions, saving a
	 * small amount of code.</p>
	 *
	 * @param e  the exception from Voodoo
	 * @param m  a message to log with that exception
	 */

	protected void ve(Throwable e, String m) {
		System.err.println("Exception caught " + m + ":");
		e.printStackTrace(System.err);
	}

	/**
	 * Run the basic example code.
	 */

	@Example
	public void runExample()  {
		Configuration c;
		Voodoo v = null;
		VInterface i = null;

		log("*** Example of basic VDD2 usage ***");

		c = new Configuration();
		/*
		 * This path should be replaced by the correct path to the
		 * properties file.
		 *
		 * XXX: There needs to be a Voodoo-provided runtime method of
		 * getting the path to this.  Hard-coded paths are fragile
		 * and almost certainly wrong.
		 */
		c.load("/home/jon/w/VDD2/Voodoo2/src/test/resources/voodoo.properties");

		try {
			v = Voodoo.getInstance(c);
		} catch (Exception e) {
			ve(e, "during Voodoo instantiation");
			return;
		}

		try {
			i = v.getInterface();
		} catch (Exception e) {
			ve(e, "getting Voodoo interface");
			return;
		}

		log("Starting WebDriver");
		try {
			i.start();
		} catch (Exception e) {
			ve(e, "starting WebDriver");
			return;
		}

		log("Stopping WebDriver");
		try {
			i.stop();
		} catch (Exception e) {
			ve(e, "stopping WebDriver");
			return;
		}

		log("Done");
	}
}