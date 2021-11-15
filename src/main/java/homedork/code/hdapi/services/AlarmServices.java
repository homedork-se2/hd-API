package homedork.code.hdapi.services;

import homedork.code.hdapi.dataservices.QueryBuilder;
import homedork.code.hdapi.model.Alarm;
import homedork.code.hdapi.model.DeviceType;

import java.io.IOException;
import java.util.List;

public class AlarmServices {

    QueryBuilder queryBuilder = new QueryBuilder();

    public List<Alarm> getAllAlarms(String userId) {
        try {
            return queryBuilder.getAllDevicesGeneric(userId, DeviceType.ALARM);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Alarm turnAlarmOff(String alarmId) {
        try {
            return queryBuilder.turnDeviceOffGeneric(alarmId);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Alarm turnAlarmOn(String alarmId) {
        try {
            return queryBuilder.turnDeviceOnGeneric(alarmId);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Alarm getAlarm(String alarmId) {
        try {
            return queryBuilder.getGenericDevice(alarmId);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Alarm slideAlarmLevel(String alarmId, double value) {
        try {
            return queryBuilder.deviceSlideLevelGeneric(value, alarmId);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
