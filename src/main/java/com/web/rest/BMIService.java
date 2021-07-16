package com.web.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("/bmi")
public class BMIService {

    //Client:  JavaEE_Web/rest/bmi/?h=170&60"  
    @Path("/{h}/{w}")
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String bmi(@PathParam("h") Double h, @PathParam("w") Double w) {
        double bmi = w / Math.pow(h / 100.0, 2);
        return String.format("BMI = %.2f", bmi);
    }

    //Client:  JavaEE_Web/rest/bmi/180/60"
    @Path("/")
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String bmi2(@QueryParam("h") Double h, @QueryParam("w") Double w) {
        double bmi = w / Math.pow(h / 100.0, 2);
        return String.format("BMI = %.2f", bmi);
    }
}
