package com.hai925i.campus.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role;

    @ManyToOne
    @JoinColumn(name = "fk_universite")
    private Universite universite;

    @ManyToOne
    @JoinColumn(name = "fk_campus")
    private Campus campus;

    @Column(name = "last_login_date")
    private LocalDateTime lastLoginDate;

    public User(){}

    public User(Long id, String username, String password, Role role, Universite universite, Campus campus, LocalDateTime lastLoginDate) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.role = role;
        this.universite = universite;
        this.campus = campus;
        this.lastLoginDate = lastLoginDate;
    }

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public Role getRole() {
        return role;
    }

    public Universite getUniversite() {
        return universite;
    }

    public Campus getCampus() {
        return campus;
    }

    public LocalDateTime getLastLoginDate() {
        return lastLoginDate;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public void setUniversite(Universite universite) {
        this.universite = universite;
    }

    public void setCampus(Campus campus) {
        this.campus = campus;
    }

    public void setLastLoginDate(LocalDateTime lastLoginDate) {
        this.lastLoginDate = lastLoginDate;
    }
}
