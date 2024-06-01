package org.example.lab6_20211688.model.daos;

import org.example.lab6_20211688.model.beans.Actor;

import java.sql.*;
import java.util.ArrayList;

public class ActorDao {
    public ArrayList<Actor> listarActores(int idPel){

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        String url = "jdbc:mysql://localhost:3306/mydb";
        String username = "root";
        String password = "root";

        // ID de la película


        String sql = "SELECT " +
                "Actor.idActor, " +
                "Actor.Nombre, " +
                "Actor.Apellido, " +
                "Actor.anoNacimiento, " +
                "Actor.premioOscar " +
                "FROM " +
                "Pelicula " +
                "JOIN " +
                "Protagonistas ON Pelicula.idPelicula = Protagonistas.idPelicula " +
                "JOIN " +
                "Actor ON Protagonistas.idActor = Actor.idActor " +
                "WHERE " +
                "Pelicula.idPelicula = " + idPel + ";";




        ArrayList<Actor> listaActores = new ArrayList<Actor>();


        try(Connection conn = DriverManager.getConnection(url,username,password); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql);) {//usamos try con recursos

            while(rs.next()){
                Actor actor = new Actor();
                actor.setIdActor(rs.getInt(1));
                actor.setNombre(rs.getString(2));
                actor.setApellido(rs.getString(3));
                actor.setAnhoNacimiento(rs.getInt(4));
                actor.setGanadorPremioOscar(rs.getInt(5));

                listaActores.add(actor);
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return listaActores;
    }
}
