<%@ page import="data.*" %>
<%@ page import="controller.*" %>
<%@ include file="availabilityCode.jsp"%>
<html>
<head>
       
<title>Airline System</title>

</script>
<style type="text/css">
html {
	border: 1px grey solid;
	margin: 100px;
	padding: 20px;
}

fieldset {
	display: block;
	margin-left: 2px;
	margin-right: 2px;
	padding-top: 0.35em;
	padding-bottom: 0.625em;
	padding-left: 0.75em;
	padding-right: 0.75em;
	border: 2px groove(internal value);
}
</style>
</head>
    <body>
	<h1>Airline System </h1>
        <div align="left">
        	
                    
            <form action="passengersListCode.jsp" method="post">
            <fieldset>
            <legend><strong><i>Display List of Passengers</i></strong></legend>
            <table align="">
            
            	<tr>
            		<td>  Flight Number  </td>
                	<td><input type="text" name="fno" value="" id="fno" maxlength="4" required/></td>
                </tr>
               
                
                <tr>
            		<td>  Date  </td>
            		<td><input type="date" name="date" value="" id="date" min="2015-05-31"  required/></td>
            	</tr>
             
                <tr>
                	<td></td>	
                	<td><input type="submit" value="Display list of Passengers" name="btnSubmit" class="btnSubmit" id="btnsubmit" /><br/>
                		
                	</td>
                </tr>
           	</table>
           	</fieldset>
           	
           	<br><br><br><br>
           	
           	
           	<fieldset>
            <legend><strong><i>  More Options</i></strong></legend>
           	 <table align="">
           	 
               <tr>
            		<td> <a href="displayAvailability.jsp">Display the number of available seats on a particular flight instance</a> </td>
                	
                </tr>
               
                <tr>
            		<td> <a href="passengersList.jsp">Display list of passengers on a given flight instance</a>  </td>
                	
                </tr>
                <tr>
            		<td> <a href="listofFlights.jsp">Display a list of flight instances for a particular passenger name</a>  </td>
                	
                </tr>
           	</table>
           	</fieldset>
            </form>
            <br><br>
             <a href="index.jsp">  &lt;&lt;&lt;&lt;  Go Home  </a>
            
         </div>

</body>
</html>

          
