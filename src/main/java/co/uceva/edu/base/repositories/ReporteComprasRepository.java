package co.uceva.edu.base.repositories;

import co.uceva.edu.base.models.PuntoVisita;
import co.uceva.edu.base.models.ReporteCompras;
import co.uceva.edu.base.util.ConexionBaseDatos;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ReporteComprasRepository {

    public List<ReporteCompras> generarReporte(String mes) {
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        List<ReporteCompras> reporteComprasList = new ArrayList<>();

        try {
            con = ConexionBaseDatos.getConnection();
            // Ajusta la consulta según tu estructura de base de datos y necesidades específicas
            pst = con.prepareStatement("SELECT pv.*, COUNT(c.id_compra) as cantidad_compras " +
                    "FROM Punto Vista pv " +
                    "JOIN Compra_Diego c ON pv.id_actividad = c.id_actividad " +
                    "WHERE MONTH(c.fecha_compra) = ? " +
                    "GROUP BY pv.id_actividad, pv.nom_actividad, pv.descripcion, " +
                    "pv.estado, pv.fech_modificacion, pv.fech_creacion, " +
                    "pv.id_departamento, pv.id_ciudad");
            pst.setString(1, mes);
            rs = pst.executeQuery();

            while (rs.next()) {
                PuntoVisita puntoVisita = new PuntoVisita(
                        rs.getInt("id_actividad"),
                        rs.getString("nom_actividad"),
                        rs.getString("descripcion"),
                        rs.getString("estado"),
                        rs.getString("fech_modificacion"),
                        rs.getString("fech_creacion"),
                        rs.getInt("id_departamento"),
                        rs.getInt("id_ciudad")
                );

                int cantidadCompras = rs.getInt("cantidad_compras");

                ReporteCompras reporteCompras = new ReporteCompras(puntoVisita, cantidadCompras);
                reporteComprasList.add(reporteCompras);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                rs.close();
                pst.close();
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return reporteComprasList;
    }
}
