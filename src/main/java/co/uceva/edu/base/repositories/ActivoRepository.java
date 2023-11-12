package co.uceva.edu.base.repositories;

import co.uceva.edu.base.models.Activo;
import co.uceva.edu.base.util.ConexionBaseDatos;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ActivoRepository {


    public boolean crear(Activo acti){
        Connection con=null;
        PreparedStatement pst =null;
        try{
            con = ConexionBaseDatos.getConnection();
            pst = con.prepareStatement("INSERT INTO activo (id_planturistico,temporada_año,tarifa_vigente) VALUES(?,?,?)");
            pst.setInt(1,acti.getIdPlant());
            pst.setString(2,acti.getTemporada_año());
            pst.setString(3,acti.getTarifa_vigente());
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

    public List<Activo> consulta(Integer idPlant){
        Connection con=null;
        PreparedStatement pst =null;
        ResultSet rs =null;
        List<Activo> listadoActivo = new ArrayList<>();
        try{
            con = ConexionBaseDatos.getConnection();
            pst = con.prepareStatement("SELECT * FROM activo WHERE id_planturistico=?");
            pst.setInt(1,idPlant);
            rs  = pst.executeQuery();
            while(rs.next()){
                Activo activo = new Activo();
                activo.setIdPlant(rs.getInt("id_planturistico"));
                activo.setTemporada_año(rs.getString("temporada_año"));
                activo.setTarifa_vigente(rs.getString("tarifa_vigente"));
                listadoActivo.add(activo);
            }

        }catch (Exception e){
            e.printStackTrace();
            return listadoActivo;
        }finally {
            try {
                pst.close();
                rs.close();
                con.close();
            } catch (Exception e) {
                e.printStackTrace();
                return listadoActivo;
            }

        }
        return listadoActivo;

    }

    public List<Activo> listar(){
        List<Activo> listadoActivo = new ArrayList<>();
        Connection con=null;
        ResultSet rs =null;
        Statement st=null;
        try {
            con = ConexionBaseDatos.getConnection();
            st  = con.createStatement();
            rs  = st.executeQuery("SELECT * FROM activo");
            while(rs.next()){
                Activo activo = new Activo();
                activo.setIdPlant(rs.getInt("id_planturistico"));
                activo.setTemporada_año(rs.getString("temporada_año"));
                activo.setTarifa_vigente(rs.getString("tarifa_vigente"));
                listadoActivo.add(activo);
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
        return listadoActivo;
    }

    public boolean eliminar(int idPlant){
        Connection con=null;
        PreparedStatement pst =null;
        try{
            con = ConexionBaseDatos.getConnection();
            pst = con.prepareStatement("DELETE FROM activo WHERE id_planturistico=?");
            pst.setInt(1,idPlant);
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


    public boolean editar(Activo activo){
        Connection con=null;
        PreparedStatement pst =null;
        try{
            con = ConexionBaseDatos.getConnection();
            pst = con.prepareStatement("UPDATE activo set id_planturistico=?,temporada_año=?,tarifa_vigente=? where id_planturistico =?");
            pst.setInt(1,activo.getIdPlant());
            pst.setString(2,activo.getTemporada_año());
            pst.setString(3,activo.getTarifa_vigente());
            pst.setInt(4,activo.getIdPlant());
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
