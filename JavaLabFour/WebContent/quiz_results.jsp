<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Boston Celtics Quiz - Results</title>
		<link rel="shortcut icon" href="images/ico.png">
		<link rel="stylesheet" href="css/bootstrap.min.css" type="text/css">
	</head>
	
	<body>
		<div class="p-3 mb-2 bg-light text-dark">
		<div class="container-fluid">
		<div class="container">
			<center>
				<h1>Boston Celtics Quiz Results</h1><br>
				<h2>Dear <b>${username}</b>, you've earned <b>${accumpoints}</b> of <b>6</b> possible points<br></h2>
				<h3>${message}</h3>
			</center>
		</div>
		</div>
		</div>
	</body>
</html>