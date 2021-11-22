package g18.reto1.Repositorio;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import g18.reto1.Interface.InterfaceUsuario;
import g18.reto1.Modelo.ModeloUsuario;

@Repository
public class RepositorioUsuario {

    @Autowired
    private InterfaceUsuario CrudRepositorio;

    public List<ModeloUsuario> getAll() {
        return (List<ModeloUsuario>) CrudRepositorio.findAll();
    }

    public Optional<ModeloUsuario> getUser(int id) {
        return CrudRepositorio.findById(id);
    }

    public ModeloUsuario save(ModeloUsuario user) {
        return CrudRepositorio.save(user);
    }

    public boolean existeEmail(String email) {
        Optional<ModeloUsuario> usuario = CrudRepositorio.findByEmail(email);

        return !usuario.isEmpty();
    }

    public Optional<ModeloUsuario> autenticarUsuario(String email, String password) {
        return CrudRepositorio.findByEmailAndPassword(email, password);
    }
}


