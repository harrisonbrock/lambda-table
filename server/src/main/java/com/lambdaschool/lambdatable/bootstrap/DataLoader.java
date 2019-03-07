package com.lambdaschool.lambdatable.bootstrap;

import com.lambdaschool.lambdatable.exception.ResourceNotFoundException;
import com.lambdaschool.lambdatable.model.*;
import com.lambdaschool.lambdatable.repositories.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;

@Component
public class DataLoader implements CommandLineRunner {

    private final RoleRepository roleRepository;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final TopicRepository topicRepository;
    private final TeacherRopistory teacherRopistory;
    private final ProjectManagerRepository projectManagerRepository;
    private final ReportRepository reportRepository;

    public DataLoader(RoleRepository roleRepository, UserRepository userRepository, PasswordEncoder passwordEncoder, TopicRepository topicRepository, TeacherRopistory teacherRopistory, ProjectManagerRepository projectManagerRepository, ReportRepository reportRepository) {
        this.roleRepository = roleRepository;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.topicRepository = topicRepository;
        this.teacherRopistory = teacherRopistory;
        this.projectManagerRepository = projectManagerRepository;
        this.reportRepository = reportRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        try {

            loadData();
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Transactional
    void loadData() {



        User harry = new User();
        harry.setName("Harry");
        harry.setEmail("harry@gmail.com");
        harry.setGitHubName("harrisonbrock");
        harry.setUsername("Crazy");
        harry.setPassword(passwordEncoder.encode("Password"));

        Role userRole = roleRepository.findByName(RoleName.ROLE_USER)
                .orElseThrow(() -> new ResourceNotFoundException(""));

        harry.setRoles(Collections.singleton(userRole));

        User cruise = new User();
        cruise.setUsername("Cruise");
        cruise.setGitHubName("duck");
        cruise.setEmail("cruise@react.engineer");
        cruise.setName("Bob");
        cruise.setPassword(passwordEncoder.encode("Password"));

        Role adminRole = roleRepository.findByName(RoleName.ROLE_USER).orElseThrow(null);
        cruise.setRoles(Collections.singleton(adminRole));

        userRepository.save(harry);
        userRepository.save(cruise);

        Topic CS = new Topic();
        Topic SQL = new Topic();
        Topic React = new Topic();

        CS.setName("CS");
        SQL.setName("SQL");
        React.setName("React");

        topicRepository.save(CS);
        topicRepository.save(SQL);
        topicRepository.save(React);

        ProjectManager PM1 = new ProjectManager();
        ProjectManager PM2 = new ProjectManager();
        ProjectManager PM3 = new ProjectManager();
        PM1.setName("Bob");
        PM2.setName("Bill");
        PM3.setName("Billy");

        projectManagerRepository.save(PM1);
        projectManagerRepository.save(PM2);
        projectManagerRepository.save(PM3);

        Teacher T1 = new Teacher();
        Teacher T2 = new Teacher();
        Teacher T3 = new Teacher();

        T1.setName("Beej");
        T2.setName("John");
        T3.setName("Ryan");

        teacherRopistory.save(T1);
        teacherRopistory.save(T2);
        teacherRopistory.save(T3);

        Report report = new Report();
        report.setUser(harry);
        report.setDescribeWeek("fun");
        report.setUrlSubmission("https://github.com");
        report.setWhatCouldHaveWentBetter("n/a");
        report.setWhatWentWellThisWeek("project");
        report.setWhatDidYouWorkOnThisWeek(CS.getName());

        report.setProjectmanager(PM1.getName());
        report.setTeacher(T1.getName());

        Report report2 = new Report();
        report2.setUser(cruise);
        report2.setDescribeWeek("bad");
        report2.setUrlSubmission("https://github.com/project");
        report2.setWhatCouldHaveWentBetter("------");
        report2.setWhatWentWellThisWeek("project");
        report2.setWhatDidYouWorkOnThisWeek(SQL.getName());

        report2.setProjectmanager(PM2.getName());
        report2.setTeacher(T2.getName());

        reportRepository.save(report);
        reportRepository.save(report2);



    }
}
