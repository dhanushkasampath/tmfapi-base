package com.adl.et.telco.tmf.commonconfig.application.filter;

import java.util.Iterator;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class ResponseFieldsFilter {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(ResponseFieldsFilter.class.getName());
    public JSONObject jsonConverter(Object object){
        JSONObject response = new JSONObject();
        try {
            Gson gson = new GsonBuilder().create();
            String json = gson.toJson(object);
            JSONParser parser = new JSONParser();
            response = (JSONObject) parser.parse(json);
        }catch (Exception ex){
            logger.error("Error in json conversion:{} ", ExceptionUtils.getStackTrace(ex));
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
            logger.error("Error in filtering:{}", ExceptionUtils.getStackTrace(ex));
        }
        return duplicateJSONObject;
    }
}
