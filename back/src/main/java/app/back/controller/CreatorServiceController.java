package app.back.controller;

import app.back.model.TaskAndLanguages;
import app.back.service.CreatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/creator/")
public class CreatorServiceController {

    private CreatorService creatorService;

    @Autowired
    public void setCreatorService(CreatorService creatorService) {
        this.creatorService = creatorService;
    }

    @PostMapping("/createTemplates")
    public void createTemplates(@RequestBody TaskAndLanguages requestBody) {
        String id = requestBody.getTaskId();
        List<String> languages = requestBody.getLanguagesForSolution();
        creatorService.start(id, languages);
    }
}
