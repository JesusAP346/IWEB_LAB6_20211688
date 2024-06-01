package org.example.lab6_20211688.servlets;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.example.lab6_20211688.model.beans.Pelicula;
import org.example.lab6_20211688.model.daos.PeliculasDao;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "PeliculaServlet", value = "/PeliculaServlet")
public class PeliculaServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");


        PeliculasDao peliculasDao = new PeliculasDao();
        ArrayList<Pelicula> listaPeliculas ;

        String busquedaIngresadaDeTitulo = request.getParameter("busqueda");
        if (busquedaIngresadaDeTitulo != null && !busquedaIngresadaDeTitulo.isEmpty()) {
            listaPeliculas = peliculasDao.listarPeliculasPorTitulo(busquedaIngresadaDeTitulo);
        } else { 
            listaPeliculas = peliculasDao.listarPeliculas();//creamos una lista con las peliculas
        }


        String vista = "listaPeliculas.jsp";
        request.setAttribute("lista",listaPeliculas);//mandamos la lista de peliculas a la vista .jsp



        RequestDispatcher rd = request.getRequestDispatcher(vista);
        rd.forward(request,response);//vista comienza  a correr
    }


}
