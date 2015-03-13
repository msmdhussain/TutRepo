package com.example.restful;


import javax.servlet.annotation.MultipartConfig;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.log4j.Logger;

import com.sun.jersey.multipart.FormDataParam;
import com.sun.jersey.multipart.MultiPart;

@Path("/")
public class ExampleRequest {

	@Path("/GET/{a}")
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String example(@PathParam("a") String example){
		
		Logger.getLogger(getClass()).info("Working???");
		return example + "!!!";
	}
	
	
	
	@POST
	@Produces(MediaType.TEXT_PLAIN)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public String post(@FormParam("data") String data){
		
		return data;
	}
	
	
	
	
	
	@POST
	@Path("/POST")
	@Produces(MediaType.TEXT_PLAIN)
	@Consumes(MediaType.APPLICATION_JSON)
	public String postJson(Test Json ){
		 
		return "done"+Json.toString();
	}
	
	
	@POST
	@Path("/TEST")
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	public String Test(@FormDataParam("")){
		
		System.out.println(multiPart);
		
		return "multipart";
	}
	
}
