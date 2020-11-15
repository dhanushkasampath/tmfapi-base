package com.adl.et.telco.tmf.commonconfig.external.util;

import ch.qos.logback.classic.Logger;
import com.adl.et.telco.dte.plugin.log.services.LoggingUtils;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JSONConverter {
    private static Logger logger = LoggingUtils.getLogger(JSONConverter.class.getName());

    public JSONObject convertToJSON(Object object) {
        try {
            Gson gson = new GsonBuilder().serializeNulls().create();
            String json = gson.toJson(object);
            return new JSONObject(json);

        } catch (Exception ex) {
            logger.error("Error in json conversion " + ExceptionUtils.getStackTrace(ex));
        }
        return null;
    }

    public JSONArray convertToJSONArray(List<Object> object) {
        try {
            Gson gson = new GsonBuilder().create();
            String json = gson.toJson(object);
            return new JSONArray(json);

        } catch (Exception ex) {
            logger.error("Error in json conversion " + ExceptionUtils.getStackTrace(ex));
        }
        return null;
    }

    public Object convertToObject(JSONObject jsonObject, String className) {
        try {
            Gson gson = new GsonBuilder().create();
            return gson.fromJson(jsonObject.toString(), Class.forName("com.adl.et.telco.tmf.datamodel.domain.dto." + className));

        } catch (Exception ex) {
            logger.error("Error in json conversion " + ExceptionUtils.getStackTrace(ex));
        }
        return null;
    }

    public List convertToObjectList(JSONArray jsonArray, String className) {
        try {
            Gson gson = new GsonBuilder().create();
            List objectList = new ArrayList<>();
            for (int i = 0; i < jsonArray.length(); i++) {
                objectList.add(gson.fromJson(jsonArray.get(i).toString(), Class.forName("com.adl.et.telco.tmf.datamodel.domain.dto." + className)));
            }
            return objectList;
        } catch (Exception ex) {
            logger.error("Error in array conversion " + ExceptionUtils.getStackTrace(ex));
        }
        return null;
    }

}
