package homedork.code.hdapi.services;

import homedork.code.hdapi.dataservices.QueryBuilder;
import homedork.code.hdapi.model.DeviceType;
import homedork.code.hdapi.model.Thermometer;
import homedork.code.hdapi.model.Window;

import java.io.IOException;
import java.util.List;

public class ThermServices {

    QueryBuilder queryBuilder = new QueryBuilder();

    public List<Thermometer> getAllTherms(String userId) {
        try {
            return queryBuilder.getAllDevicesGeneric(userId, DeviceType.THERM);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Thermometer turnThermOff(String thermId) {
        try {
            return queryBuilder.turnDeviceOffGeneric(thermId, DeviceType.THERM);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Thermometer turnThermOn(String thermId) {
        try {
            return queryBuilder.turnDeviceOnGeneric(thermId, DeviceType.THERM);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Thermometer getTherm(String thermId) {
        try {
            return queryBuilder.getGenericDevice(thermId);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Thermometer slideThermLevel(String thermId, double value) {
        try {
            return queryBuilder.deviceSlideLevelGeneric(value, thermId, DeviceType.THERM);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
