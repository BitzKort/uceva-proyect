package co.uceva.edu.base.beans;

import co.uceva.edu.base.models.Cliente;
import co.uceva.edu.base.services.ClienteService;

import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@SessionScoped
public class ClienteBean implements Serializable {

    private ClienteService clienteService;
    private Cliente cliente;

    public ClienteBean() {
        clienteService = new ClienteService();
        this.cliente= new Cliente();
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }



    public List<Cliente> listar(){
        return clienteService.listar();
    }

    public String irCrear(){
        return "crear-clientes.xhtml?faces-redirect=true";
    }

    public String irEditar(Integer cedula_cliente){
        System.out.println(cedula_cliente);
        this.cliente = clienteService.consulta(cedula_cliente).get(0);
        return "modificar-clientes.xhtml?faces-redirect=true";
    }

    public String crear(){

        if(clienteService.crear(this.cliente)){
            System.out.println("Creado Exitosamente");
            return "listar-clientes.xhtml?faces-redirect=true";
        }else{
            FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_WARN,"Error Guardando","Error Guardando");
            FacesContext.getCurrentInstance().addMessage("",mensaje);
            return "";
        }
    }

    public String eliminar(int cedula_cliente){
        System.out.println("Eliminando "+ cedula_cliente);
        if (clienteService.eliminar(cedula_cliente)){
            System.out.println("Eliminado Exitosamente");
            return "listar-clientes.xhtml?faces-redirect=true";
        }else {
            FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_WARN,"Error Eliminado", "Error Eliminando");
            FacesContext.getCurrentInstance().addMessage("",mensaje);
            return "";
        }
    }


    public String editar(){
        if (clienteService.editar(this.cliente)){
            System.out.println("Actualizado Exitosamente");
            return "listar-clientes.xhtml?faces-redirect=true";
        }else {
            FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_WARN,"Error Actualizar", "Error Actualizando");
            FacesContext.getCurrentInstance().addMessage("",mensaje);
            return "";
        }
    }

    public String devolverse(){
        if (clienteService.editar(this.cliente)){
            System.out.println("Actualizado Exitosamente");
            return "index.html?faces-redirect=true";
        }else {
            FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_WARN,"Error Actualizar", "Error Actualizando");
            FacesContext.getCurrentInstance().addMessage("",mensaje);
            return "";
        }
    }

    public String devolverEditar(){
        if (clienteService.editar(this.cliente)){
            System.out.println("Actualizado Exitosamente");
            return "listar-clientes.xhtml?faces-redirect=true";
        }else {
            FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_WARN,"Error Actualizar", "Error Actualizando");
            FacesContext.getCurrentInstance().addMessage("",mensaje);
            return "";
        }
    }
}
