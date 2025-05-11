package br.com.ulbra.minhaapi.services;

import br.com.ulbra.minhaapi.models.User;
import br.com.ulbra.minhaapi.repositories.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class UserService {
    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    public List<User> ListaTodosUsuarios(){
       return this.userRepository.ListaTodosUsuarios();

    }


    public User listaUsuario( int id){
        return this.userRepository.listaUsuario(id);

    }

    public User criarNovoUsuario( User user){
        return this.userRepository.criarNovoUsuario(user);
    }

    public void deletarUsuario( int id){
        this.userRepository.deletarUsuario(id);
    }


    public User alterarUsuario(User userRequest, int id){
       return this.userRepository.alterarUsuario(userRequest, id);

    }
}
