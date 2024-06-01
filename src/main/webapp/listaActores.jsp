<%--
  Created by IntelliJ IDEA.
  User: Pc
  Date: 31/05/2024
  Time: 18:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<jsp:useBean id="lista" scope="request" type="ArrayList<Actor>"/><%-- Obtengo la lista de actores--%>
<jsp:useBean id="nombrePelicula" scope="request" type="String"/><%-- Obtengo el nombre de la pelicula--%>
<%@ page import="org.example.lab6_20211688.model.beans.Pelicula" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.io.PrintWriter" %>
<%@ page import="org.example.lab6_20211688.model.beans.Actor" %>


<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Actores de pelicula <%=nombrePelicula%></title>
    <style>
        table {
            width: 100%;
            border-collapse: collapse;
        }

        th, td {
            border: 1px solid black;
            padding: 8px;
            text-align: left;
        }
    </style>
</head>
<body>

<h1><%=nombrePelicula%></h1>
<table>
    <thead>
    <tr>
        <th>idActor</th>
        <th>Nombre</th>
        <th>Apellido</th>
        <th>Ano Nacimiento</th>
        <th>Ganador Premio Oscar</th>

    </tr>
    </thead>
    <tbody>

    <%for(Actor actor : lista){ %>
    <tr>
        <td><%=actor.getIdActor() %></td>
        <td><%=actor.getNombre() %></td>
        <td><%=actor.getApellido() %></td>
        <td><%=actor.getAnhoNacimiento() %></td>

        <%
            String premioOscar;
            if(actor.getGanadorPremioOscar() == 0){
                premioOscar = "false";
            }
            else{ // si es 1
                premioOscar = "true";
            }
        %>
        <td><%=premioOscar%></td>

    </tr>
    <% } %>


    </tbody>
</table>
</body>
</html>
