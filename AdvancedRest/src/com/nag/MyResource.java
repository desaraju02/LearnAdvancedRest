package com.nag;


import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("test")

public class MyResource {


	@PathParam("paramValue") private String pathParamValue;
	@QueryParam("queryValue") private String queryParamValue;
	
	@GET
	@Path("/{paramValue}")
	@Produces(MediaType.TEXT_PLAIN)
	public String getTestParams()
	{
		
		return "Hello under world. Path param Value = "+pathParamValue+" Query Param Value = "+queryParamValue;
	}
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String getTest()
	{
		
		return "Hello under world ";
	}
	

}
