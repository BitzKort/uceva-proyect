package co.uceva.edu.base.repositories;

import co.uceva.edu.base.models.Cliente;
import co.uceva.edu.base.util.ConexionBaseDatos;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClienteRepository {

    public boolean crear(Cliente cliente) {
        Connection con = null;
        PreparedStatement pst = null;
        try {
            con = ConexionBaseDatos.getConnection();
            pst = con.prepareStatement("INSERT INTO public.\"Cliente\"(" +
                    "cedula_cliente, nombre_cliente, correo_electronico, tel_pers_contact, quien_creo, nom_pers_contact, fech_nacimiento, fech_modificacion, fech_creacion, cedula_vendedor)" +
                    "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?);");
            pst.setInt(1, cliente.getCedula_cliente());
            pst.setString(2, cliente.getNombre_cliente());
            pst.setString(3, cliente.getCorreo_electronico());
            pst.setLong(4, cliente.getTel_pers_contact());
            pst.setString(5, cliente.getQuien_creo());
            pst.setString(6, cliente.getNom_pers_contact());
            pst.setDate(7, cliente.getFech_nacimiento());
            pst.setDate(8, cliente.getFech_modificacion());
            pst.setDate(9, cliente.getFech_creacion());
            pst.setInt(10, cliente.getCedula_vendedor());
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

    public List<Cliente> consulta(Integer cedula_cliente) {
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        List<Cliente> listadoCliente = new ArrayList<>();
        try {
            con = ConexionBaseDatos.getConnection();
            pst = con.prepareStatement("SELECT * FROM public.\"Cliente\" WHERE cedula_cliente=?");
            pst.setInt(1, cedula_cliente);
            rs = pst.executeQuery();
            while (rs.next()) {
                Cliente cliente = new Cliente();
                cliente.setCedula_cliente(rs.getInt("cedula_cliente"));
                cliente.setNombre_cliente(rs.getString("nombre_cliente"));
                cliente.setCorreo_electronico(rs.getString("correo_electronico"));
                cliente.setTel_pers_contact(rs.getLong("tel_pers_contact"));
                cliente.setQuien_creo(rs.getString("quien_creo"));
                cliente.setNom_pers_contact(rs.getString("nom_pers_contact"));
                cliente.setFech_nacimiento(Date.valueOf(rs.getString("fech_nacimiento")));
                cliente.setFech_modificacion(Date.valueOf(rs.getString("fech_modificacion")));
                cliente.setFech_creacion(Date.valueOf(rs.getString("fech_creacion")));
                cliente.setCedula_vendedor(rs.getInt("cedula_vendedor"));

                listadoCliente.add(cliente);
            }

        } catch (Exception e) {
            e.printStackTrace();
            return listadoCliente;
        } finally {
            try {
                pst.close();
                rs.close();
                con.close();
            } catch (Exception e) {
                e.printStackTrace();
                return listadoCliente;
            }
        }
        return listadoCliente;
    }

    public List<Cliente> listar() {
        List<Cliente> listadoCliente = new ArrayList<>();
        Connection con = null;
        ResultSet rs = null;
        Statement st = null;
        try {
            con = ConexionBaseDatos.getConnection();
            st = con.createStatement();
            rs = st.executeQuery("SELECT * FROM public.\"Cliente\"");
            while (rs.next()) {
                Cliente cliente = new Cliente();
                cliente.setCedula_cliente(rs.getInt("cedula_cliente"));
                cliente.setNombre_cliente(rs.getString("nombre_cliente"));
                cliente.setCorreo_electronico(rs.getString("correo_electronico"));
                cliente.setTel_pers_contact(rs.getLong("tel_pers_contact"));
                cliente.setQuien_creo(rs.getString("quien_creo"));
                cliente.setNom_pers_contact(rs.getString("nom_pers_contact"));
                cliente.setFech_nacimiento(Date.valueOf(rs.getString("fech_nacimiento")));
                cliente.setFech_modificacion(Date.valueOf(rs.getString("fech_modificacion")));
                cliente.setFech_creacion(Date.valueOf(rs.getString("fech_creacion")));
                cliente.setCedula_vendedor(rs.getInt("cedula_vendedor"));

                listadoCliente.add(cliente);
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
        return listadoCliente;
    }

    public boolean eliminar(int cedula_cliente) {
        Connection con = null;
        PreparedStatement pst = null;
        try {
            con = ConexionBaseDatos.getConnection();
            pst = con.prepareStatement("DELETE FROM public.\"Cliente\" WHERE cedula_cliente=?");
            pst.setInt(1, cedula_cliente);
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

    public boolean editar(Cliente cliente) {
        Connection con = null;
        PreparedStatement pst = null;
        try {
            con = ConexionBaseDatos.getConnection();
            pst = con.prepareStatement("UPDATE public.\"Cliente\" SET cedula_cliente=?, nombre_cliente=?, correo_electronico=?, tel_pers_contact=?, quien_creo=?, nom_pers_contact=?, fech_nacimiento=?, fech_modificacion=?, fech_creacion=?, cedula_vendedor=? WHERE cedula_cliente=?");
            pst.setInt(1, cliente.getCedula_cliente());
            pst.setString(2, cliente.getNombre_cliente());
            pst.setString(3, cliente.getCorreo_electronico());
            pst.setLong(4, cliente.getTel_pers_contact());
            pst.setString(5, cliente.getQuien_creo());
            pst.setString(6, cliente.getNom_pers_contact());
            pst.setDate(7, cliente.getFech_nacimiento());
            pst.setDate(8, cliente.getFech_modificacion());
            pst.setDate(9, cliente.getFech_creacion());
            pst.setInt(10, cliente.getCedula_vendedor());
            pst.setInt(11, cliente.getCedula_cliente());
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

