package com.sheygs;

import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;

@Entity
public class SoftwareEngineer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private List<String> techStack;
    @Column(columnDefinition = "TEXT")
    private String learningPathRecommendation;

    public SoftwareEngineer(){}

    public SoftwareEngineer(Integer id,  String name, List<String> techStack, String learningPathRecommendation) {
        this.id = id;
        this.name = name;
        this.techStack = techStack;
        this.learningPathRecommendation = learningPathRecommendation;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getTechStack() {
        return techStack;
    }

    public void setTechStack(List<String> techStack) {
        this.techStack = techStack;
    }

    public String getLearningPathRecommendation() {
        return learningPathRecommendation;
    }

    public void setLearningPathRecommendation(String learningPathRecommendation) {
        this.learningPathRecommendation = learningPathRecommendation;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        SoftwareEngineer that = (SoftwareEngineer) o;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name) && Objects.equals(techStack, that.techStack) && Objects.equals(learningPathRecommendation, that.learningPathRecommendation);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, techStack, learningPathRecommendation);
    }
}
