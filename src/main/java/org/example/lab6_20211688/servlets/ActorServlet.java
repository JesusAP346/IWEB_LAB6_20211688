package org.example.lab6_20211688.servlets;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.example.lab6_20211688.model.beans.Actor;
import org.example.lab6_20211688.model.daos.ActorDao;
import org.example.lab6_20211688.model.daos.PeliculasDao;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "ActorServlet", value = "/ActorServlet")
public class ActorServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PeliculasDao peliculasDao = new PeliculasDao();
        ActorDao actorDao = new ActorDao();


        String idPeliculaStr = request.getParameter("idPelicula");//obtenemos el idPelicula de la listaPeliculas.jsp
        ArrayList<Actor> listaActores = actorDao.listarActores(Integer.parseInt(idPeliculaStr));//creamos una lista con los actores
        String nombrePelicula = peliculasDao.obtenerPeliculaDeLista(Integer.parseInt(idPeliculaStr)).getTitulo();


        String vista = "listaActores.jsp";
        request.setAttribute("lista", listaActores);//mandamos la lista de peliculas a la vista .jsp
        request.setAttribute("nombrePelicula", nombrePelicula);//mandamos el nombre de la pelicula a la vista .jsp
        RequestDispatcher rd = request.getRequestDispatcher(vista);
        rd.forward(request,response);//vista comienza  a correr

    }

}
