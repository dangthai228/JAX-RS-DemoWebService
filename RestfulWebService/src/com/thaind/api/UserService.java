package com.thaind.api;

import java.util.ArrayList;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.thaind.control.UserDAO;
import com.thaind.model.User;

@Path("/users")
public class UserService {
	UserDAO dao= new UserDAO();
    @GET
    @Path("/{id}")
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    //getOne
    public User get(@PathParam("id") int id) {
        return  dao.getUser(id);
    }
    //getAll
    @GET
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public ArrayList<User> getAll() {
        return dao.getAllUser();
    }
 
    @POST
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public boolean insert(User user) {
    	boolean kq= dao.InsertUser(user);
        return kq;
    }
 
    @PUT
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public boolean update(User user) {
        return dao.UpdateUser(user);
    }
 
    @DELETE
    @Path("/{id}")
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public boolean delete(@PathParam("id") int id) {
        return dao.DeleteUser(id);
    }
}
