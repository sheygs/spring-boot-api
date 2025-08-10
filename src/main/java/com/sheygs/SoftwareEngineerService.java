package com.sheygs;


import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SoftwareEngineerService {
    private final SoftwareEngineerRepository softwareEngineerRepository;
    private final AIService aiService;

    public SoftwareEngineerService(SoftwareEngineerRepository softwareEngineerRepository, AIService aiService){
         this.softwareEngineerRepository = softwareEngineerRepository;
         this.aiService = aiService;
    }

    // preferred: use DTO
    public List<SoftwareEngineer> getEngineers(){
      return this.softwareEngineerRepository.findAll();
    }

    // preferred: use DTO
    public void insertEngineer(SoftwareEngineer softwareEngineer) {
      var prompt = """
           Based on the programming tech stack %s that %s has given, provide a full learning path and recommendations for this user.
          """.formatted(softwareEngineer.getTechStack(), softwareEngineer.getName());

      String chatResponse = this.aiService.chat(prompt);

      softwareEngineer.setLearningPathRecommendation(chatResponse);

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
