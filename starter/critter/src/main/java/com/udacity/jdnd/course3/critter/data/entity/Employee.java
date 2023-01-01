package com.udacity.jdnd.course3.critter.data.entity;

import com.udacity.jdnd.course3.critter.user.EmployeeSkill;
import jakarta.persistence.*;
import java.time.DayOfWeek;
import java.util.List;
import java.util.Set;

@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ElementCollection(targetClass = EmployeeSkill.class)
    @JoinTable(name = "skills", joinColumns = @JoinColumn(name = "employee_id"))
    @Column(name = "skills")
    @Enumerated(EnumType.STRING)
    private List<EmployeeSkill> skillList;
    @ElementCollection(targetClass = DayOfWeek.class)
    @JoinTable(name = "dayOfWeek", joinColumns = @JoinColumn(name = "employee_id"))
    @Column(name = "dayOfWeek")
    @Enumerated(EnumType.STRING)
    private Set<DayOfWeek> daysAvailable;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<EmployeeSkill> getSkillList() {
        return skillList;
    }

    public void setSkillList(List<EmployeeSkill> skillList) {
        this.skillList = skillList;
    }

    public Set<DayOfWeek> getDaysAvailable() {
        return daysAvailable;
    }

    public void setDaysAvailable(Set<DayOfWeek> daysAvailable) {
        this.daysAvailable = daysAvailable;
    }
}
