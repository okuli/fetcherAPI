package com.simulated.chunksDataAPI;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement
@SpringBootApplication
public class ChunksDataApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ChunksDataApiApplication.class, args);
	}

}
