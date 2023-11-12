package co.uceva.edu.base.models;

public class Actividad {
    private int id;

    private String plan;

    private String nombre_lugar;

    public Actividad(int id, String plan, String nombre_lugar) {
        this.id=id;
        this.plan=plan;
        this.nombre_lugar=nombre_lugar;
    }

    public Actividad() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPlan() {
        return plan;
    }

    public void setPlan(String plan) {
        this.plan = plan;
    }

    public String getNombre_lugar() {
        return nombre_lugar;
    }

    public void setNombre_lugar(String nombre_lugar) {
        this.nombre_lugar = nombre_lugar;
    }
}
