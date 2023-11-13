package co.uceva.edu.base.beans;

import co.uceva.edu.base.models.PlanTuristico;
import co.uceva.edu.base.services.ReporteComprasService;

import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@SessionScoped
public class ReporteComprasBean implements Serializable {

    private ReporteComprasService reporteComprasService;
    private List<PlanTuristico> planesTuristicosMasComprados;
    private String mes;  // Agregar esta línea para la propiedad 'mes'

    public ReporteComprasBean() {
        reporteComprasService = new ReporteComprasService();
    }

    // Getters y Setters
    public String getMes() {
        return mes;
    }

    public void setMes(String mes) {
        this.mes = mes;
    }

    public List<PlanTuristico> getPlanesTuristicosMasComprados() {
        return planesTuristicosMasComprados;
    }

    public void setPlanesTuristicosMasComprados(List<PlanTuristico> planesTuristicosMasComprados) {
        this.planesTuristicosMasComprados = planesTuristicosMasComprados;
    }

    public String generarReporte() {
        // Lógica para generar el informe usando 'mes'
        // planesTuristicosMasComprados = reporteComprasService.generarReporte(mes);

        FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_INFO, "Informe generado exitosamente", null);
        FacesContext.getCurrentInstance().addMessage("", mensaje);

        return ""; // Puedes redirigir a una página de visualización del informe si es necesario
    }
}
