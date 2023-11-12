package co.uceva.edu.base.beans;

import co.uceva.edu.base.models.Usuario;
import co.uceva.edu.base.services.UsuarioService;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

@Named
@RequestScoped
public class UsuarioBean {

    private UsuarioService usuarioService;
    private Usuario usuario;

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public void setCorreo(String correo){
        this.usuario.setCorreo(correo);
    }

    public UsuarioBean() {
        usuarioService = new UsuarioService();
        usuario = new Usuario();
    }

    public String autenticar(){
        System.out.println(usuario.getCorreo());
        System.out.println(usuario.getPassword());
        System.out.println("Autenticar----------------------------------------------------------------------------------");
        usuario = this.usuarioService.autenticar(this.usuario.getCorreo(),this.usuario.getPassword());
        //System.out.println(usuario.getId());
        if (usuario == null){
            FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_WARN,"Error Al Autenticar", "Error Autenticando");
            FacesContext.getCurrentInstance().addMessage("",mensaje);
            System.out.println("DATOS INCORRECTOS");
            return "";
        }else {
            FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_WARN,"Autenticado ", "Autenticado con exito");
            FacesContext.getCurrentInstance().addMessage("",mensaje);
            return "index.html?faces-redirect=true";
        }
       // System.out.println(usuario.getNombre());


    }
}
