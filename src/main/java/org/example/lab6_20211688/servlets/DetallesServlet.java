package org.example.lab6_20211688.servlets;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.example.lab6_20211688.model.beans.Pelicula;
import org.example.lab6_20211688.model.daos.PeliculasDao;

import java.io.IOException;

@WebServlet(name = "DetallesServlet", value = "/DetallesServlet")
public class DetallesServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        PeliculasDao peliculasDao = new PeliculasDao();
        String idPeliculaStr = request.getParameter("idPelicula");//obtenemos el idPelicula de la listaPeliculas.jsp
        Pelicula peliculaSeleccionada = peliculasDao.obtenerPeliculaDeLista(Integer.parseInt(idPeliculaStr));

        //mandamos el objeto pelicula
        request.setAttribute("peliculaSeleccionada",peliculaSeleccionada);

        String vista = "viewPelicula.jsp";
        RequestDispatcher rd = request.getRequestDispatcher(vista);
        rd.forward(request,response);

    }

}
