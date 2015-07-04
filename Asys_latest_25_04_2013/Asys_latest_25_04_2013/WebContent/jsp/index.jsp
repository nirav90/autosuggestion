<%@ taglib prefix="s" uri="/struts-tags" %>




<!DOCTYPE html>
<!--

  Liquid Slider 1.1
  Kevin Batdorf

  http://liquidslider.kevinbatdorf.com

  GPL license 

-->
<html lang="en-us">

  <head>
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=Edge;chrome=1" />
    <meta name="description" content="Liquid Slider : A JQuery Slider Plugin" />

    <!-- 
      Here is the style sheet for the Liquid Slider
      You may want to "minify" this after making edits
      http://www.refresh-sf.com/yui/ 
    -->
    <link rel="stylesheet" type="text/css" media="screen" href="${pageContext.request.contextPath}/stylesheets/liquid-slider-1.1.css">

    <!-- This is just styling for the demo to make it a little less crowded at the top -->
    <style>
    h1{
    margin:100px;
    }
    </style>


    <!-- Definitely use these for development -->
    <script src="${pageContext.request.contextPath}/js/jquery-1.8.2.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/jquery-ui-1.8.20.custom.min.js"></script>

    <!-- This of course is required. The full version (not .min) is also included in the js directory -->
    <script src="${pageContext.request.contextPath}/js/jquery.liquid-slider-1.1.min.js"></script>

    <!-- <title>Liquid Slider 1.1</title> -->
	<title>AtWork Solutions</title>
    <script>
    $(function(){

      /* Here is the slider using default settings */
      $('#slider-id').liquidSlider({
            autoSlide:true,
            autoHeight:true,
          });
      /* If you want to adjust the settings, you set an option
         as follows:

          $('#slider-id').liquidSlider({
            autoSlide:false,
            autoHeight:false
          });

         Find more options at http://liquidslider.kevinbatdorf.com/
      */

      /* If you need to access the internal property or methods, use this method.

      var sliderObject = $.data( $('#slider-id')[0], 'liquidSlider');
      console.log(sliderObject);

      */


    });
    </script> 
  </head>
  <body class='no-js' style="margin:0; background: none repeat scroll 0 0 #2E5E79;">
     <div class="container_12">
 <div style="background-color: #254B61;height:15%;width:99.8%;color:white;font-size:150%;">

<img src="${pageContext.request.contextPath}/img/logo_final.jpeg">

<!-- <a href="#" style="float:right;margin:4">Contact Us</a>
<a href="#" style="float:right;margin:4">About Us</a>
<a href="index.jsp" style="float:right;margin:4;">Home</a> -->    


</div>
</div>
     
     
     
     
     <div style="margin:100px;">
     <div class="liquid-slider"  id="slider-id"  >
        <div>
          <h2 class="title" style="font-size: 20px;color:#389BBC;font-family:cursive;">Home</h2>
          <table>
          <tr>
          <td><b style="font-size: 20px;color:#389BBC;font-family:cursive;">Webmail</b></td><td></td>
          </tr>
          <tr>
          <td><p style="font-size: 20px;color: black;font-family: cursive;" >Proven to be intuitive to end-users. Fast, responsive and feature rich without any clutter. Complete IMAP Webmail client with all the bells and whistles. CSS and plugin framework for easy re-branding & customization.</p></td>
          <td><img src="${pageContext.request.contextPath}/img/webmail.png"/></td>
          </tr>
          
          
          <tr>
          <td style="font-size: 20px;color:#389BBC;font-family:cursive;"><b>Calander</b></td><td></td>
          </tr>
          <tr>
		  <td><img src="${pageContext.request.contextPath}/img/feature-calendar.png"/></td>
          <td><p style="font-size: 20px;color: black;font-family: cursive;">Beautiful and intuitive calendar in your browser. Connect externally,  atwork calendar supports recurrence, invitations and alerts. Create and share calendars with individuals or groups.</p></td>
          
          </tr>
          
          
          <tr>
          <td style="font-size: 20px;color:#389BBC;font-family:cursive;"><b>Addressbook</b></td><td></td>
          </tr>
          <tr>
          <td><p style="font-size: 20px;color: black;font-family: cursive;">Create, manage, group and share rich contacts data from browser, mobile devices or desktop apps. Share with individuals, groups or domains</p></td>
          <td><img src="${pageContext.request.contextPath}/img/feature-addressbook.png"/></td>
          </tr>
          
          
          </table>
        </div>
        
        <div>
          <h2 class="title" style="font-size: 20px;color:#389BBC;font-family:cursive;">Login</h2>
          <table>
          <tr>
          <td><p style="font-size: 20px;color: black;font-family: cursive;">Existing Employee, Manager and Client can login by Clicking on Login  </p></td>
          <td><a href="${pageContext.request.contextPath}/jsp/login.jsp"><img src="${pageContext.request.contextPath}/img/login page.png" /></a></td>
          </tr>
          </table>
        </div>
        
        
        <div>
          <h2 class="title" style="font-size: 20px;color:#389BBC;font-family:cursive;">Register</h2>
          <table>
          
          <tr>
          <td><p style="font-size: 20px;color: black;font-family: cursive;">Employee and Manager register or Sign up by just click on regiset </p></td>
          <td><a href="${pageContext.request.contextPath}/jsp/register.jsp"><img src="${pageContext.request.contextPath}/img/register page 1.png" /></a></td>
          </tr>
          </table>
          
        </div>          
        <div>
          <h2 class="title" style="font-size: 20px;color:#389BBC;font-family:cursive;">Contact Us</h2>
          <table width="100%">
          
          <tr>
          <td><p style="font-size: 20px;color: black;font-family: cursive;">E-130 &nbsp &nbsp sector-1 </p><p style="font-size: 20px;color: black;font-family: cursive;">Chankyapuri,Ghatlodia </p><p style="font-size: 20px;color: black;font-family: cursive;">Ahmedabad,380061 </p></td>
          <%-- <td><iframe width="300" height="300" frameborder="0" scrolling="no" marginheight="0" marginwidth="0" src="https://maps.google.com/maps?f=q&amp;source=s_q&amp;hl=en&amp;geocode=&amp;q=sector+1+chankyapuri+ghatlodia+ahmedabad+gujarat&amp;aq=&amp;sll=37.0625,-95.677068&amp;sspn=39.371738,86.044922&amp;t=m&amp;ie=UTF8&amp;hq=sector+1+chankyapuri&amp;hnear=Ghatlodia,+Ahmedabad,+Gujarat,+India&amp;ll=23.07531,72.540321&amp;spn=0.047378,0.051498&amp;z=13&amp;output=embed"></iframe><br /><small><a href="https://maps.google.com/maps?f=q&amp;source=embed&amp;hl=en&amp;geocode=&amp;q=sector+1+chankyapuri+ghatlodia+ahmedabad+gujarat&amp;aq=&amp;sll=37.0625,-95.677068&amp;sspn=39.371738,86.044922&amp;t=m&amp;ie=UTF8&amp;hq=sector+1+chankyapuri&amp;hnear=Ghatlodia,+Ahmedabad,+Gujarat,+India&amp;ll=23.07531,72.540321&amp;spn=0.047378,0.051498&amp;z=13" style="color:#0000FF;text-align:left">View Larger Map</a></small></td> --%>
          </tr>
          </table>
        </div>
      </div>
      </div>
      
      <!-- Liquid Slider Ends Here -->
      
  </body>
</html>







