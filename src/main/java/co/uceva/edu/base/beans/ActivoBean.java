package co.uceva.edu.base.beans;

import co.uceva.edu.base.models.Activo;
import co.uceva.edu.base.services.ActivoService;

import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@SessionScoped
public class ActivoBean implements Serializable {

    private ActivoService activoService;
    private Activo activo;

    public ActivoBean() {
        activoService = new ActivoService();
        this.activo= new Activo();
    }

    public Activo getActivo() {
        return activo;
    }

    public void setActivo(Activo activo) {
        this.activo = activo;
    }



    public List<Activo> listar(){
        return activoService.listar();
    }

    public String irCrear(){
        return "crear-activos.xhtml?faces-redirect=true";
    }

    public String irEditar(Integer id){
        System.out.println(id);
        this.activo = activoService.consulta(id).get(0);
        return "modificar-activos.xhtml?faces-redirect=true";
    }

    public String crear(){

        if(activoService.crear(this.activo)){
            System.out.println("Creado Exitosamente");
            return "listar-activos.xhtml?faces-redirect=true";
        }else{
            FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_WARN,"Error Guardando","Error Guardando");
            FacesContext.getCurrentInstance().addMessage("",mensaje);
            return "";
        }
    }

    public String eliminar(int id){
        System.out.println("Eliminando "+id);
        if (activoService.eliminar(id)){
            System.out.println("Eliminado Exitosamente");
            return "listar-activos.xhtml?faces-redirect=true";
        }else {
            FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_WARN,"Error Eliminado", "Error Eliminando");
            FacesContext.getCurrentInstance().addMessage("",mensaje);
            return "";
        }

    }


    public String editar(){
        if (activoService.editar(this.activo)){
            System.out.println("Actualizado Exitosamente");
            return "listar-activos.xhtml?faces-redirect=true";
        }else {
            FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_WARN,"Error Actualizar", "Error Actualizando");
            FacesContext.getCurrentInstance().addMessage("",mensaje);
            return "";
        }
    }


    public String devolverse(){
        if (activoService.editar(this.activo)){
            System.out.println("Actualizado Exitosamente");
            return "index.html?faces-redirect=true";
        }else {
            FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_WARN,"Error Actualizar", "Error Actualizando");
            FacesContext.getCurrentInstance().addMessage("",mensaje);
            return "";
        }
    }

    public String devolverEditar(){
        if (activoService.editar(this.activo)){
            System.out.println("Actualizado Exitosamente");
            return "listar-activos.xhtml?faces-redirect=true";
        }else {
            FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_WARN,"Error Actualizar", "Error Actualizando");
            FacesContext.getCurrentInstance().addMessage("",mensaje);
            return "";
        }
    }
}







