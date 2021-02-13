/**
 * © Copyrights 2020 Axiata Digital Labs Pvt Ltd.
 * All Rights Reserved.
 * <p>
 * These material are unpublished, proprietary, confidential source
 * code of Axiata Digital Labs Pvt Ltd (ADL) and constitute a TRADE
 * SECRET of ADL.
 * <p>
 * ADL retains all title to and intelectual property rights in these
 * materials.
 */

package com.iit.msc.ase.tmf.customermanagement;

import com.adl.et.telco.dte.plugin.log.annotations.EnableDteLogging;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.DependsOn;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.logging.Logger;

/**
 * <h1>Customer Management Application!</h1>
 * The CustomerManagementApplication implements an application that
 * simply demonstrate all available operations for Customer Management
 * <p>
 * <b>Note:</b> TMF628
 * Release 19.0.0
 * Version 4.0
 *
 * @author Sharada Deshan
 * @version 1.0
 * @since 2020-02-01
 */

@ComponentScan(basePackages = {"com.adl.et.telco.tmf.datamodel.external.util", "com.adl.et.telco.tmf.customermanagement", "com.adl.et.telco.tmf.commonconfig", "com.adl.et.telco.tmf.datamodel"})
@SpringBootApplication
@EnableSwagger2
@EnableDteLogging
@DependsOn({"dteLoggingUtils"})
public class CustomermanagementApplication {
    private static final Logger logger = Logger.getLogger(CustomermanagementApplication.class.getName());

    public static void main(String[] args) {
        try {
            setHostAddress();
        } catch (UnknownHostException ex) {
            logger.severe(ex.getMessage());
        }
        SpringApplication.run(CustomermanagementApplication.class, args);
    }

    private static void setHostAddress() throws UnknownHostException {
        InetAddress ip = InetAddress.getLocalHost();
        String hostAddress = ip.getHostAddress();
        System.setProperty("host.address", hostAddress);
    }


}
