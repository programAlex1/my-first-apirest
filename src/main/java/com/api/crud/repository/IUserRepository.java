/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.api.crud.repository;

import com.api.crud.model.UserModel;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

@Repository
public interface IUserRepository extends JpaRepository<UserModel,Long>{
    
    
    @Query(value = "SELECT * FROM user LIMIT :limite", nativeQuery = true) 
    public List<UserModel> findallwithlimit(int limite);
    
    
}
