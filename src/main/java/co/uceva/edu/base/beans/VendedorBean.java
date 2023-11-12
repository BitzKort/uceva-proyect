package co.uceva.edu.base.beans;

import co.uceva.edu.base.models.Vendedor;
import co.uceva.edu.base.services.VendedorService;

import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@SessionScoped
public class VendedorBean implements Serializable {

    private VendedorService vendedorService;
    private Vendedor vendedor;

    public VendedorBean() {
        vendedorService = new VendedorService();
        this.vendedor = new Vendedor();
    }

    public Vendedor getVendedor() {
        return vendedor;
    }

    public void setVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
    }

    public List<Vendedor> listar() {
        return vendedorService.listar();
    }

    public String irCrear() {
        return "crear-vendedores.xhtml?faces-redirect=true";
    }

    public String irEditar(Integer cedula_vendedor) {
        System.out.println(cedula_vendedor);
        this.vendedor = vendedorService.consulta(cedula_vendedor).get(0);
        return "modificar-vendedores.xhtml?faces-redirect=true";
    }

    public String crear() {
        if (vendedorService.crear(this.vendedor)) {
            System.out.println("Creado Exitosamente");
            return "listar-vendedores.xhtml?faces-redirect=true";
        } else {
            FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_WARN, "Error Guardando", "Error Guardando");
            FacesContext.getCurrentInstance().addMessage("", mensaje);
            return "";
        }
    }

    public String eliminar(int cedula_vendedor) {
        System.out.println("Eliminando " + cedula_vendedor);
        if (vendedorService.eliminar(cedula_vendedor)) {
            System.out.println("Eliminado Exitosamente");
            return "listar-vendedores.xhtml?faces-redirect=true";
        } else {
            FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_WARN, "Error Eliminado", "Error Eliminando");
            FacesContext.getCurrentInstance().addMessage("", mensaje);
            return "";
        }
    }

    public String editar() {
        if (vendedorService.editar(this.vendedor)) {
            System.out.println("Actualizado Exitosamente");
            return "listar-vendedores.xhtml?faces-redirect=true";
        } else {
            FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_WARN, "Error Actualizar", "Error Actualizando");
            FacesContext.getCurrentInstance().addMessage("", mensaje);
            return "";
        }
    }

    public String devolverse() {
        if (vendedorService.editar(this.vendedor)) {
            System.out.println("Actualizado Exitosamente");
            return "index.html?faces-redirect=true";
        } else {
            FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_WARN, "Error Actualizar", "Error Actualizando");
            FacesContext.getCurrentInstance().addMessage("", mensaje);
            return "";
        }
    }

    public String devolverEditar() {
        if (vendedorService.editar(this.vendedor)) {
            System.out.println("Actualizado Exitosamente");
            return "listar-vendedores.xhtml?faces-redirect=true";
        } else {
            FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_WARN, "Error Actualizar", "Error Actualizando");
            FacesContext.getCurrentInstance().addMessage("", mensaje);
            return "";
        }
    }
}
