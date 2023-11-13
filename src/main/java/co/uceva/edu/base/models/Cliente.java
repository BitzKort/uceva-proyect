package co.uceva.edu.base.models;

import java.sql.Date;

public class Cliente {

    private int cedula_cliente;
    private String nombre_cliente;
    private String correo_electronico;
    private long tel_pers_contact;
    private String quien_creo;
    private String nom_pers_contact;
    private Date fech_nacimiento;
    private Date fech_modificacion;
    private Date fech_creacion;
    private int cedula_vendedor;

    // Constructor
    public Cliente(int cedula_cliente, String nombre_cliente, String correo_electronico,
                   long tel_pers_contact, String quien_creo, String nom_pers_contact,
                   Date fech_nacimiento, Date fech_modificacion, Date fech_creacion,
                   int cedula_vendedor) {
        this.cedula_cliente = cedula_cliente;
        this.nombre_cliente = nombre_cliente;
        this.correo_electronico = correo_electronico;
        this.tel_pers_contact = tel_pers_contact;
        this.quien_creo = quien_creo;
        this.nom_pers_contact = nom_pers_contact;
        this.fech_nacimiento = fech_nacimiento;
        this.fech_modificacion = fech_modificacion;
        this.fech_creacion = fech_creacion;
        this.cedula_vendedor = cedula_vendedor;
    }

    public Cliente() {

    }

    // Campos encapsulados (getters y setters)
    public int getCedula_cliente() {
        return cedula_cliente;
    }

    public void setCedula_cliente(int cedula_cliente) {
        this.cedula_cliente = cedula_cliente;
    }

    public String getNombre_cliente() {
        return nombre_cliente;
    }

    public void setNombre_cliente(String nombre_cliente) {
        this.nombre_cliente = nombre_cliente;
    }

    public String getCorreo_electronico() {
        return correo_electronico;
    }

    public void setCorreo_electronico(String correo_electronico) {
        this.correo_electronico = correo_electronico;
    }

    public long getTel_pers_contact() {
        return tel_pers_contact;
    }

    public void setTel_pers_contact(long tel_pers_contact) {
        this.tel_pers_contact = tel_pers_contact;
    }

    public String getQuien_creo() {
        return quien_creo;
    }

    public void setQuien_creo(String quien_creo) {
        this.quien_creo = quien_creo;
    }

    public String getNom_pers_contact() {
        return nom_pers_contact;
    }

    public void setNom_pers_contact(String nom_pers_contact) {
        this.nom_pers_contact = nom_pers_contact;
    }

    public Date getFech_nacimiento() {
        return fech_nacimiento;
    }

    public void setFech_nacimiento(Date fech_nacimiento) {
        this.fech_nacimiento = fech_nacimiento;
    }

    public Date getFech_modificacion() {
        return fech_modificacion;
    }

    public void setFech_modificacion(Date fech_modificacion) {
        this.fech_modificacion = fech_modificacion;
    }

    public Date getFech_creacion() {
        return fech_creacion;
    }

    public void setFech_creacion(Date fech_creacion) {
        this.fech_creacion = fech_creacion;
    }

    public int getCedula_vendedor() {
        return cedula_vendedor;
    }

    public void setCedula_vendedor(int cedula_vendedor) {
        this.cedula_vendedor = cedula_vendedor;
    }
}

