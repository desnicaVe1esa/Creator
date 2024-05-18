package app.back.service.impl;

import app.back.service.HomePracticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class HomePracticeServiceImpl implements HomePracticeService {

    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Autowired
    public void setNamedParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    @Override
    public  List<Map<String, Object>> getInfo() {
        String query = "select * from home_practice";
        List<Map<String, Object>> result = new ArrayList<>();
        result.add(namedParameterJdbcTemplate.queryForMap(query, new HashMap<>()));
        return result;
    }
}
