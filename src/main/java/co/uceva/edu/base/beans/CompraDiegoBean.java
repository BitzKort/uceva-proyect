package co.uceva.edu.base.beans;

import co.uceva.edu.base.models.Cliente;
import co.uceva.edu.base.models.CompraDiego;
import co.uceva.edu.base.services.ClienteService;
import co.uceva.edu.base.services.CompraDiegoService;

import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@SessionScoped
public class CompraDiegoBean implements Serializable {

    private CompraDiegoService compraDiegoService;
    private CompraDiego compraDiego;
    public CompraDiegoBean() {
        compraDiegoService = new CompraDiegoService();
        this.compraDiego= new CompraDiego();
    }
    public CompraDiego getCompraDiego() {
        return compraDiego;
    }

    public void setCompraDiego(CompraDiego compraDiego) {
        this.compraDiego = compraDiego;
    }



    public List<CompraDiego> listar(){
        return compraDiegoService.listar();
    }

    public String irCrear(){
        return "crear-CompraDiego.xhtml?faces-redirect=true";
    }

    public String irEditar(Integer id_compra){
        System.out.println(id_compra);
        this.compraDiego = compraDiegoService.consulta(id_compra).get(0);
        return "modificar-CompraDiego.xhtml?faces-redirect=true";
    }

    public String crear(){

        if(compraDiegoService.crear(this.compraDiego)){
            System.out.println("Creado Exitosamente");
            return "listar-CompraDiego.xhtml?faces-redirect=true";
        }else{
            FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_WARN,"Error Guardando","Error Guardando");
            FacesContext.getCurrentInstance().addMessage("",mensaje);
            return "";
        }
    }

    public String eliminar(int id_compra){
        System.out.println("Eliminando "+ id_compra);
        if (compraDiegoService.eliminar(id_compra)){
            System.out.println("Eliminado Exitosamente");
            return "listar-CompraDiego.xhtml?faces-redirect=true";
        }else {
            FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_WARN,"Error Eliminado", "Error Eliminando");
            FacesContext.getCurrentInstance().addMessage("",mensaje);
            return "";
        }
    }


    public String editar(){
        if (compraDiegoService.editar(this.compraDiego)){
            System.out.println("Actualizado Exitosamente");
            return "listar-CompraDiego.xhtml?faces-redirect=true";
        }else {
            FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_WARN,"Error Actualizar", "Error Actualizando");
            FacesContext.getCurrentInstance().addMessage("",mensaje);
            return "";
        }
    }

    public String devolverse(){
        if (compraDiegoService.editar(this.compraDiego)){
            System.out.println("Actualizado Exitosamente");
            return "index.html?faces-redirect=true";
        }else {
            FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_WARN,"Error Actualizar", "Error Actualizando");
            FacesContext.getCurrentInstance().addMessage("",mensaje);
            return "";
        }
    }

    public String devolverEditar(){
        if (compraDiegoService.editar(this.compraDiego)){
            System.out.println("Actualizado Exitosamente");
            return "listar-CompraDiego.xhtml?faces-redirect=true";
        }else {
            FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_WARN,"Error Actualizar", "Error Actualizando");
            FacesContext.getCurrentInstance().addMessage("",mensaje);
            return "";
        }
    }
}
