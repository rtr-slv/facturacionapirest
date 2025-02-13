package ec.edu.puce.facturacionapirest.service;

import ec.edu.puce.facturacionapirest.domain.Cliente;
import ec.edu.puce.facturacionapirest.persistence.ClientePersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    @Autowired
    private ClientePersistence clientePersistence;

    public List<Cliente> listarTodos() {
        return clientePersistence.findAll();
    }

    public void guardarCliente(Cliente cliente) {
        clientePersistence.save(cliente);
    }

    public void actualizarCliente(Cliente cliente) {
        if (clientePersistence.existsById(cliente.getId())) {
            clientePersistence.save(cliente);
        }
    }

    public void eliminarCliente(Long id) {
        clientePersistence.deleteById(id);
    }

    public List<Cliente> buscarPorNombre(String nombre) {
        return clientePersistence.findByNombreContainingIgnoreCase(nombre);
    }
}