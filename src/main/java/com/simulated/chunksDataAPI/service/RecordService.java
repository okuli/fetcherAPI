package com.simulated.chunksDataAPI.service;

import com.simulated.chunksDataAPI.dto.RecordDto;
import com.simulated.chunksDataAPI.model.RecordEntity;
import com.simulated.chunksDataAPI.repository.RecordRepository;
import com.simulated.chunksDataAPI.util.ApiClient;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

@Service
public class RecordService {
    private static final String API_URL = "http://localhost:8082/api/records";
    private static final int PAGE_SIZE = 1000;

    private final ApiClient apiClient;
    private final RecordRepository recordRepository;

    public RecordService(ApiClient apiClient, RecordRepository recordRepository) {
        this.apiClient = apiClient;
        this.recordRepository = recordRepository;
    }

    @Transactional
    public void fetchAndStoreRecords() {
        int page = 0;

        while (true) {
            String url = API_URL + "?page=" + page + "&size=" + PAGE_SIZE;
            RecordDto[] records = apiClient.fetchRecords(url);

            if (records == null || records.length == 0) {
                break;
            }

            List<RecordEntity> entities = Arrays.stream(records)
                    .map(r -> new RecordEntity(r.getId(), r.getName()))
                    .collect(Collectors.toList());

            recordRepository.saveAll(entities);
            page++;
        }
    }
}