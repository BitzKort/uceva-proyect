package co.uceva.edu.base.services;

import co.uceva.edu.base.models.Cliente;
import co.uceva.edu.base.repositories.ClienteRepository;

import java.util.List;

public class ClienteService {

    ClienteRepository clienteRepository;

    public ClienteService() {
        clienteRepository = new ClienteRepository();
    }
    public List<Cliente> listar(){
        return clienteRepository.listar();
    }


    public List<Cliente> consulta(Integer cedula_cliente){
        return clienteRepository.consulta(cedula_cliente);
    }

    public boolean crear(Cliente cliente){
        if(clienteRepository.consulta(cliente.getCedula_cliente()).size() > 0){
            return false;
        }else{
            return clienteRepository.crear(cliente);
        }
    }

    public boolean eliminar(int cedula_cliente) {
        return clienteRepository.eliminar(cedula_cliente);
    }

    public boolean editar(Cliente cliente) {
        return clienteRepository.editar(cliente);  //new cliente
    }
}
