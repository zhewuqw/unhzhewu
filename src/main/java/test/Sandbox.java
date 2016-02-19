package test;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.fasterxml.jackson.databind.ObjectMapper;

@Path("sandbox")
public class Sandbox {
	ObjectMapper mapper = new ObjectMapper();

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("person")
	public Response getIt() {
		try {
			Person gula = new Person("Gula", "Nurmatova", "CT");
			String strGula = mapper.writeValueAsString(gula);
			return Response.status(Response.Status.OK)
					.entity(strGula).build();
		} catch (Exception e) {
			e.printStackTrace();
			return Response.status(Response.Status.BAD_REQUEST)
					.entity("Could not process your request").build();
		}
	}
}

class Person {
	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	String lastName;
	String firstName;
	String location;

	public Person(String firstName, String lastName, String location) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.location = location;
	}
}