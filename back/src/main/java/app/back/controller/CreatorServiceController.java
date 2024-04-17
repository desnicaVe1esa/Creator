package app.back.controller;

import app.back.service.CreatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", maxAge = 4800)
@RestController
@RequestMapping("/creator/")
public class CreatorServiceController {

    private CreatorService creatorService;

    @Autowired
    public void setCreatorService(CreatorService creatorService) {
        this.creatorService = creatorService;
    }

    @PostMapping("/createTemplates")
    public void createTemplates(@RequestBody String id) {
        creatorService.start(id);
    }
}
