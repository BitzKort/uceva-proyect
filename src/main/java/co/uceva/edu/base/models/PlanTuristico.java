package co.uceva.edu.base.models;

public class PlanTuristico {
    private int id_plan_turistico;
    private String titulo;
    private String descripcion;
    private String fech_creacion;
    private String fech_modificacion;
    private int cant_dias;
    private String estado;
    private String alimentacion;

    // Constructor
    public PlanTuristico(int id_plan_turistico, String titulo, String descripcion,
                         String fech_creacion, String fech_modificacion, int cant_dias,
                         String estado, String alimentacion) {
        this.id_plan_turistico = id_plan_turistico;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.fech_creacion = fech_creacion;
        this.fech_modificacion = fech_modificacion;
        this.cant_dias = cant_dias;
        this.estado = estado;
        this.alimentacion = alimentacion;
    }

    // Constructores adicionales (puedes tener otros constructores según tus necesidades)
    public PlanTuristico() {
    }

    // Getters y Setters
    public int getId_plan_turistico() {
        return id_plan_turistico;
    }

    public void setId_plan_turistico(int id_plan_turistico) {
        this.id_plan_turistico = id_plan_turistico;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getFech_creacion() {
        return fech_creacion;
    }

    public void setFech_creacion(String fech_creacion) {
        this.fech_creacion = fech_creacion;
    }

    public String getFech_modificacion() {
        return fech_modificacion;
    }

    public void setFech_modificacion(String fech_modificacion) {
        this.fech_modificacion = fech_modificacion;
    }

    public int getCant_dias() {
        return cant_dias;
    }

    public void setCant_dias(int cant_dias) {
        this.cant_dias = cant_dias;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getAlimentacion() {
        return alimentacion;
    }

    public void setAlimentacion(String alimentacion) {
        this.alimentacion = alimentacion;
    }
}
