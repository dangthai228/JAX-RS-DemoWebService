package com.thaind.client;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.logging.LoggingFeature;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.thaind.model.User;

public class UserServiceClient {
	
	public static final String API_URL = "http://localhost:8080/RestfulWebService/rest/users";
	
	public static Client createJerseyRestClient() {
        ClientConfig clientConfig = new ClientConfig();
 
        clientConfig.register( //
                new LoggingFeature( //
                        Logger.getLogger(LoggingFeature.DEFAULT_LOGGER_NAME), //
                        Level.INFO, //
                        LoggingFeature.Verbosity.PAYLOAD_ANY, //
                        10000));
 
        return ClientBuilder.newClient(clientConfig);
    }
	public static String convertToJson(User user) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.writeValueAsString(user);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
	
	 /**
     * @GET /{id}
     * 
     *      Get one user with the given id
     */
    public static User getUser(Integer id) {
        Client client = createJerseyRestClient();
        WebTarget target = client.target(API_URL).path("" + id);
        return target.request(MediaType.APPLICATION_JSON_TYPE).get(User.class);
    }
 
    /**
     * @GET
     * 
     *      Get all users
     */
    public static ArrayList<User> getAllUsers() {
        Client client = createJerseyRestClient();
        WebTarget target = client.target(API_URL);
        GenericType<ArrayList<User>> entity = new GenericType<ArrayList<User>>() {
        };
        return target.request(MediaType.APPLICATION_JSON_TYPE).get(entity);
    }
 
    /**
     * @POST
     * 
     *      create user
     */
    public static Boolean createUser(User user) {
        String jsonUser = convertToJson(user);
        Client client = createJerseyRestClient();
        WebTarget target = client.target(API_URL);
        Response response = target.request(MediaType.APPLICATION_JSON_TYPE)
                .post(Entity.entity(jsonUser, MediaType.APPLICATION_JSON));
        return response.readEntity(Boolean.class);
    }
 
    /**
     * @PUT
     * 
     *      Update user
     */
    public static Boolean updateUser(User user) {
        String jsonUser = convertToJson(user);
        Client client = createJerseyRestClient();
        WebTarget target = client.target(API_URL);
        Response response = target.request(MediaType.APPLICATION_JSON_TYPE)
                .put(Entity.entity(jsonUser, MediaType.APPLICATION_JSON));
        return response.readEntity(Boolean.class);
    }
 
    /**
     * @DELETE
     * 
     *      Delete user
     */
    public static Boolean deleteUser(Integer id) {
        Client client = createJerseyRestClient();
        WebTarget target = client.target(API_URL).path("" + id);
        Response response = target.request(MediaType.APPLICATION_JSON_TYPE).delete();
        return response.readEntity(Boolean.class);
    }
}
