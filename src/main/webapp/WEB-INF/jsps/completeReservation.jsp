<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Complete Reservation</title>
<body>

<h2>Complete Reservation</h2>
<pre>
Airline:        ${flight.operatingAirlines}<br>
Departure City: ${flight.departureCity}<br>
Arrival City:   ${flight.arrivalCity}<br>
</pre>
<form action="completeReservation" method="post">
<pre>
    <h2>Pasanger Detils</h2>
    First Name:               <input type="text" name="passangerFirstName" />
    Last Name:                <input type="text" name="passangerLastName" />
    Email:                    <input type="text" name="passangerEmail" />
    Passenger Phone:          <input type="text" name="passangerPhone" />

    <h2>Card Details</h2>
    Name on the Card:         <input type="text" name="nameOnTheCard" />
    Card Number:              <input type="text" name="cardNumber" />
    Expiry Date:              <input type="text" name="eexpiryDate" />
    Three Digit Security Code:<input type="text" name="nameOnTheCard" />

    <input type="hidden" name="flightId" value="${flight.id}" />

    <input type="submit" value="Confirm">

</pre>
</form>



</body>
</head>
</html>