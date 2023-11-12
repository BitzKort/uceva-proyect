package co.uceva.edu.base.services;

import co.uceva.edu.base.models.Actividad;
import co.uceva.edu.base.repositories.ActividadRepository;

import java.util.List;

public class ActividadService {

    ActividadRepository actividadRepository;

    public ActividadService() {
        actividadRepository = new ActividadRepository();
    }
    public List<Actividad> listar(){
        return actividadRepository.listar();
    }

    public List<Actividad> consulta(Integer id){
        return actividadRepository.consulta(id);
    }

    public boolean crear(Actividad actividad){
        if(actividadRepository.consulta(actividad.getId()).size() > 0){
            return false;
        }else{
            return actividadRepository.crear(actividad);
        }
    }

    public boolean eliminar(int id) {
        return actividadRepository.eliminar(id);
    }

    public boolean editar(Actividad actividad) {
        return actividadRepository.editar(actividad);  //new actividad
    }
}
