package co.uceva.edu.base.repositories;

import co.uceva.edu.base.models.PlanTuristico;
import co.uceva.edu.base.util.ConexionBaseDatos;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PlanTuristicoRepository {

    public boolean crear(PlanTuristico planTuristico) {
        Connection con = null;
        PreparedStatement pst = null;
        try {
            con = ConexionBaseDatos.getConnection();
            pst = con.prepareStatement("INSERT INTO public.\"Plan Turistico\"(\n" +
                    "\t\"id_plan_turistico\", titulo, descripcion, \"fech_creacion\", \"fech_modificacion\", \"cant_dias\", estado, alimentacion)\n" +
                    "\tVALUES (?, ?, ?, ?, ?, ?, ?, ?);");
            pst.setInt(1, planTuristico.getId_plan_turistico());
            pst.setString(2, planTuristico.getTitulo());
            pst.setString(3, planTuristico.getDescripcion());
            pst.setString(4, planTuristico.getFech_creacion());
            pst.setString(5, planTuristico.getFech_modificacion());
            pst.setInt(6, planTuristico.getCant_dias());
            pst.setString(7, planTuristico.getEstado());
            pst.setString(8, planTuristico.getAlimentacion());
            pst.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
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

    public List<PlanTuristico> consulta(Integer idPlanTuristico) {
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        List<PlanTuristico> listadoPlanTuristico = new ArrayList<>();
        try {
            con = ConexionBaseDatos.getConnection();
            pst = con.prepareStatement("SELECT * FROM public.\"Plan Turistico\" WHERE id_plan_turistico=?");
            pst.setInt(1, idPlanTuristico);
            rs = pst.executeQuery();
            while (rs.next()) {
                PlanTuristico planTuristico = new PlanTuristico();
                planTuristico.setId_plan_turistico(rs.getInt("id_plan_turistico"));
                planTuristico.setTitulo(rs.getString("titulo"));
                planTuristico.setDescripcion(rs.getString("descripcion"));
                planTuristico.setFech_creacion(rs.getString("fech_creacion"));
                planTuristico.setFech_modificacion(rs.getString("fech_modificacion"));
                planTuristico.setCant_dias(rs.getInt("cant_dias"));
                planTuristico.setEstado(rs.getString("estado"));
                planTuristico.setAlimentacion(rs.getString("alimentacion"));
                listadoPlanTuristico.add(planTuristico);
            }

        } catch (Exception e) {
            e.printStackTrace();
            return listadoPlanTuristico;
        } finally {
            try {
                pst.close();
                rs.close();
                con.close();
            } catch (Exception e) {
                e.printStackTrace();
                return listadoPlanTuristico;
            }
        }
        return listadoPlanTuristico;
    }

    public List<PlanTuristico> listar() {
        List<PlanTuristico> listadoPlanTuristico = new ArrayList<>();
        Connection con = null;
        ResultSet rs = null;
        Statement st = null;
        try {
            con = ConexionBaseDatos.getConnection();
            st = con.createStatement();
            rs = st.executeQuery("SELECT * FROM public.\"Plan Turistico\"");
            while (rs.next()) {
                PlanTuristico planTuristico = new PlanTuristico();
                planTuristico.setId_plan_turistico(rs.getInt("id_plan_turistico"));
                planTuristico.setTitulo(rs.getString("titulo"));
                planTuristico.setDescripcion(rs.getString("descripcion"));
                planTuristico.setFech_creacion(rs.getString("fech_creacion"));
                planTuristico.setFech_modificacion(rs.getString("fech_modificacion"));
                planTuristico.setCant_dias(rs.getInt("cant_dias"));
                planTuristico.setEstado(rs.getString("estado"));
                planTuristico.setAlimentacion(rs.getString("alimentacion"));
                listadoPlanTuristico.add(planTuristico);
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
        return listadoPlanTuristico;
    }

    public boolean eliminar(int idPlanTuristico) {
        Connection con = null;
        PreparedStatement pst = null;
        try {
            con = ConexionBaseDatos.getConnection();
            pst = con.prepareStatement("DELETE FROM public.\"Plan Turistico\" WHERE id_plan_turistico=?");
            pst.setInt(1, idPlanTuristico);
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

    public boolean editar(PlanTuristico planTuristico) {
        Connection con = null;
        PreparedStatement pst = null;
        try {
            con = ConexionBaseDatos.getConnection();
            pst = con.prepareStatement("UPDATE public.\"Plan Turistico\" SET titulo=?, descripcion=?, \"fech_creacion\"=?, " +
                    "\"fech_modificacion\"=?, \"cant_dias\"=?, estado=?, alimentacion=? WHERE id_plan_turistico=?");
            pst.setString(1, planTuristico.getTitulo());
            pst.setString(2, planTuristico.getDescripcion());
            pst.setString(3, planTuristico.getFech_creacion());
            pst.setString(4, planTuristico.getFech_modificacion());
            pst.setInt(5, planTuristico.getCant_dias());
            pst.setString(6, planTuristico.getEstado());
            pst.setString(7, planTuristico.getAlimentacion());
            pst.setInt(8, planTuristico.getId_plan_turistico());
            pst.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
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
