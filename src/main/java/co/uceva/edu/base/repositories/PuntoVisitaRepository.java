package co.uceva.edu.base.repositories;

import co.uceva.edu.base.models.PuntoVisita;
import co.uceva.edu.base.util.ConexionBaseDatos;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PuntoVisitaRepository {

    public boolean crear(PuntoVisita puntoVisita) {
        Connection con = null;
        PreparedStatement pst = null;
        try {
            con = ConexionBaseDatos.getConnection();
            pst = con.prepareStatement("INSERT INTO public.\"Punto Vista\" (id_actividad, nom_actividad, descripcion, estado, fech_modificacion, fech_creacion, id_departamento, id_ciudad) VALUES (?, ?, ?, ?, ?, ?, ?, ?)");
            pst.setInt(1, puntoVisita.getId_actividad());
            pst.setString(2, puntoVisita.getNom_actividad());
            pst.setString(3, puntoVisita.getDescripcion());
            pst.setString(4, puntoVisita.getEstado());
            pst.setString(5, puntoVisita.getFech_modificacion());
            pst.setString(6, puntoVisita.getFech_creacion());
            pst.setInt(7, puntoVisita.getId_departamento());
            pst.setInt(8, puntoVisita.getId_ciudad());
            pst.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
                return false;
            }
        }
        return true;
    }

    public List<PuntoVisita> consulta(Integer idPuntoVisita) {
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        List<PuntoVisita> listadoPuntoVisita = new ArrayList<>();
        try {
            con = ConexionBaseDatos.getConnection();
            pst = con.prepareStatement("SELECT * FROM public.\"Punto Vista\" WHERE id_actividad=?");
            pst.setInt(1, idPuntoVisita);
            rs = pst.executeQuery();
            while (rs.next()) {
                PuntoVisita puntoVisiti = new PuntoVisita();
                puntoVisiti.setId_actividad(rs.getInt("id_actividad"));
                puntoVisiti.setNom_actividad(rs.getString("nom_actividad"));
                puntoVisiti.setDescripcion(rs.getString("descripcion"));
                puntoVisiti.setEstado(rs.getString("estado"));
                puntoVisiti.setFech_modificacion(rs.getString("fech_modificacion"));
                puntoVisiti.setFech_creacion(rs.getString("fech_creacion"));
                puntoVisiti.setId_departamento(rs.getInt("id_departamento"));
                puntoVisiti.setId_ciudad(rs.getInt("id_ciudad"));

                listadoPuntoVisita.add(puntoVisiti);
            }

        } catch (Exception e) {
            e.printStackTrace();
            return listadoPuntoVisita;
        } finally {
            try {
                pst.close();
                rs.close();
                con.close();
            } catch (Exception e) {
                e.printStackTrace();
                return listadoPuntoVisita;
            }
        }
        return listadoPuntoVisita;
    }

    public List<PuntoVisita> listar() {
        List<PuntoVisita> listadoPuntoVisita = new ArrayList<>();
        Connection con = null;
        ResultSet rs = null;
        Statement st = null;
        try {
            con = ConexionBaseDatos.getConnection();
            st = con.createStatement();
            rs = st.executeQuery("SELECT * FROM public.\"Punto Vista\"");
            while (rs.next()) {
                PuntoVisita puntoVisita = new PuntoVisita();
                puntoVisita.setId_actividad(rs.getInt("id_actividad"));
                puntoVisita.setNom_actividad(rs.getString("nom_actividad"));
                puntoVisita.setDescripcion(rs.getString("descripcion"));
                puntoVisita.setEstado(rs.getString("estado"));
                puntoVisita.setFech_modificacion(rs.getString("fech_modificacion"));
                puntoVisita.setFech_creacion(rs.getString("fech_creacion"));
                puntoVisita.setId_departamento(rs.getInt("id_departamento"));
                puntoVisita.setId_ciudad(rs.getInt("id_ciudad"));
                listadoPuntoVisita.add(puntoVisita);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                rs.close();
                con.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return listadoPuntoVisita;
    }

    public boolean eliminar(int idPuntoVisita) {
        Connection con = null;
        PreparedStatement pst = null;
        try {
            con = ConexionBaseDatos.getConnection();
            pst = con.prepareStatement("DELETE FROM public.\"Punto Vista\" WHERE id_actividad=?");
            pst.setInt(1, idPuntoVisita);
            pst.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
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

    public boolean editar(PuntoVisita puntoVisita) {
        Connection con = null;
        PreparedStatement pst = null;
        try {
            con = ConexionBaseDatos.getConnection();
            pst = con.prepareStatement("UPDATE public.\"Punto Vista\" SET id_actividad=?, nom_actividad=?, descripcion=?, estado=?, fech_modificacion=?, fech_creacion=?, id_departamento=?, id_ciudad=? WHERE id_actividad=?");
            pst.setInt(1, puntoVisita.getId_actividad());
            pst.setString(2, puntoVisita.getNom_actividad());
            pst.setString(3, puntoVisita.getDescripcion());
            pst.setString(4, puntoVisita.getEstado());
            pst.setString(5, puntoVisita.getFech_modificacion());
            pst.setString(6, puntoVisita.getFech_creacion());
            pst.setInt(7, puntoVisita.getId_departamento());
            pst.setInt(8, puntoVisita.getId_ciudad());
            pst.setInt(9, puntoVisita.getId_actividad());
            pst.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
                return false;
            }
        }
        return true;
    }
}
