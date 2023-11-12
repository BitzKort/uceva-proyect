package co.uceva.edu.base.repositories;

import co.uceva.edu.base.models.Vendedor;
import co.uceva.edu.base.util.ConexionBaseDatos;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class VendedorRepository {

    public boolean crear(Vendedor vendedor) {
        Connection con = null;
        PreparedStatement pst = null;
        try {
            con = ConexionBaseDatos.getConnection();
            pst = con.prepareStatement("INSERT INTO public.\"Vendedor\"(\n" +
                    "\tcedula_vendedor, nombre_vendedor, correo_electronico, username, password, fech_nacimiento, fech_modificacion, fech_creacion)\n" +
                    "\tVALUES (?, ?, ?, ?, ?, ?, ?, ?);");
            pst.setInt(1, vendedor.getCedula_vendedor());
            pst.setString(2, vendedor.getNombre_vendedor());
            pst.setString(3, vendedor.getCorreo_electronico());
            pst.setString(4, vendedor.getUsername());
            pst.setString(5, vendedor.getPassword());
            pst.setString(6, vendedor.getFech_nacimiento());
            pst.setString(7, vendedor.getFech_modificacion());
            pst.setString(8, vendedor.getFech_creacion());
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

    public List<Vendedor> consulta(Integer cedula_vendedor) {
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        List<Vendedor> listadoVendedor = new ArrayList<>();
        try {
            con = ConexionBaseDatos.getConnection();
            pst = con.prepareStatement("SELECT * FROM public.\"Vendedor\" WHERE cedula_vendedor=?");
            pst.setInt(1, cedula_vendedor);
            rs = pst.executeQuery();
            while (rs.next()) {
                Vendedor vendedor = new Vendedor();
                vendedor.setCedula_vendedor(rs.getInt("cedula_vendedor"));
                vendedor.setNombre_vendedor(rs.getString("nombre_vendedor"));
                vendedor.setCorreo_electronico(rs.getString("correo_electronico"));
                vendedor.setUsername(rs.getString("username"));
                vendedor.setPassword(rs.getString("password"));
                vendedor.setFech_nacimiento(rs.getString("fech_nacimiento"));
                vendedor.setFech_modificacion(rs.getString("fech_modificacion"));
                vendedor.setFech_creacion(rs.getString("fech_creacion"));

                listadoVendedor.add(vendedor);
            }

        } catch (Exception e) {
            e.printStackTrace();
            return listadoVendedor;
        } finally {
            try {
                pst.close();
                rs.close();
                con.close();
            } catch (Exception e) {
                e.printStackTrace();
                return listadoVendedor;
            }

        }
        return listadoVendedor;
    }

    public List<Vendedor> listar() {
        List<Vendedor> listadoVendedor = new ArrayList<>();
        Connection con = null;
        ResultSet rs = null;
        Statement st = null;
        try {
            con = ConexionBaseDatos.getConnection();
            st = con.createStatement();
            rs = st.executeQuery("SELECT * FROM public.\"Vendedor\"");
            while (rs.next()) {
                Vendedor vendedor = new Vendedor();
                vendedor.setCedula_vendedor(rs.getInt("cedula_vendedor"));
                vendedor.setNombre_vendedor(rs.getString("nombre_vendedor"));
                vendedor.setCorreo_electronico(rs.getString("correo_electronico"));
                vendedor.setUsername(rs.getString("username"));
                vendedor.setPassword(rs.getString("password"));
                vendedor.setFech_nacimiento(rs.getString("fech_nacimiento"));
                vendedor.setFech_modificacion(rs.getString("fech_modificacion"));
                vendedor.setFech_creacion(rs.getString("fech_creacion"));

                listadoVendedor.add(vendedor);
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
        return listadoVendedor;
    }

    public boolean eliminar(int cedula_vendedor) {
        Connection con = null;
        PreparedStatement pst = null;
        try {
            con = ConexionBaseDatos.getConnection();
            pst = con.prepareStatement("DELETE FROM public.\"Vendedor\" WHERE cedula_vendedor=?");
            pst.setInt(1, cedula_vendedor);
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

    public boolean editar(Vendedor vendedor) {
        Connection con = null;
        PreparedStatement pst = null;
        try {
            con = ConexionBaseDatos.getConnection();
            pst = con.prepareStatement("UPDATE public.\"Vendedor\" SET cedula_vendedor=?, nombre_vendedor=?, correo_electronico=?, username=?, password=?, fech_nacimiento=?, fech_modificacion=?, fech_creacion=? WHERE cedula_vendedor=?");
            pst.setInt(1, vendedor.getCedula_vendedor());
            pst.setString(2, vendedor.getNombre_vendedor());
            pst.setString(3, vendedor.getCorreo_electronico());
            pst.setString(4, vendedor.getUsername());
            pst.setString(5, vendedor.getPassword());
            pst.setString(6, vendedor.getFech_nacimiento());
            pst.setString(7, vendedor.getFech_modificacion());
            pst.setString(8, vendedor.getFech_creacion());
            pst.setInt(9, vendedor.getCedula_vendedor());
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
