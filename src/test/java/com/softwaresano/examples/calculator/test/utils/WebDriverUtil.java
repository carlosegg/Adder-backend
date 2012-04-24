package com.softwaresano.examples.calculator.test.utils;

import java.net.URL;
import java.util.Arrays;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.Augmenter;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class WebDriverUtil {
	final private static String DEFAULT_SERVER_PORT="80";
	/** Class logger */
	protected Log logger = LogFactory.getLog(this.getClass());

	/** WebDriver instance */
	protected static WebDriver driver = null;

	/**
	 * Returns the WebDriver instance corresponding to the browser
	 * 
	 * @return the WebDriver object
	 * @throws Exception
	 */
	public static WebDriver getWebDriver() throws Exception {
		if (driver != null) {
			return driver;
		}
		WebDriver driver = null;
		String serverHost = System.getProperty("selenium.host");
		String serverPort = System.getProperty("selenium.port");
		
		if (serverHost != null) {
			if ((serverPort==null) || serverPort.isEmpty()){
				serverPort=DEFAULT_SERVER_PORT;
			}
			driver = getRemoteWebDriver(serverHost, serverPort,new Browser(System.getProperty("selenium.browser.name"),System.getProperty("selenium.browser.version"),System.getProperty("selenium.browser.platform")));
		} else {
			//The example only works in Firefox
			driver = new FirefoxDriver();
			
		}
		return driver;
	}

	/**
	 * Returns the remote WebDriver instance corresponding to the browser
	 * 
	 * @param serverPort
	 * @param serverHost
	 * @return the WebDriver object
	 * @throws Exception
	 */
	private static WebDriver getRemoteWebDriver(String serverHost,
		String serverPort, Browser browser) throws Exception {
		DesiredCapabilities capabilities = null;
		String browserName=browser.getName();
		if (browserName.equals("firefox")) {
			capabilities = DesiredCapabilities.firefox();
		} else if (browserName.equals("iexplore")) {
			capabilities = DesiredCapabilities.internetExplorer();
			// Selenium Grid uses 'internet explorer' instead of 'iexplore'
			browserName = "internet explorer";
		} else if (browserName.equals("chrome")) {
			capabilities = DesiredCapabilities.chrome();
			capabilities.setCapability("chrome.switches",
					Arrays.asList("--start-maximized"));
		} else {
			String errorMessage = "There are no remote drivers for the browser '"
					+ browserName + "'";
			throw new Exception(errorMessage);
		}
		capabilities.setBrowserName(browserName);

		String version = browser.getVersion();
		if (version != null && !version.isEmpty()) {
			capabilities.setVersion(version);

		}
		String platform = browser.getPlatform();
		if (platform != null && !platform.isEmpty()) {
			capabilities.setPlatform(Platform.extractFromSysProperty(platform));
		}
		

		String urlServerString = "http://" + serverHost + ":" + serverPort
				+ "/wd/hub";
		URL urlServer = new URL(urlServerString);

		WebDriver remoteWebDriver = new RemoteWebDriver(urlServer, capabilities);
		WebDriver augmentedDriver = new Augmenter().augment(remoteWebDriver);
		return augmentedDriver;
	}

}
