package com.simulated.chunksDataAPI.controller;

import com.simulated.chunksDataAPI.service.RecordService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FetchController {
    private final RecordService recordService;

    public FetchController(RecordService recordService) {
        this.recordService = recordService;
    }

    @GetMapping("/fetch-records")
    public String fetchRecords() {
        recordService.fetchAndStoreRecords();
        return "Records fetched and stored successfully!";
    }
}