package co.uceva.edu.base.services;

import co.uceva.edu.base.models.Activo;
import co.uceva.edu.base.repositories.ActivoRepository;

import java.util.List;

public class ActivoService {

    ActivoRepository activoRepository;

    public ActivoService() {
        activoRepository = new ActivoRepository();
    }
    public List<Activo> listar(){
        return activoRepository.listar();
    }

    public List<Activo> consulta(Integer id){
        return activoRepository.consulta(id);
    }

    public boolean crear(Activo activo){
        if(activoRepository.consulta(activo.getIdPlant()).size() > 0){
            return false;
        }else{
            return activoRepository.crear(activo);
        }
    }

    public boolean eliminar(int idPlant) {
        return activoRepository.eliminar(idPlant);
    }

    public boolean editar(Activo activo) {
        return activoRepository.editar(activo);  //new activo
    }
}
