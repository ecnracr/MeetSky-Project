package com.meetsky.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {
                "json:target/cucumber.json",
                "html:target/cucumber/report.html",
                "junit:target/junit/junit-report.xml",
                "rerun:target/rerun.txt",
        },
        features = "src/test/resources/features",
        glue = "com/meetsky/step_definitions",
        tags = "@MTSK-426",
        dryRun = true,
        publish = false

)

public class CukesRunner {
}