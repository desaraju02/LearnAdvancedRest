package com.nag.client;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public class RestApiClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Client client = ClientBuilder.newClient();
		/*Message response = client.target("http://localhost:8080/kmessenger/webapi/messages/1").
				request().
				accept(MediaType.APPLICATION_JSON).
				get(Message.class);*/
		
		
	/*	String response = client.target("http://localhost:8080/kmessenger/webapi/messages/1").
				request().
				accept(MediaType.APPLICATION_JSON).
				get(String.class);
		*/
		
		WebTarget baseTarget = client.target("http://localhost:8080/kmessenger/webapi/");
		WebTarget messagesTarget = baseTarget.path("messages");
		WebTarget singleMessageTarget = messagesTarget.path("{messageId}");
		
		String response = singleMessageTarget.resolveTemplate("messageId", "2")
							.request(MediaType.APPLICATION_JSON)
							.get(String.class);
		
		System.out.println(response);
		
		System.out.println("-----------------POST Message------------------");
		
		Message postMessage = new Message(5, "This is a message from JAXRS Client", "Mahesh");
		Response postResponse = messagesTarget.request()
						.post(Entity.json(postMessage));
		
		System.out.println("Status is:"+ postResponse.getStatus());
		Message msg = postResponse.readEntity(Message.class);
					
		
		postResponse.getLastModified();
		System.out.println(msg.getAuthor());
	/*	String response1 = singleMessageTarget.resolveTemplate("messageId", "5")
				.request(MediaType.APPLICATION_JSON)
				.get(String.class);

		System.out.println(response1);*/
		

	}

}
