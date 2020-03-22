/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.targa.labs.myBoutique.auth.domain; 
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.*;


@Table
@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String username;
    
    @Column(name="email_address", length = 200)
    private String emaiAddress;
    
    private String password;
    private Character status;
    @Column(name = "login_attempt")
    private Integer loginAttempts;
    
    @ElementCollection(fetch = FetchType.EAGER)
    @Builder.Default
    private List<String> roles = new ArrayList<>();


    public User(String username, String emaiAddress, String password, Character status, Integer loginAttempts, List<String> roles) {
        this.username = username;
        this.emaiAddress = emaiAddress;
        this.password = password;
        this.status = status;
        this.loginAttempts = loginAttempts;
        this.roles = roles;
    }

    public User(String username, String emaiAddress, String password) {
        this.username = username;
        this.emaiAddress = emaiAddress;
        this.password = password;
    }
}