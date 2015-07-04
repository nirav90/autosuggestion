package assys.com;


import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.io.InputStream;
import java.io.File;
import org.json.JSONObject;
import org.json.JSONArray;

import com.mashape.client.authentication.Authentication;
import com.mashape.client.authentication.AuthenticationParameter;
import com.mashape.client.authentication.MashapeAuthentication;
import com.mashape.client.authentication.QueryAuthentication;
import com.mashape.client.authentication.HeaderAuthentication;
import com.mashape.client.authentication.BasicAuthentication;
import com.mashape.client.authentication.OAuthAuthentication;
import com.mashape.client.authentication.OAuth10aAuthentication;
import com.mashape.client.authentication.OAuth2Authentication;
import com.mashape.client.http.ContentType;
import com.mashape.client.http.HttpClient;
import com.mashape.client.http.HttpMethod;
import com.mashape.client.http.MashapeCallback;
import com.mashape.client.http.MashapeResponse;
import com.mashape.client.http.ResponseType;
import com.mashape.client.http.utils.HttpUtils;

public class Way2SMS {

	private final static String PUBLIC_DNS = "way2sms.p.mashape.com";
    private List<Authentication> authenticationHandlers;

    public Way2SMS (String mashapeKey) {
        authenticationHandlers = new LinkedList<Authentication>();
        authenticationHandlers.add(new MashapeAuthentication(mashapeKey));
        
    }
    
    /**
     * Synchronous call with optional parameters.
     */
    public MashapeResponse<JSONObject> sendSms(String msg, String phone, String pwd, String uid) {
        Map<String, Object> parameters = new HashMap<String, Object>();
        
        if (msg != null && !msg.equals("")) {
	parameters.put("msg", msg);
        }
        
        
        
        if (phone != null && !phone.equals("")) {
	parameters.put("phone", phone);
        }
        
        
        
        if (pwd != null && !pwd.equals("")) {
	parameters.put("pwd", pwd);
        }
        
        
        
        if (uid != null && !uid.equals("")) {
	parameters.put("uid", uid);
        }
        
        
        
        return (MashapeResponse<JSONObject>) HttpClient.doRequest(JSONObject.class,
                    HttpMethod.GET,
                    "https://" + PUBLIC_DNS + "/index.php",
                    parameters,
                    ContentType.FORM,
                    ResponseType.JSON,
                    authenticationHandlers);
    }

    /**
     * Asynchronous call with optional parameters.
     */
    public Thread sendSms(String msg, String phone, String pwd, String uid, MashapeCallback<JSONObject> callback) {
        Map<String, Object> parameters = new HashMap<String, Object>();
        
        
        if (msg != null && !msg.equals("")) {
        
            parameters.put("msg", msg);
        }
        
        
        
        if (phone != null && !phone.equals("")) {
        
            parameters.put("phone", phone);
        }
        
        
        
        if (pwd != null && !pwd.equals("")) {
        
            parameters.put("pwd", pwd);
        }
        
        
        
        if (uid != null && !uid.equals("")) {
        
            parameters.put("uid", uid);
        }
        
        
        return HttpClient.doRequest(JSONObject.class,
                    HttpMethod.GET,
                    "https://" + PUBLIC_DNS + "/index.php",
                    parameters,
                    ContentType.FORM,
                    ResponseType.JSON,
                    authenticationHandlers,
                    callback);
    }

}