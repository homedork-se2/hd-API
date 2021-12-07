package homedork.code.hdapi.services;

import homedork.code.hdapi.dataservices.QueryBuilder;
import homedork.code.hdapi.model.DeviceType;
import homedork.code.hdapi.model.Window;

import java.io.IOException;
import java.util.List;

public class WindowServices {

    QueryBuilder queryBuilder = new QueryBuilder();

    public List<Window> getAllWindows(String userId) {
        try {
            return queryBuilder.getAllDevicesGeneric(userId, DeviceType.WINDOW);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Window closeWindow(String windowId) {
        try {
            return queryBuilder.turnDeviceOffGeneric(windowId, DeviceType.WINDOW);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Window openWindow(String windowId) {
        try {
            return queryBuilder.turnDeviceOnGeneric(windowId, DeviceType.WINDOW);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Window getWindow(String windowId) {
        try {
            return queryBuilder.getGenericDevice(windowId);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Window slideWindowLevel(String windowId, double value) {
        try {
            return queryBuilder.deviceSlideLevelGeneric(value, windowId, DeviceType.WINDOW);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Window deleteWindow(String windowId) {
        try {
            return queryBuilder.deleteGenericDevice(windowId);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
