package com.example.application.model;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Data
@Table(name = "users_details")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "role")
    private Role userRole;

    @OneToMany(cascade = CascadeType.ALL,
            mappedBy = "user")
    private List<BookProject> bookProjects;

    public User() {
    }

    public User(Role userRole, List<BookProject> bookProjects) {
        this.userRole = userRole;
        this.bookProjects = bookProjects;
    }

    public void addBookProject(BookProject newProject) {
        if(bookProjects == null) {
            bookProjects = new ArrayList<>();
        }
        bookProjects.add(Objects.requireNonNull(newProject));
        newProject.setUser(this);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userRole=" + userRole +
                '}';
    }
}
