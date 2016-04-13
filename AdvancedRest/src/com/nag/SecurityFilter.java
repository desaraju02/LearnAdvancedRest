package com.nag;

import java.io.IOException;
import java.util.List;
import java.util.StringTokenizer;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;

import org.glassfish.jersey.internal.util.Base64;

@Provider
public class SecurityFilter implements ContainerRequestFilter {
	
	private static String AUTH_HEADER = "Authorization";

	@Override
	public void filter(ContainerRequestContext requestFilter) throws IOException {

	  if(requestFilter.getUriInfo().getPath().contains("secured"))
	  {

			List<String> authHeaders = requestFilter.getHeaders().get(AUTH_HEADER);
			
			if(authHeaders != null && authHeaders.size() > 0)
			{
				String authToken = authHeaders.get(0);
				String authTokenString = authToken.replace("Basic ", "");
				String decodedString = Base64.decodeAsString(authTokenString);
				StringTokenizer tokenizedString = new StringTokenizer(decodedString,":");
				String userName = tokenizedString.nextToken();
				String password = tokenizedString.nextToken();
				
				
				if(userName.equalsIgnoreCase("user") && password.equalsIgnoreCase("password"))
					return;
						
				
			}
			
			Response unauthorized = Response.status(Response.Status.UNAUTHORIZED).build();
			requestFilter.abortWith(unauthorized);
					

	  }
		
		
	}

}
