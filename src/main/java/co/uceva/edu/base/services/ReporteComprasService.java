package co.uceva.edu.base.services;

import co.uceva.edu.base.models.PuntoVisita;
import co.uceva.edu.base.models.ReporteCompras;
import co.uceva.edu.base.repositories.ReporteComprasRepository;

import java.util.List;

public class ReporteComprasService {

    private ReporteComprasRepository reporteComprasRepository;

    public ReporteComprasService() {
        this.reporteComprasRepository = new ReporteComprasRepository();
    }

    public List<ReporteCompras> generarReporte(String mes) {
        return reporteComprasRepository.generarReporte(mes);
    }
}
