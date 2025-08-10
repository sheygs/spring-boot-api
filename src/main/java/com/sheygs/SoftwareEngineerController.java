package com.sheygs;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/software-engineers")
public class SoftwareEngineerController {

    private final SoftwareEngineerService softwareEngineerService;

    public SoftwareEngineerController(SoftwareEngineerService softwareEngineerService) {
        this.softwareEngineerService = softwareEngineerService;
    }

    // use DTOs
    @GetMapping
    public List<SoftwareEngineer> getEngineers(){
        return softwareEngineerService.getEngineers();
    }

    // use DTOs
    @PostMapping
    public void addEngineer(@RequestBody SoftwareEngineer softwareEngineer){
      softwareEngineerService.insertEngineer(softwareEngineer);
    }

    // use DTOs
    @GetMapping("{id}")
    public SoftwareEngineer getEngineerById(@PathVariable Integer id){
      return this.softwareEngineerService.getEngineerById(id);
    }

    // use DTOs
    @DeleteMapping("{id}")
    public SoftwareEngineer deleteEngineerById(@PathVariable Integer id){
        return this.softwareEngineerService.removeEngineer(id);
    }

    // use DTOs
    @PutMapping("{id}")
    public SoftwareEngineer updateEngineer(@PathVariable Integer id, @RequestBody SoftwareEngineer softwareEngineer){
        return this.softwareEngineerService.updateEngineer(id, softwareEngineer);
    }
}
