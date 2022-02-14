package com.salesForce.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = {"src/test/resources/SalesForce.feature"},
					glue= {"com.salesForce.steps"})

public class TestRunnerA extends AbstractTestNGCucumberTests{

}