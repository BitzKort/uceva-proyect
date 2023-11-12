package co.uceva.edu.base.repositories;

import co.uceva.edu.base.models.Actividad;
import co.uceva.edu.base.util.ConexionBaseDatos;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ActividadRepository {


    public boolean crear(Actividad actividad){
        Connection con=null;
        PreparedStatement pst =null;
        try{
            con = ConexionBaseDatos.getConnection();
            pst = con.prepareStatement("INSERT INTO actividades (id_planturistico,actividad,nombre_lugar) VALUES(?,?,?)");
            pst.setInt(1,actividad.getId());
            pst.setString(2,actividad.getPlan());
            pst.setString(3,actividad.getNombre_lugar());
            pst.executeUpdate();

        }catch (Exception e){
            e.printStackTrace();
            return false;
        }finally {
            try {
                //pst.close();
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
                return false;
            }

        }
        return true;

    }

    public List<Actividad> consulta(Integer id){
        Connection con=null;
        PreparedStatement pst =null;
        ResultSet rs =null;
        List<Actividad> listadoActividad = new ArrayList<>();
        try{
            con = ConexionBaseDatos.getConnection();
            pst = con.prepareStatement("SELECT * FROM actividades WHERE id_planturistico=?");
            pst.setInt(1,id);
            rs  = pst.executeQuery();
            while(rs.next()){
                Actividad actividad = new Actividad();
                actividad.setId(rs.getInt("id_planturistico"));
                actividad.setPlan(rs.getString("actividad"));
                actividad.setNombre_lugar(rs.getString("nombre_lugar"));
                listadoActividad.add(actividad);
            }

        }catch (Exception e){
            e.printStackTrace();
            return listadoActividad;
        }finally {
            try {
                pst.close();
                rs.close();
                con.close();
            } catch (Exception e) {
                e.printStackTrace();
                return listadoActividad;
            }

        }
        return listadoActividad;

    }

    public List<Actividad> listar(){
        List<Actividad> listadoActividad = new ArrayList<>();
        Connection con=null;
        ResultSet rs =null;
        Statement st=null;
        try {
            con = ConexionBaseDatos.getConnection();
            st  = con.createStatement();
            rs  = st.executeQuery("SELECT * FROM actividades");
            while(rs.next()){
                Actividad actividad = new Actividad();
                actividad.setId(rs.getInt("id_planturistico"));
                actividad.setPlan(rs.getString("actividad"));
                actividad.setNombre_lugar(rs.getString("nombre_lugar"));
                listadoActividad.add(actividad);
            }

        } catch ( Exception e) {
            e.printStackTrace();
        }finally {
            try {
                rs.close();
                con.close();
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
        return listadoActividad;
    }

    public boolean eliminar(int id){
        Connection con=null;
        PreparedStatement pst =null;
        try{
            con = ConexionBaseDatos.getConnection();
            pst = con.prepareStatement("DELETE FROM actividades WHERE id_planturistico=?");
            pst.setInt(1,id);
            pst.executeUpdate();

        }catch (Exception e){
            e.printStackTrace();
            return false;
        }finally {
            try {
                pst.close();
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
                return false;
            }

        }
        return true;

    }


    public boolean editar(Actividad actividad){
        Connection con=null;
        PreparedStatement pst =null;
        try{
            con = ConexionBaseDatos.getConnection();
            pst = con.prepareStatement("UPDATE actividades set id_planturistico=?,actividad=?,nombre_lugar=? where id_planturistico =?");
            pst.setInt(1,actividad.getId());
            pst.setString(2,actividad.getPlan());
            pst.setString(3,actividad.getNombre_lugar());
            pst.setInt(4,actividad.getId());
            pst.executeUpdate();

        }catch (Exception e){
            e.printStackTrace();
            return false;
        }finally {
            try {
                //pst.close();
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
                return false;
            }

        }
        return true;

    }
}
