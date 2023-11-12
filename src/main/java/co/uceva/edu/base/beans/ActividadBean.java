package co.uceva.edu.base.beans;

import co.uceva.edu.base.models.Actividad;
import co.uceva.edu.base.services.ActividadService;

import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@SessionScoped
public class ActividadBean implements Serializable {

    private ActividadService actividadService;
    private Actividad actividad;

    public ActividadBean() {
        actividadService = new ActividadService();
        this.actividad= new Actividad();
    }

    public Actividad getActividad() {
        return actividad;
    }

    public void setActividad(Actividad actividad) {
        this.actividad = actividad;
    }



    public List<Actividad> listar(){
        return actividadService.listar();
    }

    public String irCrear(){
        return "crear-actividades.xhtml?faces-redirect=true";
    }

    public String irEditar(Integer id){
        System.out.println(id);
        this.actividad = actividadService.consulta(id).get(0);
        return "modificar-actividades.xhtml?faces-redirect=true";
    }

    public String crear(){

        if(actividadService.crear(this.actividad)){
            System.out.println("Creado Exitosamente");
            return "listar-actividades.xhtml?faces-redirect=true";
        }else{
            FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_WARN,"Error Guardando","Error Guardando");
            FacesContext.getCurrentInstance().addMessage("",mensaje);
            return "";
        }
    }

    public String eliminar(int id){
        System.out.println("Eliminando "+id);
        if (actividadService.eliminar(id)){
            System.out.println("Eliminado Exitosamente");
            return "listar-actividades.xhtml?faces-redirect=true";
        }else {
            FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_WARN,"Error Eliminado", "Error Eliminando");
            FacesContext.getCurrentInstance().addMessage("",mensaje);
            return "";
        }

    }


    public String editar(){
        if (actividadService.editar(this.actividad)){
            System.out.println("Actualizado Exitosamente");
            return "listar-actividades.xhtml?faces-redirect=true";
        }else {
            FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_WARN,"Error Actualizar", "Error Actualizando");
            FacesContext.getCurrentInstance().addMessage("",mensaje);
            return "";
        }
    }



    public String devolverse(){
        if (actividadService.editar(this.actividad)){
            System.out.println("Actualizado Exitosamente");
            return "index.html?faces-redirect=true";
        }else {
            FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_WARN,"Error Actualizar", "Error Actualizando");
            FacesContext.getCurrentInstance().addMessage("",mensaje);
            return "";
        }
    }


    public String devolverEditar(){
        if (actividadService.editar(this.actividad)){
            System.out.println("Actualizado Exitosamente");
            return "listar-actividades.xhtml?faces-redirect=true";
        }else {
            FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_WARN,"Error Actualizar", "Error Actualizando");
            FacesContext.getCurrentInstance().addMessage("",mensaje);
            return "";
        }
    }
}
