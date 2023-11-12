package co.uceva.edu.base.services;

import co.uceva.edu.base.models.Usuario;
import co.uceva.edu.base.repositories.UsuarioRepository;

import java.util.List;

public class UsuarioService {

    UsuarioRepository usuarioRepository;

    public UsuarioService() {
        usuarioRepository = new UsuarioRepository();
    }
    public Usuario autenticar(String correo, String password){
        return usuarioRepository.autenticar(correo, password);
    }
    public List<Usuario> listar(){
        return usuarioRepository.listar();
    }

    public boolean crear(Usuario usuario){
        if(usuarioRepository.consulta(usuario.getId()).size() > 0){
            return false;
        }else{
            return usuarioRepository.crear(usuario);
        }
    }

    public boolean eliminar(int id) {
        return usuarioRepository.eliminar(id);
    }
}
