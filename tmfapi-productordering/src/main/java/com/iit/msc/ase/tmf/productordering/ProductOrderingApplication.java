package com.iit.msc.ase.tmf.productordering;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.logging.Logger;

@EnableSwagger2
@ComponentScan(basePackages = {"com.adl.et.telco.tmf.datamodel","com.adl.et.telco.tmf.commonconfig","com.adl.et.telco.tmf.productordering"})
@SpringBootApplication
public class ProductOrderingApplication {
    private static final Logger logger = Logger.getLogger(ProductOrderingApplication.class.getName());

    public static void main(String[] args){
        try{
            setHostAddress();
        } catch (UnknownHostException e){
            logger.severe(e.getMessage());
        }

        SpringApplication.run(ProductOrderingApplication.class, args);
    }

    private static void setHostAddress() throws UnknownHostException {
        InetAddress ip= InetAddress.getLocalHost();
        String hostAddress = ip.getHostAddress();
        System.setProperty("host.address",hostAddress);
    }
}
