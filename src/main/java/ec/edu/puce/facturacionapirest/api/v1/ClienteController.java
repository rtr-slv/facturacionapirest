package ec.edu.puce.facturacionapirest.api.v1;

import ec.edu.puce.facturacionapirest.domain.Cliente;
import ec.edu.puce.facturacionapirest.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping
    public List<Cliente> listarTodos() {
        return clienteService.listarTodos();
    }

    @PostMapping
    public String guardarCliente(@RequestBody Cliente cliente) {
        clienteService.guardarCliente(cliente);
        return "Cliente guardado correctamente";
    }

    @PutMapping
    public String actualizarCliente(@RequestBody Cliente cliente) {
        clienteService.actualizarCliente(cliente);
        return "Cliente actualizado correctamente";
    }

    @DeleteMapping("/{id}")
    public String eliminarCliente(@PathVariable Long id) {
        clienteService.eliminarCliente(id);
        return "Cliente eliminado correctamente";
    }

    @GetMapping("/buscar/{nombre}")
    public List<Cliente> buscarPorNombre(@PathVariable String nombre) {
        return clienteService.buscarPorNombre(nombre);
    }
}