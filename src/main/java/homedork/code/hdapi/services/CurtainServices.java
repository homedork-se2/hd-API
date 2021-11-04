package homedork.code.hdapi.services;

import homedork.code.hdapi.dataservices.QueryBuilder;
import homedork.code.hdapi.model.Curtain;

import java.io.IOException;
import java.util.List;

public class CurtainServices {

    QueryBuilder queryBuilder = new QueryBuilder();

    public List<Curtain> getAllCurtains(String userId) {
        try {
            return queryBuilder.getCurtains(userId);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Curtain turnCurtainOff(String curtainId, String userId) {
        try {
            return queryBuilder.turnCurtainOff(userId, curtainId);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Curtain turnCurtainOn(String curtainId, String userId) {
        try {
            return queryBuilder.turnCurtainOn(userId, curtainId);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Curtain getCurtain(String curtainId, String userId) {
        try {
            return queryBuilder.getCurtain(userId, curtainId);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Curtain slideCurtainLevel(String curtainId, double value, String userId) {
        try {
            return queryBuilder.slideCurtainLevel(userId, curtainId, value);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
