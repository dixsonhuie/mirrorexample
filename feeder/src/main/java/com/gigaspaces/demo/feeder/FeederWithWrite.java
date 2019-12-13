package com.gigaspaces.demo.feeder;

import com.gigaspaces.client.WriteModifiers;
import com.gigaspaces.demo.common.*;
import org.openspaces.core.GigaSpace;
import org.openspaces.core.GigaSpaceConfigurer;
import org.openspaces.core.space.SpaceProxyConfigurer;


import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.logging.Logger;
import java.util.Random;

public class FeederWithWrite {

    private static Logger logger = Logger.getLogger(FeederWithWrite.class.getName());

    public static final String XAP_LOOKUP_GROUPS = "XAP_LOOKUP_GROUPS";
    public static final String XAP_LOOKUP_LOCATORS = "XAP_LOOKUP_LOCATORS";

    private static final String spaceName = "mySpace";

    private GigaSpace gigaSpace;

    static {
        // read from environment variable
        System.setProperty("com.gs.jini_lus.locators", System.getenv(XAP_LOOKUP_LOCATORS));
        System.setProperty("com.gs.jini_lus.groups", System.getenv(XAP_LOOKUP_GROUPS));
    }


    public void feeder() {
        for( int i=0; i < 10000; i++ ) {
            Person data = new Person();
            Random rand = new Random();
            int age =  rand.nextInt(44) + 21;
            data.setAge(age);
            data.setFirstName("A" + String.valueOf(age));
            data.setLastName("Smith");
            data.setId(i);
            gigaSpace.write(data);
        }
    }


    private void initialize() {
        SpaceProxyConfigurer spaceProxyConfigurer = new SpaceProxyConfigurer(spaceName);
        gigaSpace = new GigaSpaceConfigurer(spaceProxyConfigurer).gigaSpace();
    }

    public static void main(String[] args) {
        try {

            FeederWithWrite feeder = new FeederWithWrite();
            feeder.initialize();
            feeder.feeder();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}