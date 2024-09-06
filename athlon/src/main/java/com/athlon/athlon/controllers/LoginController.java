package com.athlon.athlon.controllers;

import java.util.List;
import org.springframework.web.bind.annotation.RestController;
import com.athlon.athlon.models.Login;
import com.athlon.athlon.repositories.LoginRepositorie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/api/logins")
public class LoginController {

    @Autowired
    private LoginRepositorie loginRepositorie;
    
    /*Obtener todos los logins */
    @GetMapping
    public List <Login> obtener_todos_logins() {
        return loginRepositorie.findAll();
    }

    /*Obtener logins por medio de la ID */
    @GetMapping ("/{usuarioID}")
    public Login obtener_login_por_ID(@PathVariable("usuarioID") Long usuarioID ) {
        return loginRepositorie.findById(usuarioID).orElse(null);
    }

    /*Crear un login  */
    @PostMapping()
    public Login crear_login(@RequestBody Login  login) {
        return loginRepositorie.save(login);
    }

    /*Actualizar login */
    @PutMapping("/{usuarioID}")
    public Login actualizar_login(@PathVariable ("usuarioID") Long usuarioID, @RequestBody Login  login) {
        login.setUsuarioID(usuarioID);
        return loginRepositorie.save(login);  
    }
    
    /*Eliminar Login */
    @DeleteMapping("/{usuarioID}")
    public void eliminar_login(@PathVariable("usuarioID") Long login) {
        loginRepositorie.deleteById(login);
    }
}
