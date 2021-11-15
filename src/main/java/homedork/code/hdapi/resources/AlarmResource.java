package homedork.code.hdapi.resources;

import homedork.code.hdapi.model.Alarm;
import homedork.code.hdapi.services.AlarmServices;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

public class AlarmResource {

    AlarmServices alarmServices = new AlarmServices();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public List<Alarm> getAlarms(@PathParam("userId") String userId) {
        return alarmServices.getAllAlarms(userId);
    }

    @PUT
    @Path("/{alarmId}/turnOff")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Alarm turnCurtainOff(@PathParam("alarmId") String alarmId, @PathParam("userId") String userId) {
        return alarmServices.turnAlarmOff(alarmId);
    }

    @PUT
    @Path("/{alarmId}/turnOn")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Alarm turnCurtainOn(@PathParam("alarmId") String alarmId, @PathParam("userId") String userId) {
        return alarmServices.turnAlarmOn(alarmId);
    }

    @GET
    @Path("/{alarmId}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Alarm getCurtain(@PathParam("alarmId") String alarmId, @PathParam("userId") String userId) {
        return alarmServices.getAlarm(alarmId);
    }

    @PUT
    @Path("/{alarmId}/adjust/{value}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Alarm slideCurtainValue(@PathParam("alarmId") String alarmId, @PathParam("value") double value, @PathParam("userId") String userId) {
        return alarmServices.slideAlarmLevel(alarmId, value);
    }
}