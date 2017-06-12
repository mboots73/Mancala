
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html >
<html>
<head>


<meta charset="ISO-8859-1">

<title>MancalaGame</title>
<link rel = "stylesheet" href="./css/mancala.css" type = "text/css"/>
<link rel=stylesheet href="https://s3-us-west-2.amazonaws.com/colors-css/2.2.0/colors.min.css">
</head>
<body>


	<form method ="post" action="/Mancala/MancalaServlet.html">
	<div id="player1buttons">
		<c:forEach var="i" begin="0" end="5">
	
   				<button class = "player1" name = "${i}" value="${i}">${currentState.stones[i]} </button>
   				
		</c:forEach>

  		 <button class = "kalaha" id = "player1kalaha" name = "6" value="${i}">${currentState.stones[6]} </button>

	</div> 
	</form>

<form method ="post" action="/Mancala/MancalaServlet.html">
	<div id="player2buttons">
			<c:forEach var="i" begin="7" end="12">
   				<button class = "player2" name = "${i}" value="${i}">${currentState.stones[i]} </button>
			</c:forEach>


   		<button class = "kalaha" id= "player2kalaha" name = "13" value="${i}">${currentState.stones[13]} </button>

	</div>
	</form>
  <p id="player"> It is the turn of player ${currentState.currentTurn} </p>
<p id="winner" > The winner of the game is ${currentState.winningPlayer }</p>
<p> </p>
</body>
</html>