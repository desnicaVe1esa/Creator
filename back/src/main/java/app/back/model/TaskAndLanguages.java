package app.back.model;

import java.util.List;

public class TaskAndLanguages {

    private String taskId;
    private List<String> languagesForSolution;

    public TaskAndLanguages(){}

    public String getTaskId() {
        return taskId;
    }

    public List<String> getLanguagesForSolution() {
        return languagesForSolution;
    }

}
