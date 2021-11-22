package g18.reto1.Interface;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import g18.reto1.Modelo.ModeloUsuario;

public interface InterfaceUsuario extends CrudRepository<ModeloUsuario, Integer> {
    Optional<ModeloUsuario> findByEmail(String email);
    Optional<ModeloUsuario> findByEmailAndPassword(String email,String password);
    //Optional<User> findByName(String name);
}