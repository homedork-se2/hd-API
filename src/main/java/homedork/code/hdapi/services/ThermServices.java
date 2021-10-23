package homedork.code.hdapi.services;

import homedork.code.hdapi.dataservices.QueryBuilder;
import homedork.code.hdapi.model.Thermometer;

import java.io.IOException;
import java.util.List;

public class ThermServices {

    QueryBuilder queryBuilder = new QueryBuilder();

    public List<Thermometer> getAllTherms(String userId) {
        try {
            return queryBuilder.getTherms(userId);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Thermometer turnThermOff(String thermId, String userId) {
        try {
            return queryBuilder.turnThermOff(userId, thermId);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Thermometer turnThermOn(String thermId, String userId) {
        try {
            return queryBuilder.setThermOn(userId, thermId);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Thermometer getTherm(String thermId, String userId) {
        try {
            return queryBuilder.getTherm(userId, thermId);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Thermometer slideThermLevel(String thermId, double value, String userId) {
        try {
            return queryBuilder.slideThermLevel(userId, thermId, value);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
