package assys.com;

// To use the java client library include in your classpath the file 'mashapeClient.jar'
// make sure to have the json library from http://www.json.org/java/index.html
// import the generated source file
// grab your developer key( you can find it in your dashboard: http://www.mashape.com/account/index )
// and relax!
import assys.com.Way2SMS;

import org.json.JSONObject;

//import com.mashape.client.exceptions.MashapeClientException;
//import com.mashape.client.http.response.MashapeResponse;

public class Sample {

	public static void main(String[] args) {
		// basic instantiation. TODO Put your authentication keys here.
		Way2SMS client = new Way2SMS("MASHAPE_KEY");

		

		// A sample method call. These parameters are not properly filled in.
		// See Way2SMS.java to find all method names and parameters.
		com.mashape.client.http.MashapeResponse<JSONObject> response = client.sendSms("FILL IN PARAMETERS HERE","7878497574","homesweethome9","7878497574");

		//now you can do something with the response.
		System.out.println("API Call returned a response code of " + response.getCode());
	}
}
