package com.techx.core.hooks;

import com.techx.core.context.TestContext;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.apache.log4j.Logger;

public class Hooks{

    private TestContext context;
    static final Logger LOGGER = Logger.getLogger(Hooks.class);

    public Hooks(TestContext context){
        this.context = context;
    }

    @Before
    public void setUp(Scenario scenario){
        context.setVar("scenario", scenario);
        System.out.println("Before done");

    }

    @After
    public void cleanUp(Scenario scenario){
        if(this.context.driver() != null){
            this.context.cleanUp();
        }
        System.out.println("After done");
    }
}
