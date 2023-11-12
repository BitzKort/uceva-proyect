package co.uceva.edu.base.services;

import co.uceva.edu.base.models.Cliente;
import co.uceva.edu.base.models.CompraDiego;
import co.uceva.edu.base.repositories.ClienteRepository;
import co.uceva.edu.base.repositories.CompraDiegoRepository;

import java.util.List;

public class CompraDiegoService {

    CompraDiegoRepository compraDiegoRepository;

    public CompraDiegoService() {
        compraDiegoRepository = new CompraDiegoRepository();
    }
    public List<CompraDiego> listar(){
        return compraDiegoRepository.listar();
    }


    public List<CompraDiego> consulta(Integer id_compra){
        return compraDiegoRepository.consulta(id_compra);
    }

    public boolean crear(CompraDiego compraDiego){
        if(compraDiegoRepository.consulta(compraDiego.getId_compra()).size() > 0){
            return false;
        }else{
            return compraDiegoRepository.crear(compraDiego);
        }
    }

    public boolean eliminar(int id_compra) {
        return compraDiegoRepository.eliminar(id_compra);
    }

    public boolean editar(CompraDiego compraDiego) {return compraDiegoRepository.editar(compraDiego);  //new compraDiego
    }
}
