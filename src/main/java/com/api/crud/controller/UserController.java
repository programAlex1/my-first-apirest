/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.api.crud.controller;

import com.api.crud.model.UserModel;
import com.api.crud.service.UserService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService servicio;

    @PostMapping
    public UserModel guardar(@RequestBody UserModel user) {
        return this.servicio.guardar(user);
    }
    
    
    @GetMapping
    public List<UserModel>getUserwithlimit(@RequestParam(value= "limite",required = false)Integer limite ){
        if(limite == null){
        return servicio.getUsers();     
        }else{
         return servicio.findallwithlimit(limite);
        }
    }

    @DeleteMapping("/{id}")
    public String eliminar(@PathVariable Long id) {
        boolean status = servicio.eliminar(id);
        if (status) {
            return "El ID:" + id + " fue eliminado con exito";
        } else {
            return "Error en eliminar el ID:" + id;
        }
    }

    @PutMapping(path = "/{id}")
    public UserModel updateUserById(@RequestBody UserModel user, @PathVariable Long id) {
        return servicio.updateByID(user, id);
    }

    @GetMapping("/{id}")
    public Optional<UserModel> buscar(@PathVariable Long id) {
        return servicio.findbyid(id);
    }
}
