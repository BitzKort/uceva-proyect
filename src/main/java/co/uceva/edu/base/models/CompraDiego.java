package co.uceva.edu.base.models;

public class CompraDiego {

    private int id_compra;
    private int id_cliente;
    private int id_vendedor;
    private String fech_creacion;
    private int total_planes;
    private int total_otros_cargos;
    private int total;


    // Constructor con todos los parámetros
    public CompraDiego(int id_compra, int id_cliente, int id_vendedor, String fech_creacion,
                       int total_planes, int total_otros_cargos, int total) {
        this.id_compra = id_compra;
        this.id_cliente = id_cliente;
        this.id_vendedor = id_vendedor;
        this.fech_creacion = fech_creacion;
        this.total_planes = total_planes;
        this.total_otros_cargos = total_otros_cargos;
        this.total = total;
    }

    // Constructor
    public CompraDiego() {
        // Constructor vacío
    }

    // Getters y Setters

    public int getId_compra() {
        return id_compra;
    }

    public void setId_compra(int id_compra) {
        this.id_compra = id_compra;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public int getId_vendedor() {
        return id_vendedor;
    }

    public void setId_vendedor(int id_vendedor) {
        this.id_vendedor = id_vendedor;
    }

    public String getFech_creacion() {
        return fech_creacion;
    }

    public void setFech_creacion(String fech_creacion) {
        this.fech_creacion = fech_creacion;
    }

    public int getTotal_planes() {
        return total_planes;
    }

    public void setTotal_planes(int total_planes) {
        this.total_planes = total_planes;
    }

    public int getTotal_otros_cargos() {
        return total_otros_cargos;
    }

    public void setTotal_otros_cargos(int total_otros_cargos) {
        this.total_otros_cargos = total_otros_cargos;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
}
