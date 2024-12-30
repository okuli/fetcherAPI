package com.simulated.chunksDataAPI.util;

import com.simulated.chunksDataAPI.dto.RecordDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ApiClient {
    private final RestTemplate restTemplate = new RestTemplate();

    public RecordDto[] fetchRecords(String url) {
        return restTemplate.getForObject(url, RecordDto[].class);
    }
}