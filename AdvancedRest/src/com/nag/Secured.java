package com.nag;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("secured")
public class Secured {
	
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String getSecured()
	{
		return "This is a secured response !!";
	}

}
