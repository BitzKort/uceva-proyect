package co.uceva.edu.base.repositories;

import co.uceva.edu.base.models.CompraDiego;
import co.uceva.edu.base.util.ConexionBaseDatos;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CompraDiegoRepository {

    public boolean crear(CompraDiego compraDiego) {
        Connection con = null;
        PreparedStatement pst = null;
        try {
            con = ConexionBaseDatos.getConnection();
            pst = con.prepareStatement("INSERT INTO public.\"Compra_Diego\"(" +
                    "id_compra, id_cliente, id_vendedor, fech_creacion, total_planes, total_otros_cargos, total)" +
                    "VALUES (?, ?, ?, ?, ?, ?, ?);");
            pst.setInt(1, compraDiego.getId_compra());
            pst.setInt(2, compraDiego.getId_cliente());
            pst.setInt(3, compraDiego.getId_vendedor());
            pst.setString(4, compraDiego.getFech_creacion());
            pst.setInt(5, compraDiego.getTotal_planes());
            pst.setInt(6, compraDiego.getTotal_otros_cargos());
            pst.setInt(7, compraDiego.getTotal());
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

    public List<CompraDiego> consulta(Integer idCompra) {
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        List<CompraDiego> listadoCompras = new ArrayList<>();
        try {
            con = ConexionBaseDatos.getConnection();
            pst = con.prepareStatement("SELECT * FROM public.\"Compra_Diego\" WHERE id_compra=?");
            pst.setInt(1, idCompra);
            rs = pst.executeQuery();
            while (rs.next()) {
                CompraDiego compraDiego = new CompraDiego();
                compraDiego.setId_compra(rs.getInt("id_compra"));
                compraDiego.setId_cliente(rs.getInt("id_cliente"));
                compraDiego.setId_vendedor(rs.getInt("id_vendedor"));
                compraDiego.setFech_creacion(rs.getString("fech_creacion"));
                compraDiego.setTotal_planes(rs.getInt("total_planes"));
                compraDiego.setTotal_otros_cargos(rs.getInt("total_otros_cargos"));
                compraDiego.setTotal(rs.getInt("total"));

                listadoCompras.add(compraDiego);
            }

        } catch (Exception e) {
            e.printStackTrace();
            return listadoCompras;
        } finally {
            try {
                pst.close();
                rs.close();
                con.close();
            } catch (Exception e) {
                e.printStackTrace();
                return listadoCompras;
            }
        }
        return listadoCompras;
    }





    public List<CompraDiego> listar() {
        List<CompraDiego> listadoComprasDiego = new ArrayList<>();
        Connection con = null;
        ResultSet rs = null;
        Statement st = null;
        try {
            con = ConexionBaseDatos.getConnection();
            st = con.createStatement();
            rs = st.executeQuery("SELECT * FROM public.\"Compra_Diego\"");
            while (rs.next()) {
                CompraDiego compraDiego = new CompraDiego();
                compraDiego.setId_compra(rs.getInt("id_compra"));
                compraDiego.setId_cliente(rs.getInt("id_cliente"));
                compraDiego.setId_vendedor(rs.getInt("id_vendedor"));
                compraDiego.setFech_creacion(rs.getString("fech_creacion"));
                compraDiego.setTotal_planes(rs.getInt("total_planes"));
                compraDiego.setTotal_otros_cargos(rs.getInt("total_otros_cargos"));
                compraDiego.setTotal(rs.getInt("total"));

                listadoComprasDiego.add(compraDiego);
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
        return listadoComprasDiego;
    }

    public boolean eliminar(int id_compra) {
        Connection con = null;
        PreparedStatement pst = null;
        try {
            con = ConexionBaseDatos.getConnection();
            pst = con.prepareStatement("DELETE FROM public.\"Compra_Diego\" WHERE id_compra=?");
            pst.setInt(1, id_compra);
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

    public boolean editar(CompraDiego compraDiego) {
        Connection con = null;
        PreparedStatement pst = null;
        try {
            con = ConexionBaseDatos.getConnection();
            pst = con.prepareStatement("UPDATE public.\"Compra_Diego\"\n" +
                    "\tSET id_compra=?, id_cliente=?, id_vendedor=?, fech_creacion=?, total_planes=?, total_otros_cargos=?, total=?\n" +
                    "\tWHERE id_compra=?;");
            pst.setInt(1, compraDiego.getId_compra());
            pst.setInt(2, compraDiego.getId_cliente());
            pst.setInt(3, compraDiego.getId_vendedor());
            pst.setString(4, compraDiego.getFech_creacion());
            pst.setInt(5, compraDiego.getTotal_planes());
            pst.setInt(6, compraDiego.getTotal_otros_cargos());
            pst.setInt(7, compraDiego.getTotal());
            pst.setInt(8, compraDiego.getId_compra());
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
