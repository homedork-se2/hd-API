package homedork.code.hdapi.resources;

import homedork.code.hdapi.model.Alarm;
import homedork.code.hdapi.services.AlarmServices;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/alarms")
public class AlarmResource {

    AlarmServices alarmServices = new AlarmServices();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public List<Alarm> getAlarms(@PathParam("userId") String userId) {
        System.out.println("GET user: " + userId + " alarms");
        return alarmServices.getAllAlarms(userId);
    }

    @PUT
    @Path("/{alarmId}/turnOff")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Alarm turnAlarmOff(@PathParam("alarmId") String alarmId, @PathParam("userId") String userId) {
        System.out.println("Turn user: " + userId + " alarm off");
        return alarmServices.turnAlarmOff(alarmId);
    }

    @PUT
    @Path("/{alarmId}/turnOn")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Alarm turnAlarmOn(@PathParam("alarmId") String alarmId, @PathParam("userId") String userId) {
        System.out.println("Turn user: " + userId + " alarm on");
        return alarmServices.turnAlarmOn(alarmId);
    }

    @GET
    @Path("/{alarmId}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Alarm getAlarm(@PathParam("alarmId") String alarmId, @PathParam("userId") String userId) {
        System.out.println("GET user: " + userId + " alarm");
        return alarmServices.getAlarm(alarmId);
    }

    @PUT
    @Path("/{alarmId}/adjust/{value}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Alarm slideAlarmValue(@PathParam("alarmId") String alarmId, @PathParam("value") double value, @PathParam("userId") String userId) {
        System.out.println("Slide user: " + userId + " alarm to value: " + value);
        return alarmServices.slideAlarmLevel(alarmId, value);
    }
}