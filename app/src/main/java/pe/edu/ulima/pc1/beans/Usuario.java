package pe.edu.ulima.pc1.beans;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Usuario implements Serializable{

    @SerializedName("usuario")
    private String username;
    @SerializedName("password")
    private String password;

    public Usuario() {
    }

    public Usuario(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}


