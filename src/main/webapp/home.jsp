<%@page import="models.*"%>
<% Usuario usuario = (Usuario) request.getAttribute("usuario"); %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Login</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
     integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
</head>

<body>
<div class="container mt-5 col-4 bg-secondary text-center text-white rounded shadow">
    <div class="row justify-content-center">
        <div class="col-6 mt-2 mb-2">


            <h1>ALKEWALLET</h1>

            <h3>Bienvenido <%=usuario.getNombre() %></h3>
            <h3>Tu balance es de $<%=usuario.getBalance() %></h3>

        </div>
    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.min.js"
integrity="sha384-BBtl+eGJRgqQAUMxJ7pMwbEyER4l1g+O15P+16Ep7Q9Q+zqX6gSbd85u4mG4QzX+"
crossorigin="anonymous"></script>
</body>
</html>
