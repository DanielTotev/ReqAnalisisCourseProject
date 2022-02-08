package org.pu.fmi.requirement.engineering.manager;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(monochrome = true, features = "classpath:create-reservation.feature",  plugin = {"pretty","html:target/create-reservation-feature.html"})
public class MovieProjectionManagerTest {

}