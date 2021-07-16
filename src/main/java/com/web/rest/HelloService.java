package com.web.rest;

import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

@Path("/hello")
public class HelloService {

    //Client: /JavaEE_Web/rest/hello/john
    @Path("/john")
    @GET
    @Produces("text/plain")
    public String helloJohn() {
        return "Hello John";
    }

    //Client: /JavaEE_Web/rest/hello/1
    //Client: /JavaEE_Web/rest/hello/2
    @Path("/{id}")
    //{} =?@PathParam   ,  / = /@QueryParam
    @GET
    @Produces("text/plain")
    public String helloID(@PathParam("id") Integer id, @DefaultValue("0") @QueryParam("score") Integer score) {
        return "Hello ID " + id + " score = " + score;
    }

}
