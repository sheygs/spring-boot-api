package com.sheygs;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SoftwareEngineerService {
    private final SoftwareEngineerRepository softwareEngineerRepository;

    public SoftwareEngineerService(SoftwareEngineerRepository softwareEngineerRepository){
         this.softwareEngineerRepository = softwareEngineerRepository;
    }

    // preferred: use a DTO
    public List<SoftwareEngineer> getEngineers(){
      return this.softwareEngineerRepository.findAll();
    }
}
