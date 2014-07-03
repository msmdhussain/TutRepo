package com.samples;

import javax.ws.rs.Path;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import com.sun.xml.internal.txw2.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.NONE)
@XmlRootElement(name = "user-management")
@Path("/user-management")
public class UserService {

	@XmlElement(name = "users")
	private String uri1 = "/user-management/users";
	
	@XmlElement(name ="report")
	private String uri2 = "/user-management/generate-report";
	
	
	
	

}
