package com.lambdaschool.lambdatable.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
@Data
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userid")
    private Long Id;

    @NotEmpty
    private String name;

    @Column(name = "githubusername")
    @NotEmpty
    private String gitHubUserName;
}
