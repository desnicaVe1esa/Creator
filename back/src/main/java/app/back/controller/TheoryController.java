package app.back.controller;

import app.back.service.HomePracticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/theory/")
public class TheoryController {

    private HomePracticeService homePracticeService;

    @Autowired
    public void setHomePracticeService(HomePracticeService homePracticeService) {
        this.homePracticeService = homePracticeService;
    }

    @GetMapping("/homePractice")
    public List<Map<String, Object>> homePractice () {
        return homePracticeService.getInfo();
    }
}
