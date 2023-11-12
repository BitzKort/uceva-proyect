package co.uceva.edu.base.services;

import co.uceva.edu.base.models.PlanTuristico;
import co.uceva.edu.base.repositories.PlanTuristicoRepository;

import java.util.List;

public class PlanTuristicoService {

    PlanTuristicoRepository planTuristicoRepository;

    public PlanTuristicoService() {
        planTuristicoRepository = new PlanTuristicoRepository();
    }

    public List<PlanTuristico> listar() {
        return planTuristicoRepository.listar();
    }

    public List<PlanTuristico> consulta(Integer id_plan_turistico) {
        return planTuristicoRepository.consulta(id_plan_turistico);
    }

    public boolean crear(PlanTuristico planTuristico) {
        if (planTuristicoRepository.consulta(planTuristico.getId_plan_turistico()).size() > 0) {
            return false;
        } else {
            return planTuristicoRepository.crear(planTuristico);
        }
    }

    public boolean eliminar(int id_plan_turistico) {
        return planTuristicoRepository.eliminar(id_plan_turistico);
    }

    public boolean editar(PlanTuristico nuevoPlanTuristico) {
        return planTuristicoRepository.editar(nuevoPlanTuristico);
    }
}
