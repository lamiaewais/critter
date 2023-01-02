package com.udacity.jdnd.course3.critter.data.entity;

import com.udacity.jdnd.course3.critter.user.EmployeeSkill;
import jakarta.persistence.*;
import org.hibernate.annotations.Nationalized;

import java.time.DayOfWeek;
import java.util.Set;

@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Nationalized
    private String name;

    @ElementCollection(targetClass = EmployeeSkill.class)
    @JoinTable(name = "skills", joinColumns = @JoinColumn(name = "employee_id"))
    @Column(name = "skills")
    @Enumerated(EnumType.STRING)
    private Set<EmployeeSkill> skillList;

    @ElementCollection(targetClass = DayOfWeek.class)
    @JoinTable(name = "dayOfWeek", joinColumns = @JoinColumn(name = "employee_id"))
    @Column(name = "dayOfWeek")
    @Enumerated(EnumType.STRING)
    private Set<DayOfWeek> daysAvailable;

    public Employee() {
    }

    public Employee(Long id, String name, Set<EmployeeSkill> skillList, Set<DayOfWeek> daysAvailable) {
        this.id = id;
        this.name = name;
        this.skillList = skillList;
        this.daysAvailable = daysAvailable;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<EmployeeSkill> getSkillList() {
        return skillList;
    }

    public void setSkillList(Set<EmployeeSkill> skillList) {
        this.skillList = skillList;
    }

    public Set<DayOfWeek> getDaysAvailable() {
        return daysAvailable;
    }

    public void setDaysAvailable(Set<DayOfWeek> daysAvailable) {
        this.daysAvailable = daysAvailable;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
