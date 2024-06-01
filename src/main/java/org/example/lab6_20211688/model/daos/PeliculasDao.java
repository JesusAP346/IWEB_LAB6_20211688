package org.example.lab6_20211688.model.daos;

import org.example.lab6_20211688.model.beans.Pelicula;

import java.sql.*;
import java.util.ArrayList;

public class PeliculasDao {

    public ArrayList<Pelicula> listarPeliculas(){

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        String url = "jdbc:mysql://localhost:3306/mydb";
        String username = "root";
        String password = "root";

        String sql =
                "SELECT " +
                        "p.idPelicula AS idPelicula, " +
                        "p.titulo AS Titulo, " +
                        "p.director AS Director, " +
                        "p.anoPublicacion AS Año_Publicacion, " +
                        "p.rating AS Rating, " +
                        "p.boxOffice AS Box_Office, " +
                        "g.nombre AS Genero " +
                        "FROM " +
                        "Pelicula p " +
                        "JOIN " +
                        "Genero g ON p.idGenero = g.idGenero " +
                        "ORDER BY " +
                        "p.rating DESC, " +
                        "p.boxOffice DESC;";


        ArrayList<Pelicula> listaPeliculas = new ArrayList<Pelicula>();


        try(Connection conn = DriverManager.getConnection(url,username,password); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql);) {//usamos try con recursos

            while(rs.next()){
                Pelicula pelicula = new Pelicula();
                pelicula.setIdPelicula(rs.getInt(1));
                pelicula.setTitulo(rs.getString(2));
                pelicula.setDirector(rs.getString(3));
                pelicula.setAnoPublicacion(rs.getInt(4));
                pelicula.setRating(rs.getDouble(5));
                pelicula.setBoxOffice(rs.getDouble(6));
                pelicula.setGenero(rs.getString(7));
                listaPeliculas.add(pelicula);
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return listaPeliculas;
    }

    public Pelicula obtenerPeliculaDeLista(int id){
        ArrayList<Pelicula> listaPeliculas = listarPeliculas();
        Pelicula peliculaAMostrar = new Pelicula();

        for(Pelicula pelicula : listaPeliculas){
            if (pelicula.getIdPelicula() == id){
                peliculaAMostrar = pelicula;
            }
        }
        return peliculaAMostrar;
    }

    public ArrayList<Pelicula> listarPeliculasPorTitulo(String titulo) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        String url = "jdbc:mysql://localhost:3306/mydb";
        String username = "root";
        String password = "root";

        String sql =
                "SELECT " +
                        "p.idPelicula AS idPelicula, " +
                        "p.titulo AS Titulo, " +
                        "p.director AS Director, " +
                        "p.anoPublicacion AS Año_Publicacion, " +
                        "p.rating AS Rating, " +
                        "p.boxOffice AS Box_Office, " +
                        "g.nombre AS Genero " +
                        "FROM " +
                        "Pelicula p " +
                        "JOIN " +
                        "Genero g ON p.idGenero = g.idGenero " +
                        "WHERE " +
                        "p.titulo LIKE ? " + // Usamos LIKE para buscar coincidencias parciales del título
                        "ORDER BY " +
                        "p.rating DESC, " +
                        "p.boxOffice DESC;";

        ArrayList<Pelicula> listaPeliculas = new ArrayList<>();

        try (Connection conn = DriverManager.getConnection(url, username, password);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, "%" + titulo + "%");

            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    Pelicula pelicula = new Pelicula();
                    pelicula.setIdPelicula(rs.getInt(1));
                    pelicula.setTitulo(rs.getString(2));
                    pelicula.setDirector(rs.getString(3));
                    pelicula.setAnoPublicacion(rs.getInt(4));
                    pelicula.setRating(rs.getDouble(5));
                    pelicula.setBoxOffice(rs.getDouble(6));
                    pelicula.setGenero(rs.getString(7));
                    listaPeliculas.add(pelicula);
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return listaPeliculas;
    }




}
