package test;


import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@Path("/hello")
public class Hello {
	@GET
	@Produces(MediaType.TEXT_XML)
	public String SayHello() {
		String resource="<? xml version='1.0' ?>" + 
	    "<hello> You alrighty lad, how are you doing? - From XML </hello>";
		return resource; 
	}
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String SayHelloJSON() {
		String resource=null;
		return resource; 
	}
	/*
	@GET
	@Produces(MediaType.TEXT_HTML)
	public String SayHelloHTML() {
		String resource="<h1> You alrighty lad, how are you doing? - From HTML";
		return resource; 
	}

	 */
	@GET 
	@Produces(MediaType.TEXT_HTML)
	//takes the name, card number and the amount from the user: localhost:num/JavaTestAPI/rest/hello?name=greg&Card_num=12345&amount=1000
	public String sayHelloHTML(@QueryParam("name") String name, @QueryParam("Card_num")String Card_num, @QueryParam("amount") int amount ) {
		System.out.println("Name is:" + name);
		System.out.println("Amount is:" + amount);
		String response; 
		
		if (amount>10000) {
			System.out.println("Amount is greater than threshold");
			response = "Credit card was not approved";
		}
		else 
		{
			System.out.println("Amount is within the threshold");
			response = "Credit card was approved";
		}
		return "<html>" + "<title>" +"Credit card authorisation" + name + "</title>"
				+"<body><h1>" + response + "</h1><body>" + "</html>";
		}
	}
