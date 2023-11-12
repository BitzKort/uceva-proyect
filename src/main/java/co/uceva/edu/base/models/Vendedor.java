package co.uceva.edu.base.models;

public class Vendedor {

    private int cedula_vendedor;
    private String nombre_vendedor;
    private String correo_electronico;
    private String username;
    private String password;
    private String fech_nacimiento;
    private String fech_modificacion;
    private String fech_creacion;

    // Constructor vacío
    public Vendedor() {
    }

    // Constructor con todos los campos
    public Vendedor(int cedula_vendedor, String nombre_vendedor, String correo_electronico,
                    String username, String password, String fech_nacimiento,
                    String fech_modificacion, String fech_creacion) {
        this.cedula_vendedor = cedula_vendedor;
        this.nombre_vendedor = nombre_vendedor;
        this.correo_electronico = correo_electronico;
        this.username = username;
        this.password = password;
        this.fech_nacimiento = fech_nacimiento;
        this.fech_modificacion = fech_modificacion;
        this.fech_creacion = fech_creacion;
    }

    // Getters y setters
    public int getCedula_vendedor() {
        return cedula_vendedor;
    }

    public void setCedula_vendedor(int cedula_vendedor) {
        this.cedula_vendedor = cedula_vendedor;
    }

    public String getNombre_vendedor() {
        return nombre_vendedor;
    }

    public void setNombre_vendedor(String nombre_vendedor) {
        this.nombre_vendedor = nombre_vendedor;
    }

    public String getCorreo_electronico() {
        return correo_electronico;
    }

    public void setCorreo_electronico(String correo_electronico) {
        this.correo_electronico = correo_electronico;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFech_nacimiento() {
        return fech_nacimiento;
    }

    public void setFech_nacimiento(String fech_nacimiento) {
        this.fech_nacimiento = fech_nacimiento;
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
}
