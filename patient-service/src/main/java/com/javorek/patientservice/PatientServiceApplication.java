package com.javorek.patientservice;

import com.javorek.patientservice.executor.MyExecutorService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.concurrent.Callable;

@SpringBootApplication
public class PatientServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(PatientServiceApplication.class, args);
	}

	/**
	List<Callable<String>> ukoly = List.of(
			() -> { Thread.sleep(300); return "Výsledek A"; },
			() -> { Thread.sleep(100); return "Výsledek B"; },
			() -> { Thread.sleep(200); return "Výsledek C"; },
			() -> { Thread.sleep(500); return "Výsledek D"; }
	);
	 */


}
