package g18.reto1.Servicios;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import g18.reto1.Modelo.ModeloUsuario;
import g18.reto1.Repositorio.RepositorioUsuario;

@Service
public class ServiciosUsuario {

    @Autowired
    private RepositorioUsuario Repositorio;
    
    public List<ModeloUsuario> getAll() {
        return Repositorio.getAll();
    }

    public Optional<ModeloUsuario> getUser(int id) {
        return Repositorio.getUser(id);
    }

    public ModeloUsuario registrar(ModeloUsuario user) {
        if (user.getId() == null) {
            if (existeEmail(user.getEmail()) == false) {
                return Repositorio.save(user);
            } else {
                return user;
            }
        } else {
            return user;
        }
    }

    public boolean existeEmail(String email) {
        return Repositorio.existeEmail(email);
    }

    public ModeloUsuario autenticarUsuario(String email, String password) {
        Optional<ModeloUsuario> usuario = Repositorio.autenticarUsuario(email, password);

        if (usuario.isEmpty()) {
            return new ModeloUsuario(email, password, "NO DEFINIDO");
        } else {
            return usuario.get();
        }
    }
}
