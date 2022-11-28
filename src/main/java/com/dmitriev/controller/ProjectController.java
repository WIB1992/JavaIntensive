package com.dmitriev.controller;

import com.dmitriev.entity.Position;
import com.dmitriev.entity.Project;
import com.dmitriev.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ProjectController {
    private final ProjectService projectService;
    @Autowired
    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @GetMapping("/projects")
    public List<Project> showAllProject() {
        List<Project> allProjects = projectService.getProjects();
        return allProjects;
    }
    @GetMapping("/projects/{id}")
    public Project getProject(@PathVariable int id) {
        Project project = projectService.getProject(id);
        return project;
    }
    @PostMapping("/projects")
    public Project addNewPosition(@RequestBody Project project) {
        projectService.saveProject(project);
        return project;
    }
    @PutMapping("/projects")
    public Project updatePosition(@RequestBody Project project) {
        projectService.saveProject(project);
        return project;
    }
    @DeleteMapping("/projects/{id}")
    public String deletePosition(@PathVariable int id) {
        projectService.deleteProject(id);
        return "Project with id = " + id + " was deleted";
    }
}
