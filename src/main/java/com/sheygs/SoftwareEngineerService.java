package com.sheygs;


import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SoftwareEngineerService {
    private final SoftwareEngineerRepository softwareEngineerRepository;

    public SoftwareEngineerService(SoftwareEngineerRepository softwareEngineerRepository){
         this.softwareEngineerRepository = softwareEngineerRepository;
    }

    // preferred: use DTO
    public List<SoftwareEngineer> getEngineers(){
      return this.softwareEngineerRepository.findAll();
    }

    // preferred: use DTO
    public void insertEngineer(SoftwareEngineer softwareEngineer) {
      this.softwareEngineerRepository.save(softwareEngineer);
    }

    // preferred: use DTO
    public SoftwareEngineer getEngineerById(Integer id) {
        return this.softwareEngineerRepository.findById(id).orElseThrow(() -> new IllegalStateException(id + " not found"));
    }

    // preferred: use DTO
    public SoftwareEngineer removeEngineer(Integer id) {
        var engineer = this.getEngineerById(id);

        if (engineer == null) {
            throw new IllegalArgumentException(id + " not found");
        }

        this.softwareEngineerRepository.deleteById(engineer.getId());

        return engineer;
    }

    // preferred: use DTO
    public SoftwareEngineer updateEngineer(Integer id, SoftwareEngineer softwareEngineer) {
        var engineer = this.getEngineerById(id);

        if (engineer == null) {
            throw new IllegalArgumentException(id + " not found");
        }

        engineer.setName(softwareEngineer.getName());
        engineer.setTechStack(softwareEngineer.getTechStack());

        return this.softwareEngineerRepository.save(engineer);
    }
}
