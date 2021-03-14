package com.example.application.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity(name = "user_projects")
@Data
@Table(name = "users_details")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "role")
    private Role userRole;

    @OneToMany(cascade = CascadeType.ALL,
            mappedBy = "user",
    fetch = FetchType.EAGER)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private List<BookProject> bookProjects;

    public User() {
    }

    public User(Role userRole) {
        this.userRole = userRole;
    }

    public void addBookProject(BookProject newProject) {
        if(bookProjects == null) {
            bookProjects = new ArrayList<>();
        }
        bookProjects.add(Objects.requireNonNull(newProject));
        newProject.setUser(this);
    }
}
