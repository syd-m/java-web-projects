<%@ include file="JSP/billsummaryCode.jsp" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<META HTTP-EQUIV="refresh" CONTENT="<%= session.getMaxInactiveInterval() %>; URL=sessiontimeout.jsp" />
        <title>Select Payment Method</title>
      	
        
        <style type="text/css">
		html {
				background-color:#C0E6EA;
				border:1px grey solid;
				margin:20px; padding:20px;
			}
		</style>
        
    </head>
   	<body>
   	
   	
   	
   		<%@include file="JSP/header.jsp" %>
      	
      	 <strong>My Account  </Strong><hr>
      	 <br><br>
      	 <form action="selectpaymentmethod.jsp" method="post">
      	 <table width=100%>
      	 <tr>
      	 	<td> <b>Account Name   :</b>  Nishant Pounikar </td>
      	 	<td> <b>Total Amount due :</b>
      	 </tr>
      	 <tr>
      	 	<td> <b>Account Number :</b>  000112345678901234 </td>
      	 	<td> $500.00</td>
      	 </tr>
      	</table><br><br> <hr>
      	<p align="right"><input type="submit" name="btnSubmit" value="Proceed to Bill Payment &gt;&gt;"/>  </p>
      	</form>
</body>
</html>