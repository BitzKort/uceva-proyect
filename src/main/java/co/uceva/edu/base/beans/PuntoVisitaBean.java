package co.uceva.edu.base.beans;

import co.uceva.edu.base.models.PuntoVisita;
import co.uceva.edu.base.services.PuntoVisitaService;

import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@SessionScoped
public class PuntoVisitaBean implements Serializable {


    private PuntoVisitaService puntoVisitaService;
    private PuntoVisita puntoVisita;

    public PuntoVisitaBean() {
        puntoVisitaService = new PuntoVisitaService();
        this.puntoVisita = new PuntoVisita();
    }

    public PuntoVisita getPuntoVisita() {
        return puntoVisita;
    }

    public void setPuntoVisita(PuntoVisita puntoVisita) {
        this.puntoVisita = puntoVisita;
    }

    public List<PuntoVisita> listar() {
        return puntoVisitaService.listar();
    }

    public String irCrear() {
        return "crear-puntosVisitas.xhtml?faces-redirect=true";
    }

    public String irEditar(Integer id_actividad) {
        System.out.println(id_actividad);
        this.puntoVisita = puntoVisitaService.consulta(id_actividad).get(0);
        return "modificar-puntosVisitas.xhtml?faces-redirect=true";
    }

    public String crear() {
        if (puntoVisitaService.crear(this.puntoVisita)) {
            System.out.println("Creado Exitosamente");
            return "listar-puntosVisitas.xhtml?faces-redirect=true";
        } else {
            FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_WARN, "Error Guardando", "Error Guardando");
            FacesContext.getCurrentInstance().addMessage("", mensaje);
            return "";
        }
    }

    public String eliminar(int id_actividad) {
        System.out.println("Eliminando " + id_actividad);
        if (puntoVisitaService.eliminar(id_actividad)) {
            System.out.println("Eliminado Exitosamente");
            return "listar-puntosVisitas.xhtml?faces-redirect=true";
        } else {
            FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_WARN, "Error Eliminado", "Error Eliminando");
            FacesContext.getCurrentInstance().addMessage("", mensaje);
            return "";
        }
    }

    public String editar() {
        if (puntoVisitaService.editar(this.puntoVisita)) {
            System.out.println("Actualizado Exitosamente");
            return "listar-puntosVisitas.xhtml?faces-redirect=true";
        } else {
            FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_WARN, "Error Actualizar", "Error Actualizando");
            FacesContext.getCurrentInstance().addMessage("", mensaje);
            return "";
        }
    }

    public String devolverse() {
        if (puntoVisitaService.editar(this.puntoVisita)) {
            System.out.println("Actualizado Exitosamente");
            return "index.html?faces-redirect=true";
        } else {
            FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_WARN, "Error Actualizar", "Error Actualizando");
            FacesContext.getCurrentInstance().addMessage("", mensaje);
            return "";
        }
    }

    public String devolverEditar() {
        if (puntoVisitaService.editar(this.puntoVisita)) {
            System.out.println("Actualizado Exitosamente");
            return "listar-puntosVisitas.xhtml?faces-redirect=true";
        } else {
            FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_WARN, "Error Actualizar", "Error Actualizando");
            FacesContext.getCurrentInstance().addMessage("", mensaje);
            return "";
        }
    }
}
