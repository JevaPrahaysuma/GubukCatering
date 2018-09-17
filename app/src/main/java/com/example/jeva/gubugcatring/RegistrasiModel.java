package com.example.jeva.gubugcatring;

/**
 * Created by jeva on 14/04/2018.
 */

public class RegistrasiModel {
    private int id;
    private String email;
    private String username;
    private String password;
    public RegistrasiModel(){
    }

    public RegistrasiModel(int id, String email, String username, String password){
        this.id = id;
        this.email = email;
        this.username = username;
        this.password = password;
    }
    public RegistrasiModel(String email, String username, String password){
        this.email = email;
        this.username = username;
        this.password = password;
    }



    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
