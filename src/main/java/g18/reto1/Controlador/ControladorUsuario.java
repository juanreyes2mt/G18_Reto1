package g18.reto1.Controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import g18.reto1.Modelo.ModeloUsuario;
import g18.reto1.Servicios.ServiciosUsuario;

import org.springframework.http.HttpStatus;

@RestController
@RequestMapping("/api/user")
@CrossOrigin("*")
public class ControladorUsuario {
    @Autowired
    private ServiciosUsuario Servicios;
    
    @GetMapping("/all")
    public List<ModeloUsuario> getAll() {
        return Servicios.getAll();
    }
    
    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public ModeloUsuario registrar(@RequestBody ModeloUsuario user) {
        return Servicios.registrar(user);
    }
    
    @GetMapping("/{email}/{password}")
    public ModeloUsuario autenticarUsuario(@PathVariable("email") String email, @PathVariable("password") String password) {
        return Servicios.autenticarUsuario(email, password);
    }
    
    @GetMapping("/{email}")
    public boolean existeEmail(@PathVariable("email") String email) {
        return Servicios.existeEmail(email);
    }   
}
