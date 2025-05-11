package br.com.ulbra.minhaapi.repositories;

import br.com.ulbra.minhaapi.models.User;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepository {

    List<User> users = new ArrayList<>();

    public UserRepository() {
        users.add(new User("Rodrigo", "rodrigo@gmail.com", 1));
        users.add(new User("Lion", "Lion@gmail.com",2));
        users.add(new User("100Humanos", "100Humanosvs1Gorila@gmail.com", 3));
    }


    public List<User>  ListaTodosUsuarios(){
        return users;
    }


    public User listaUsuario(int id){
        return  users.stream().filter(item->item.getId()== id).findFirst().orElseThrow();

    }

    public User criarNovoUsuario( User user){
        this.users.add(user);
        return user;
    }

    public void deletarUsuario( int id){
        User userFiltrado = users.stream().filter(item->item.getId()== id).findFirst().orElseThrow();
        users.remove(userFiltrado);
    }


    public User alterarUsuario( User userRequest,  int id){
        User userFiltrado = users.stream().filter(item->item.getId()== id).findFirst().orElseThrow();
        users.remove(userFiltrado);


        userRequest.setId(userFiltrado.getId());
        int index = users.indexOf(userFiltrado);

        users.set(index, userRequest);

        return userRequest;
    }
}
