/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import com.google.gson.Gson;
import helper.UserHelper;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

/**
 *
 * @author LENOVO
 */
@Path("User")
public class UserResources {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of UserResources
     */
    public UserResources() {
    }

    /**
     * Retrieves representation of an instance of service.UserResources
     * @return an instance of java.lang.String
     */
    @GET
    @Path("login1")
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson(@QueryParam("email") String email, @QueryParam("password") String password) {
        return new Gson().toJson(new UserHelper().login1(email, password));
    }

    /**
     * PUT method for updating or creating an instance of UserResources
     * @param content representation for the resource
     */
    @PUT
    @Consumes(javax.ws.rs.core.MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }
    }
