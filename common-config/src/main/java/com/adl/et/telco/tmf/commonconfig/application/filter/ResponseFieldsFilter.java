package com.adl.et.telco.tmf.commonconfig.application.filter;

import ch.qos.logback.classic.Logger;
import com.adl.et.telco.dte.plugin.log.annotations.EnableDteLogging;
import com.adl.et.telco.dte.plugin.log.services.LoggingUtils;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;

import java.util.Iterator;
import java.util.List;

@EnableDteLogging
@DependsOn({"dteLoggingUtils"})
@Component
public class ResponseFieldsFilter {
    private static Logger logger = LoggingUtils.getLogger(ResponseFieldsFilter.class.getName());
    public JSONObject jsonConverter(Object object){
        JSONObject response = new JSONObject();
        try {
            Gson gson = new GsonBuilder().create();
            String json = gson.toJson(object);
            JSONParser parser = new JSONParser();
            response = (JSONObject) parser.parse(json);
        }catch (Exception ex){
            logger.error("Error in json conversion "+ ExceptionUtils.getStackTrace(ex));
        }
        return response;

    }
    public JSONObject filterFields(Object object,List<String> fields){
        JSONObject jsonObject = jsonConverter(object);
        JSONObject duplicateJSONObject = jsonConverter(object);
        try {
            Iterator<String> iterator = jsonObject.keySet().iterator();
            while (iterator.hasNext()) {
                String key = iterator.next();
                if (!fields.contains(key)) {
                    duplicateJSONObject.remove(key);
                }
            }
        }catch (Exception ex){
            logger.error("Error in filtering "+ ExceptionUtils.getStackTrace(ex));
        }
        return duplicateJSONObject;
    }
}
