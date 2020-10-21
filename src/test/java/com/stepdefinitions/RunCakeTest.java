package com.stepdefinitions;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = {"pretty", "html:target/cucumber-report"},
        features = "src/test/resources/",
        glue = "com.stepdefinitions",
        monochrome = false)
public class RunCakeTest {

}