package com.capgemini;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.capgemini.exception.CustomException;

@SpringBootApplication
public class WomenEmpowermentApplication {
	private static final Logger LOG = LoggerFactory.getLogger(CustomException.class);

	public static void main(String[] args) {

		LOG.info("START");
		SpringApplication.run(WomenEmpowermentApplication.class, args);
		LOG.info("End");
	}

}
