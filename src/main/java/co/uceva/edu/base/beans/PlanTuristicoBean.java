package co.uceva.edu.base.beans;

import co.uceva.edu.base.models.PlanTuristico;
import co.uceva.edu.base.services.PlanTuristicoService;

import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@SessionScoped
public class PlanTuristicoBean implements Serializable {

    private PlanTuristicoService planTuristicoService;
    private PlanTuristico planTuristico;

    public PlanTuristicoBean() {
        planTuristicoService = new PlanTuristicoService();
        this.planTuristico = new PlanTuristico();
    }

    public PlanTuristico getPlanTuristico() {
        return planTuristico;
    }

    public void setPlanTuristico(PlanTuristico planTuristico) {
        this.planTuristico = planTuristico;
    }

    public List<PlanTuristico> listar() {
        return planTuristicoService.listar();
    }

    public String irCrear() {
        return "crear-planesTuristicos.xhtml?faces-redirect=true";
    }

    public String irEditar(Integer id_plan_turistico) {
        System.out.println(id_plan_turistico);
        this.planTuristico = planTuristicoService.consulta(id_plan_turistico).get(0);
        return "modificar-planesTuristicos.xhtml?faces-redirect=true";
    }

    public String irPlanTuristico(Integer id_plan_turistico) {
        System.out.println(id_plan_turistico);
        this.planTuristico = planTuristicoService.consulta(id_plan_turistico).get(0);
        return "listar-actividades.xhtml?faces-redirect=true";
    }

    public String irActividad() {
        if (planTuristicoService.editar(this.planTuristico)) {
            System.out.println("Actualizado Exitosamente");
            return "listar-puntosVisitas.xhtml?faces-redirect=true";
        } else {
            FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_WARN, "Error Actualizar", "Error Actualizando");
            FacesContext.getCurrentInstance().addMessage("", mensaje);
            return "";
        }
    }

    public String crear() {
        if (planTuristicoService.crear(this.planTuristico)) {
            System.out.println("Creado Exitosamente");
            return "listar-planesTuristicos.xhtml?faces-redirect=true";
        } else {
            FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_WARN, "Error Guardando", "Error Guardando");
            FacesContext.getCurrentInstance().addMessage("", mensaje);
            return "";
        }
    }

    public String eliminar(int id_plan_turistico) {
        System.out.println("Eliminando " + id_plan_turistico);
        if (planTuristicoService.eliminar(id_plan_turistico)) {
            System.out.println("Eliminado Exitosamente");
            return "listar-planesTuristicos.xhtml?faces-redirect=true";
        } else {
            FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_WARN, "Error Eliminado", "Error Eliminando");
            FacesContext.getCurrentInstance().addMessage("", mensaje);
            return "";
        }
    }

    public String editar() {
        if (planTuristicoService.editar(this.planTuristico)) {
            System.out.println("Actualizado Exitosamente");
            return "listar-planesTuristicos.xhtml?faces-redirect=true";
        } else {
            FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_WARN, "Error Actualizar", "Error Actualizando");
            FacesContext.getCurrentInstance().addMessage("", mensaje);
            return "";
        }
    }

    public String devolverse() {
        if (planTuristicoService.editar(this.planTuristico)) {
            System.out.println("Actualizado Exitosamente");
            return "index.html?faces-redirect=true";
        } else {
            FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_WARN, "Error Actualizar", "Error Actualizando");
            FacesContext.getCurrentInstance().addMessage("", mensaje);
            return "";
        }
    }

    public String devolverEditar() {
        if (planTuristicoService.editar(this.planTuristico)) {
            System.out.println("Actualizado Exitosamente");
            return "listar-planesTuristicos.xhtml?faces-redirect=true";
        } else {
            FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_WARN, "Error Actualizar", "Error Actualizando");
            FacesContext.getCurrentInstance().addMessage("", mensaje);
            return "";
        }
    }
}
