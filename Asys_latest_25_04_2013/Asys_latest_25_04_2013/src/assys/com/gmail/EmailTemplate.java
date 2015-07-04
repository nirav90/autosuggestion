package assys.com.gmail;

public class EmailTemplate {

	
	
	public String headerHtml()
	{
		
		String headerHtml="<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">"+
		"<html><head><meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\"></head><body style=\"background: #D1DEE4; border-color: black; border: 2px;\">"+
		"<div style=\"background-color:  #2E5E79; height: 70px; \"><table><tr><td style=\"font-family:cursive  ;color: white; size: 25px;  \">AtWork </td><td style=\"font-family:cursive  ;color: white;\">Websolution</td>"+
		"</tr></table></div><div  style=\"height:500px\"><p><pre style=\"font-family: sans-serif;size: 30px\">";
		return headerHtml;
		
	}
	
	public String footerHtml()
	{
		
		
		String footerHtml = "</pre></p></div><div style=\"background-color:  #2E5E79; height: 25px; color: white; \">copyrights by AtWork websolution</div>"+
		"</body></html>";

		
		
		return footerHtml;
	}
	
	
}
