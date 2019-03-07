package com.lambdaschool.lambdatable.model;

import com.lambdaschool.lambdatable.model.audit.DateAudit;
import lombok.Data;
import org.hibernate.validator.constraints.URL;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

@Entity
@Data
@Table (name = "reports")
public class Report extends DateAudit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "reportId")
    private Long Id;

    @Column(name = "describeweek")
    @NotEmpty
    private String describeWeek;

    @Column(name = "whatwentwell")
    private String whatWentWellThisWeek;

    @Column(name = "whatcouldhavewentbetter")
    private String whatCouldHaveWentBetter;

    @NotEmpty
    @Column(name = "whatdidyouworkonthisweek")
    private String whatDidYouWorkOnThisWeek;
    @Column(name = "urlSubmission")
    @URL
    private String urlSubmission;

    @NotBlank
    private String teacher;

    @NotBlank
    private String projectmanager;


    // TODO: Add User Many-Reports-to-One-User
    @ManyToOne()
    private User user;
}
