<%--
  Created by IntelliJ IDEA.
  User: Pc
  Date: 31/05/2024
  Time: 16:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<jsp:useBean id="lista" scope="request" type="ArrayList<Pelicula>"/><%-- Obtengo la lista de películas--%>
<%@ page import="org.example.lab6_20211688.model.beans.Pelicula" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.io.PrintWriter" %>
<%@ page import="java.text.NumberFormat" %>
<%@ page import="java.util.Locale" %>




<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Peliculas</title>
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

<h1>Lista de Películas</h1>

<form action="PeliculaServlet" method="GET">
    <input type="text" id="busqueda" name="busqueda" required  placeholder="Buscar pelicula..." >
    <button type="submit">Buscar</button>
</form>


<table>
    <thead>
    <tr>
        <th>Titulo</th>
        <th>Director</th>
        <th>Ano Publicacion</th>
        <th>Rating</th>
        <th>BoxOffice</th>
        <th>Genero</th>
        <th>Actores</th>
    </tr>
    </thead>
    <tbody>


    <% NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(Locale.US);%>

    <%for(Pelicula pelicula : lista){ %>
    <tr>
        <td><a href="DetallesServlet?idPelicula=<%=pelicula.getIdPelicula()%>"><%=pelicula.getTitulo() %></a></td>
        <td><%=pelicula.getDirector() %></td>
        <td><%=pelicula.getAnoPublicacion() %></td>
        <td><%=pelicula.getRating() + "/10" %></td>
        <td><%=currencyFormatter.format(pelicula.getBoxOffice()) %></td>
        <td><%=pelicula.getGenero() %></td>
        <td><a href="ActorServlet?idPelicula=<%=pelicula.getIdPelicula()%>">Ver actores</a></td>
    </tr>
    <% } %>


    </tbody>
</table>
</body>
</html>
