package co.uceva.edu.base.models;

public class ReporteCompras {
    private PuntoVisita puntoVisita;
    private int cantidadCompras;

    public ReporteCompras(PuntoVisita puntoVisita, int cantidadCompras) {
        this.puntoVisita = puntoVisita;
        this.cantidadCompras = cantidadCompras;
    }

    public PuntoVisita getPuntoVisita() {
        return puntoVisita;
    }

    public void setPuntoVisita(PuntoVisita puntoVisita) {
        this.puntoVisita = puntoVisita;
    }

    public int getCantidadCompras() {
        return cantidadCompras;
    }

    public void setCantidadCompras(int cantidadCompras) {
        this.cantidadCompras = cantidadCompras;
    }
}
