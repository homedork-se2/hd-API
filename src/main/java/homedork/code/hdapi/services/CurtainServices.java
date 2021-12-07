package homedork.code.hdapi.services;

import homedork.code.hdapi.dataservices.QueryBuilder;
import homedork.code.hdapi.model.Curtain;
import homedork.code.hdapi.model.DeviceType;
import homedork.code.hdapi.model.Window;

import java.io.IOException;
import java.util.List;

public class CurtainServices {

    QueryBuilder queryBuilder = new QueryBuilder();

    public List<Curtain> getAllCurtains(String userId) {
        try {
            return queryBuilder.getAllDevicesGeneric(userId, DeviceType.CURTAIN);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Curtain closeCurtain(String curtainId) {
        try {
            return queryBuilder.turnDeviceOffGeneric(curtainId, DeviceType.CURTAIN);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Curtain openCurtain(String curtainId) {
        try {
            return queryBuilder.turnDeviceOnGeneric(curtainId, DeviceType.CURTAIN);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Curtain getCurtain(String curtainId) {
        try {
            return queryBuilder.getGenericDevice(curtainId);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Curtain slideCurtainLevel(String curtainId, double value) {
        try {
            return queryBuilder.deviceSlideLevelGeneric(value, curtainId, DeviceType.CURTAIN);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Curtain deleteCurtain(String curtainId) {
        try {
            return queryBuilder.deleteGenericDevice(curtainId);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
