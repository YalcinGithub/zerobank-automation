package com.zerobank.stepdefinitions;

import com.zerobank.utilities.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Hooks {

    @Before
    public void setUp(){

       // System.out.println("\tThis is coming from before");
    }

    @After
    public void tearDown(Scenario scenario){

        if(scenario.isFailed()){
            final byte[] screenshot = ((TakesScreenshot)Driver.get()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot,"image/png", "screenshot");
        }
        Driver.closeDriver();
        //System.out.println("\tthis is coming from after\n");
    }

    @Before("@db")
    public void setUpdb(){
        System.out.println("\tThis is coming from before DB");
    }

    @After("@db")
    public void tearDowndb(){
        System.out.println("\tthis is coming from after DB\n");
    }

}
