package com.lambdaschool.lambdatable.model;



import com.lambdaschool.lambdatable.model.audit.DateAudit;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "teachers")
public class Teacher  extends DateAudit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String name;

    public Teacher() {
    }

    public Teacher(@NotBlank String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
