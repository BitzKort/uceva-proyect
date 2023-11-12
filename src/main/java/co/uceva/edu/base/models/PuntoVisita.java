package co.uceva.edu.base.models;

public class PuntoVisita {
    private int id_actividad;
    private String nom_actividad;
    private String descripcion;
    private String estado;
    private String fech_modificacion;
    private String fech_creacion;
    private int id_departamento;
    private int id_ciudad;

    // Constructor
    public PuntoVisita(int id_actividad, String nom_actividad, String descripcion, String estado,
                       String fech_modificacion, String fech_creacion, int id_departamento, int id_ciudad) {
        this.id_actividad = id_actividad;
        this.nom_actividad = nom_actividad;
        this.descripcion = descripcion;
        this.estado = estado;
        this.fech_modificacion = fech_modificacion;
        this.fech_creacion = fech_creacion;
        this.id_departamento = id_departamento;
        this.id_ciudad = id_ciudad;
    }

    public PuntoVisita() {

    }

    // Campos encapsulados
    public int getId_actividad() {
        return id_actividad;
    }

    public void setId_actividad(int id_actividad) {
        this.id_actividad = id_actividad;
    }

    public String getNom_actividad() {
        return nom_actividad;
    }

    public void setNom_actividad(String nom_actividad) {
        this.nom_actividad = nom_actividad;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getFech_modificacion() {
        return fech_modificacion;
    }

    public void setFech_modificacion(String fech_modificacion) {
        this.fech_modificacion = fech_modificacion;
    }

    public String getFech_creacion() {
        return fech_creacion;
    }

    public void setFech_creacion(String fech_creacion) {
        this.fech_creacion = fech_creacion;
    }

    public int getId_departamento() {
        return id_departamento;
    }

    public void setId_departamento(int id_departamento) {
        this.id_departamento = id_departamento;
    }

    public int getId_ciudad() {
        return id_ciudad;
    }

    public void setId_ciudad(int id_ciudad) {
        this.id_ciudad = id_ciudad;
    }
}

