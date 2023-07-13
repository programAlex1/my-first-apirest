/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.api.crud.service;

import com.api.crud.model.UserModel;
import com.api.crud.repository.IUserRepository;
import java.util.List;
import java.util.Optional;
import org.hibernate.loader.internal.LoadAccessContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    
    @Autowired
    IUserRepository repositorio;
    
    public List<UserModel> getUsers(){
        return repositorio.findAll();
    }
    
    public UserModel guardar(UserModel user){
        return repositorio.save(user);
    }
    
    public Boolean eliminar(Long id){
        try {
            repositorio.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
        
   
    public Optional<UserModel> findbyid(Long id){
        return repositorio.findById(id);
    }
    
    public UserModel updateByID(UserModel user, Long id ){
    UserModel userModel = repositorio.findById(id).get();
    userModel.setFirstName(user.getFirstName());
    userModel.setLastName(user.getLastName());
    userModel.setEmail(user.getEmail());
    repositorio.save(userModel);
    return userModel;
    }
    
}
