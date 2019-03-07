package com.lambdaschool.lambdatable.model;

import com.lambdaschool.lambdatable.model.audit.DateAudit;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "topics", uniqueConstraints = {
        @UniqueConstraint(columnNames = {
                "name"
        }),
})
public class Topic  extends DateAudit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String name;

    public Topic() {
    }

    public Topic(@NotBlank String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
