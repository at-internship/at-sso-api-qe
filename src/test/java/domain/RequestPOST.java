package domain;

import org.json.JSONObject;
import lombok.Data;

@Data
public class RequestPOST { 
	private String name; 
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private String status;
	private int flag;

	public String requestBody() { 
		JSONObject obj = new JSONObject();
		if(name == null||false == name.equals("dont")) {
			obj.put("name", name);
		}
		if(firstName == null||false == firstName.equals("dont")) {
			obj.put("firstName", firstName);
		}
		if(lastName == null||false == lastName.equals("dont")) {
			obj.put("lastName", lastName);
		}
		if(email == null||false == email.equals("dont")) {
			obj.put("email",email);
		}
		if(password == null||false == password.equals("dont")) {
			obj.put("password", password);
		}
		if(status == null||false == status.equals("dont")) {
			obj.put("status", status);
		}

		return obj.toString();
	}
}
