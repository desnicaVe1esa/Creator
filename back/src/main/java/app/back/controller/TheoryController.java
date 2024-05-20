package app.back.controller;

import app.back.service.HomePracticeService;
import app.back.service.WorkService;
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
    private WorkService workService;

    @Autowired
    public void setHomePracticeService(HomePracticeService homePracticeService) {
        this.homePracticeService = homePracticeService;
    }

    @Autowired
    public void setWorkService(WorkService workService) {
        this.workService = workService;
    }

    @GetMapping("/homePractice")
    public List<Map<String, Object>> homePractice () {
        return homePracticeService.getInfo();
    }

    @GetMapping("/work")
    public List<Map<String, Object>> work () {
        return workService.getInfo();
    }
}
