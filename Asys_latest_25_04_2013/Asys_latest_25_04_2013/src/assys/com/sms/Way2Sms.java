// Decompiled by DJ v3.12.12.96 Copyright 2011 Atanas Neshkov  Date: 6/15/2012 8:45:56 AM
// Home Page: http://members.fortunecity.com/neshkov/dj.html  http://www.neshkov.com/dj.html - Check often for new version!
// Decompiler options: packimports(3) 
// Source File Name:   Way2Sms.java

package assys.com.sms;

import java.io.PrintStream;
import java.util.Random;

// Referenced classes of package way2sms:
//            Credentials, URLConnector

public class Way2Sms
{

    public Way2Sms()
    {
    }

    public  String test(String s3,String s, String s1,String username,String password)
    {   sitetest=s3;
        login(username, password);
        sendSMS(s, s1);
       
        System.out.println("Message has been sent successfully!");
		return site;
    }

    private static void getSite()
    {
        URLConnector.connect("http://www.way2sms.com/", false, "GET", null, null);
        responseCode = URLConnector.getResponseCode();
        if(responseCode != 302 && responseCode != 200)
        {
           ;
        } else
        {
            site = URLConnector.getLocation();
            if(site != null)
                site = site.substring(7, site.length() - 1);
            System.out.println(site);
        }
        URLConnector.disconnect(); 
         
    }

    private static void preHome()
    {
        URLConnector.connect((new StringBuilder()).append("http://").append(site).append("/content/prehome.jsp").toString(), false, "GET", null, null);
        responseCode = URLConnector.getResponseCode();
        if(responseCode != 302 && responseCode != 200)
           ;
        else
            cookie = URLConnector.getCookie();
        URLConnector.disconnect();
    }

    private static void login(String s, String s1)
    {
    	if(!sitetest.equals(site))
    	{
        getSite();
        preHome();
        String s2 = null;
        credentials.set("username", s);
        credentials.append("password",s1);
        credentials.append("button", "Login");
        userCredentials = credentials.getUserCredentials();
        System.out.println(userCredentials);
        URLConnector.connect((new StringBuilder()).append("http://").append(site).append("/Login1.action").toString(), false, "POST", cookie, userCredentials);
        responseCode = URLConnector.getResponseCode();
        if(responseCode != 302 && responseCode != 200)
            exit(URLConnector.getErrorMessage());
        else
            s2 = URLConnector.getLocation();
        URLConnector.disconnect();
        URLConnector.connect(s2, false, "GET", cookie, null);
        responseCode = URLConnector.getResponseCode();
        if(responseCode != 302 && responseCode != 200)
        {
            System.out.println("Wrong Username and Password");
            
        }
        URLConnector.disconnect();
    	}
    }

    private static void getActionString()
    {
        URLConnector.connect((new StringBuilder()).append("http://").append(site).append("/jsp/InstantSMS.jsp").toString(), false, "GET", cookie, null);
        responseCode = URLConnector.getResponseCode();
        if(responseCode == 302 || responseCode == 200)
        {
            String s = URLConnector.getResponse();
            String s1 = "name=\"Action\" id=\"Action\"";
            int i = s1.length();
            int j = s.indexOf(s1);
            if(j > 0)
            {
                s = s.substring(j + i);
                j = s.indexOf("\"");
                if(j > 0)
                {
                    s = s.substring(j + 1);
                    j = s.indexOf("\"");
                    if(j > 0)
                        actionStr = s.substring(0, j);
                    
                }
            }
        } 
        URLConnector.disconnect();
    }

    private static void sendSMS(String s, String s1)
    {
        System.out.println("Came");
        getActionString();
        credentials.reset();
        credentials.set("HiddenAction", "instantsms");
        credentials.append("catnamedis", "Birthday");
      //  if(actionStr != null)
            credentials.append("Action", "sa65sdf656fdfd");
     //   else
      //      exit("Action string missing!");
        credentials.append("chkall", "on");
        credentials.append("MobNo", s);
        credentials.append("textArea", s1);
        userCredentials = credentials.getUserCredentials();
        System.out.println(userCredentials);
        URLConnector.connect((new StringBuilder()).append("http://").append(site).append("/quicksms.action").toString(), true, "POST", cookie, userCredentials);
        responseCode = URLConnector.getResponseCode();
       // if(responseCode != 302 && responseCode != 200)
         //   exit(URLConnector.getErrorMessage());
        URLConnector.disconnect();
    }

    private static void exit(String s)
    {
        System.err.println(s);
        
    }
   
    private static int responseCode = -1;
    private static String userCredentials = null;
    private static String cookie = null;
    private static String site = null;
    private static String sitetest = null;
    private static String actionStr = null;
    private static Credentials credentials = new Credentials();

}
