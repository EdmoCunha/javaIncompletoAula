package br.com.ulbra.minhaapi.controllers;
import br.com.ulbra.minhaapi.models.User;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.stream;

@RestController
@RequestMapping("/users")
public class UserController {
    List<User> users = new ArrayList<>();

    public UserController() {
        users.add(new User("Rodrigo", "rodrigo@gmail.com", 1));
        users.add(new User("Lion", "Lion@gmail.com",2));
        users.add(new User("100Humanos", "100Humanosvs1Gorila@gmail.com", 3));
    }

    @GetMapping
    public List<User>  ListaTodosUsuarios(){
        return users;
    }

    @GetMapping("/{id}")
    public User listaUsuario(@PathVariable int id){
       return  users.stream().filter(item->item.getId()== id).findFirst().orElseThrow();

    }
    @PostMapping
    public User criarNovoUsuario(@RequestBody User user){
        this.users.add(user);
        return user;
    }
    @DeleteMapping("/{id}")
    public void deletarUsuario(@PathVariable int id){
        User userFiltrado = users.stream().filter(item->item.getId()== id).findFirst().orElseThrow();
        users.remove(userFiltrado);
    }

    @PutMapping("/{id}")
    public User alterarUsuario(@RequestBody User userRequest, @PathVariable int id){
        User userFiltrado = users.stream().filter(item->item.getId()== id).findFirst().orElseThrow();
        users.remove(userFiltrado);


        userRequest.setId(userFiltrado.getId());
        int index = users.indexOf(userFiltrado);

        users.set(index, userRequest);

        return userRequest;
    }

}
