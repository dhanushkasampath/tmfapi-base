package com.adl.et.telco.tmf.commonconfig.external.util;

import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

@Component
public class IdGenerator {

    public String generate() {
        LocalDateTime myDateObj = LocalDateTime.now();
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");

        String formattedDate = myDateObj.format(myFormatObj);
        return (new Random().nextInt((999999 - 100000) + 1) + 100000) + formattedDate;
    }

    public String generateBigInt() {
        LocalDateTime myDateObj = LocalDateTime.now();
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");

        String formattedDate = myDateObj.format(myFormatObj);

        return (new Random().nextInt((9999 - 1000) + 1) + 1000) + formattedDate;
    }
}