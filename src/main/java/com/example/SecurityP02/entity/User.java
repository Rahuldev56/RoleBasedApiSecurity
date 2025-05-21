package com.example.SecurityP02.entity;

import jakarta.persistence.*;

import java.util.Set;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name="user_roles",joinColumns = @JoinColumn(name="user_id"),
            inverseJoinColumns =@JoinColumn(name="role_id"))
    private Set<Role> roles;

    private String username;
    private String Password;
public  User(){

}

    public User(Long id, Set<Role> roles, String username, String password) {
        this.id = id;
        this.roles = roles;
        this.username = username;
        Password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }



    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", roles=" + roles +
                ", username='" + username + '\'' +
                ", Password='" + Password + '\'' +
                '}';
    }
}
