<%@ page import="java.text.NumberFormat" %><%--
  Created by IntelliJ IDEA.
  User: Pc
  Date: 31/05/2024
  Time: 16:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<jsp:useBean id="peliculaSeleccionada" scope="request" type="Pelicula"/><%-- Obtengo la pelicula que quiero mostrar a detalle--%>

<%@ page import="org.example.lab6_20211688.model.beans.Pelicula" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.io.PrintWriter" %>
<%@ page import="java.text.NumberFormat" %>
<%@ page import="java.util.Locale" %>


<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title><%=peliculaSeleccionada.getTitulo()%></title>
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

<h1><%=peliculaSeleccionada.getTitulo()%></h1>
    <table>
        <% NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(Locale.US);%>
        <tr>
            <th>idPelicula</th>
            <td><%=peliculaSeleccionada.getIdPelicula() %></td>
        </tr>

        <tr>
            <th>Director</th>
            <td><%=peliculaSeleccionada.getDirector() %></td>
        </tr>

        <tr>
            <th>Año publicacion</th>
            <td><%=peliculaSeleccionada.getAnoPublicacion() %></td>
        </tr>

        <tr>
            <th>Rating</th>
            <td><%=peliculaSeleccionada.getRating() + "/10" %></td>
        </tr>

        <tr>
            <th>BoxOffice</th>
            <td><%=currencyFormatter.format(peliculaSeleccionada.getBoxOffice()) %></td>
        </tr>

        <tr>
            <th>Genero</th>
            <td><%=peliculaSeleccionada.getGenero() %></td>
        </tr>

        <tr>
            <th>Actores</th>
            <td><a href="ActorServlet?idPelicula=<%=peliculaSeleccionada.getIdPelicula()%>">Ver actores</a></td>
        </tr>


    </table>
</body>
</html>