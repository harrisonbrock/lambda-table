package com.lambdaschool.lambdatable.model;

import lombok.Data;
import org.hibernate.annotations.NaturalId;

import javax.persistence.*;

/**
 * Created by rajeevkumarsingh on 01/08/17.
 */
@Entity
@Data
@Table(name = "roles")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @NaturalId
    @Column(length = 60)
    private RoleName name;

}
