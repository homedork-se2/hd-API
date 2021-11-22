package homedork.code.hdapi.resources;

import homedork.code.hdapi.model.Window;
import homedork.code.hdapi.services.WindowServices;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/windows")
public class WindowResource {

    WindowServices windowServices = new WindowServices();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public List<Window> getWindows(@PathParam("userId") String userId) {
        System.out.println("GET user: " + userId + " windows");
        return windowServices.getAllWindows(userId);
    }

    @PUT
    @Path("/{windowId}/turnOff")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Window turnWindowOff(@PathParam("windowId") String windowId, @PathParam("userId") String userId) {
        System.out.println("Turn user: " + userId + " window off");
        return windowServices.turnWindowOff(windowId);
    }

    @PUT
    @Path("/{windowId}/turnOn")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Window turnWindowOn(@PathParam("windowId") String windowId, @PathParam("userId") String userId) {
        System.out.println("Turn user: " + userId + " window on");
        return windowServices.turnWindowOn(windowId);
    }

    @GET
    @Path("/{windowId}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Window getWindow(@PathParam("windowId") String windowId, @PathParam("userId") String userId) {
        System.out.println("GET user: " + userId + " window");
        return windowServices.getWindow(windowId);
    }

    @PUT
    @Path("/{windowId}/adjust/{value}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Window slideWindowValue(@PathParam("windowId") String windowId, @PathParam("value") double value, @PathParam("userId") String userId) {
        System.out.println("Slide user: " + userId + " window to value: " + value);
        return windowServices.slideWindowLevel(windowId, value);
    }
}