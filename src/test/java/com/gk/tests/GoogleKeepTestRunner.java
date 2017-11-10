package com.gk.tests;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.testng.TestNG;
import org.testng.xml.XmlClass;
import org.testng.xml.XmlSuite;
import org.testng.xml.XmlTest;

public class GoogleKeepTestRunner {

	public static void main(String[] args) {

		// CommandLineOptions options = new CommandLineOptions();
		// JCommander jCommander = new JCommander(options, args);

		XmlSuite suite = new XmlSuite();
		suite.setName("MyTestSuite");
		Map<String, String> parameters = new HashMap<String, String>();
		parameters.put("url", "https://www.google.com/keep");
		parameters.put("browser", "CHROME");
		suite.setParameters(parameters);

		List<XmlClass> classes = new ArrayList<XmlClass>();
		classes.add(new XmlClass("com.gk.tests.GoogleKeepTest"));

		XmlTest test = new XmlTest(suite);
		test.setName("MyTests");
		test.setXmlClasses(classes);

		List<XmlSuite> suites = new ArrayList<XmlSuite>();
		suites.add(suite);

		TestNG testNG = new TestNG();
		testNG.setXmlSuites(suites);
		testNG.run();
	}
}
