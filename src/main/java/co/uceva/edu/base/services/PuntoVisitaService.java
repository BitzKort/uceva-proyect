package co.uceva.edu.base.services;

import co.uceva.edu.base.models.PuntoVisita;
import co.uceva.edu.base.repositories.PuntoVisitaRepository;

import java.util.List;

public class PuntoVisitaService {

    PuntoVisitaRepository puntoVisitaRepository;

    public PuntoVisitaService() {
        puntoVisitaRepository = new PuntoVisitaRepository();
    }
    public List<PuntoVisita> listar(){
        return puntoVisitaRepository.listar();
    }


    public List<PuntoVisita> consulta(Integer id_actividad){
        return puntoVisitaRepository.consulta(id_actividad);
    }

    public boolean crear(PuntoVisita puntoVisita){
        if(puntoVisitaRepository.consulta(puntoVisita.getId_actividad()).size() > 0){
            return false;
        }else{
            return puntoVisitaRepository.crear(puntoVisita);
        }
    }

    public boolean eliminar(int id_actividad) {
        return puntoVisitaRepository.eliminar(id_actividad);
    }

    public boolean editar(PuntoVisita puntoVisita) {
        return puntoVisitaRepository.editar(puntoVisita);  //new puntoVisita
    }
}
