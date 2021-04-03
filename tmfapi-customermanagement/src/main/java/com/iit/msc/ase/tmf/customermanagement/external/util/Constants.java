package com.iit.msc.ase.tmf.customermanagement.external.util;

/**
 * This Constants class is used to keep constants of the application
 *
 * @author Dhanushka Sampath
 * @version 1.0
 * @since 2021.02.22
 */
public class Constants {

    private Constants() {
        //This class facilitate constants
    }

    public static final String OPERATION_SUCCESSFUL = "Operation Successful";
    public static final String CUSTOMER_ID_IDENTIFIER = "<id>";
    public static final String CUSTOMER_SORT_FIELD = "validFor.startDateTime";

    public static final String CXM1000 = "CXM1000";//Success

    public static final String CXM2000 = "CXM2000";//no customer record found by id
    public static final String CXM2001 = "CXM2001";//Invalid offset:{}
    public static final String CXM2002 = "CXM2002";//Invalid limit:{}
    public static final String CXM2003 = "CXM2003";//Customer not found for id:{}

    public static final String OFFSET_KEY = "offset";
    public static final String LIMIT_KEY = "limit";
    public static final String FIELDS_KEY = "fields";

}
