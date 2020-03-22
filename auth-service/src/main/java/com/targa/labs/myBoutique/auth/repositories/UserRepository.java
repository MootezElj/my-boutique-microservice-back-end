/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.targa.labs.myBoutique.auth.repositories;

import com.targa.labs.myBoutique.auth.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.support.JpaRepositoryFactory;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Mootez
 */
@Repository
public interface UserRepository extends  JpaRepository<User, Long>{
    
}
