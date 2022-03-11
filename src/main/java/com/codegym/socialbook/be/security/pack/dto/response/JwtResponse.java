package com.codegym.socialbook.be.security.pack.dto.response;


import com.codegym.socialbook.be.user.pack.model.Users;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

public class JwtResponse {
    private String token;
    private String type = "Bearer";
    private Users users;

    public JwtResponse() {
    }

    public JwtResponse(String token, Users users) {
        this.token = token;
        this.users = users;
    }


    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }


    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }
}
