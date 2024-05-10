package app.back.service;

import java.util.Map;

public interface CodeTakerService {

    Map<String, String> preparedData(String url, String language);
}
