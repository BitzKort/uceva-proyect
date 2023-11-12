package co.uceva.edu.base.services;

import co.uceva.edu.base.models.Vendedor;
import co.uceva.edu.base.repositories.VendedorRepository;

import java.util.List;

public class VendedorService {

    VendedorRepository vendedorRepository;

    public VendedorService() {
        vendedorRepository = new VendedorRepository();
    }

    public List<Vendedor> listar() {
        return vendedorRepository.listar();
    }

    public List<Vendedor> consulta(Integer cedula_vendedor) {
        return vendedorRepository.consulta(cedula_vendedor);
    }

    public boolean crear(Vendedor vendedor) {
        if (vendedorRepository.consulta(vendedor.getCedula_vendedor()).size() > 0) {
            return false;
        } else {
            return vendedorRepository.crear(vendedor);
        }
    }

    public boolean eliminar(int cedula_vendedor) {
        return vendedorRepository.eliminar(cedula_vendedor);
    }

    public boolean editar(Vendedor vendedor) {
        return vendedorRepository.editar(vendedor);
    }
}
