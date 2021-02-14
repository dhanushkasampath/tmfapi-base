package com.iit.msc.ase.tmf.customermanagement;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.logging.Logger;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * <h1>Customer Management Application!</h1>
 * The CustomerManagementApplication implements an application that
 * simply demonstrate all available operations for Customer Management
 * <p>
 * <b>Note:</b> TMF628
 * Release 19.0.0
 * Version 4.0
 *
 * @author Dhanushka Sampath
 * @version 1.0
 * @since 2021-02-14
 */

@ComponentScan(basePackages = {"com.iit.msc.ase.tmf.customermanagement", "com.iit.msc.ase.tmf.commonconfig", "com.iit.msc.ase.tmf.datamodel"})
@SpringBootApplication
@EnableSwagger2
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
