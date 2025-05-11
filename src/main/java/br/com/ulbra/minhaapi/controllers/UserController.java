package br.com.ulbra.minhaapi.controllers;
import br.com.ulbra.minhaapi.models.User;
import br.com.ulbra.minhaapi.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.stream;

@RestController
@RequestMapping("/users")
public class UserController {
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<User>>  ListaTodosUsuarios(){
        return ResponseEntity.ok().body(this.userService.ListaTodosUsuarios());
    }

    @GetMapping("/{id}")
    public ResponseEntity<User>listaUsuario(@PathVariable int id){
       return  ResponseEntity.ok(this.userService.listaUsuario(id));

    }
    @PostMapping
    public ResponseEntity<User> criarNovoUsuario(@RequestBody User userRequest){
        User user = this.userService.criarNovoUsuario(userRequest);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(user.getId()).toUri();
        return ResponseEntity.created(uri).body(user);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarUsuario(@PathVariable int id){
        this.userService.deletarUsuario(id);
       return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> alterarUsuario(@RequestBody User userRequest, @PathVariable int id){
       User userAtual = this.userService.alterarUsuario(userRequest, id);
        return ResponseEntity.ok(userAtual);
    }

}
