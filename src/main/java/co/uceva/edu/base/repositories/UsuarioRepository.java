package co.uceva.edu.base.repositories;

import co.uceva.edu.base.models.Usuario;
import co.uceva.edu.base.util.ConexionBaseDatos;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UsuarioRepository {


    public Usuario autenticar(String correo, String password){
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        Usuario usuario = null;

        try{
            con = ConexionBaseDatos.getConnection();
            pst = con.prepareStatement("SELECT * FROM usuarios WHERE correo=? AND password=? ");
            pst.setString(1,correo);
            pst.setString(2,password);
            rs  = pst.executeQuery();



            while(rs.next()){
                usuario = new Usuario();
                usuario.setId(rs.getInt("id"));
                usuario.setNombre(rs.getString("nombre"));
                //usuario.setDepartamento(rs.getString("departamento"));
                //usuario.setSalario(rs.getInt("salario"));
                //listadousuario.add(usuario);
            }

        }catch (Exception e){
            e.printStackTrace();
            return usuario;
        }finally {
            try {
                pst.close();
                rs.close();
                con.close();
            } catch (Exception e) {
                e.printStackTrace();
                return usuario;
            }

        }
        return usuario;

    }

    /*

    CREAR - Statement incompleto: Da error org.postgresql.util.PSQLException: The column name id was not found in this ResultSet.

    */


    public boolean crear(Usuario usuario){
        Connection con=null;
        PreparedStatement pst =null;
        try{
            con = ConexionBaseDatos.getConnection();
            pst = con.prepareStatement("INSERT INTO usuarios (id,nombre,departamento,salario) VALUES(?,?,?,?)");
            pst.setInt(1,usuario.getId());
            pst.setString(2,usuario.getNombre());
            //pst.setString(3,usuario.getDepartamento());
            //pst.setInt(4,usuario.getSalario());
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

    public List<Usuario> consulta(Integer id){
        Connection con=null;
        PreparedStatement pst =null;
        ResultSet rs =null;
        List<Usuario> listadoUsuario = new ArrayList<>();
        try{
            con = ConexionBaseDatos.getConnection();
            pst = con.prepareStatement("SELECT * FROM usuarios WHERE id=?");
            pst.setInt(1,id);
            rs  = pst.executeQuery();
            while(rs.next()){
                Usuario usuario = new Usuario();
                usuario.setId(rs.getInt("id"));
                usuario.setNombre(rs.getString("nombre"));
               // usuario.setDepartamento(rs.getString("departamento"));
                //usuario.setSalario(rs.getInt("salario"));
                listadoUsuario.add(usuario);
            }

        }catch (Exception e){
            e.printStackTrace();
            return listadoUsuario;
        }finally {
            try {
                pst.close();
                rs.close();
                con.close();
            } catch (Exception e) {
                e.printStackTrace();
                return listadoUsuario;
            }

        }
        return listadoUsuario;

    }

    public List<Usuario> listar(){
        List<Usuario> listadoUsuario = new ArrayList<>();
        Connection con=null;
        ResultSet rs =null;
        Statement st=null;
        try {
            con = ConexionBaseDatos.getConnection();
            st  = con.createStatement();
            rs  = st.executeQuery("SELECT * FROM usuarios");
            while(rs.next()){
                Usuario usuario = new Usuario();
                usuario.setId(rs.getInt("id"));
                usuario.setNombre(rs.getString("nombre"));
               //usuario.setDepartamento(rs.getString("departamento"));
                //usuario.setSalario(rs.getInt("salario"));
                listadoUsuario.add(usuario);
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
        return listadoUsuario;
    }

    public boolean eliminar(int id){
        Connection con=null;
        PreparedStatement pst =null;
        try{
            con = ConexionBaseDatos.getConnection();
            pst = con.prepareStatement("DELETE FROM usuarios WHERE id=?");
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

}
