package co.uceva.edu.base.models;

public class Activo {
    private int idPlant;

    private String temporada_año;

    private String tarifa_vigente;

    public Activo(int idPlant, String temporada_año, String tarifa_vigente) {
        this.idPlant=idPlant;
        this.temporada_año=temporada_año;
        this.tarifa_vigente=tarifa_vigente;
    }

    public Activo() {

    }

    public int getIdPlant() {
        return idPlant;
    }

    public void setIdPlant(int idPlant) {
        this.idPlant = idPlant;
    }

    public String getTemporada_año() {
        return temporada_año;
    }

    public void setTemporada_año(String temporada_año) {
        this.temporada_año = temporada_año;
    }

    public String getTarifa_vigente() {
        return tarifa_vigente;
    }

    public void setTarifa_vigente(String tarifa_vigente) {
        this.tarifa_vigente = tarifa_vigente;
    }
}
