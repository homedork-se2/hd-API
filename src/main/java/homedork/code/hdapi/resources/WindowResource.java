package homedork.code.hdapi.resources;

import homedork.code.hdapi.model.Alarm;
import homedork.code.hdapi.model.Window;
import homedork.code.hdapi.services.WindowServices;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

public class WindowResource {

    WindowServices windowServices = new WindowServices();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public List<Window> getWindows(@PathParam("userId") String userId) {
        return windowServices.getAllWindows(userId);
    }

    @PUT
    @Path("/{windowId}/turnOff")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Window turnWindowOff(@PathParam("windowId") String windowId, @PathParam("userId") String userId) {
        return windowServices.turnWindowOff(windowId);
    }

    @PUT
    @Path("/{windowId}/turnOn")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Window turnWindowOn(@PathParam("windowId") String windowId, @PathParam("userId") String userId) {
        return windowServices.turnWindowOn(windowId);
    }

    @GET
    @Path("/{windowId}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Window getWindow(@PathParam("windowId") String windowId, @PathParam("userId") String userId) {
        return windowServices.getWindow(windowId);
    }

    @PUT
    @Path("/{windowId}/adjust/{value}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Window slideWindowValue(@PathParam("windowId") String windowId, @PathParam("value") double value, @PathParam("userId") String userId) {
        return windowServices.slideWindowLevel(windowId, value);
    }
//
//    @DELETE
//    @Path("/{windowId}/delete")
//    @Produces(MediaType.APPLICATION_JSON)
//    @Consumes(MediaType.APPLICATION_JSON)
//    public Window deleteWindow(@PathParam("windowId") String windowId) {
//        return windowServices.deleteWindow(windowId);
//    }
}