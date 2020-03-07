package de.itgain.hdl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class HdlApplication {

	public static void main(String[] args) {
		SpringApplication.run(HdlApplication.class, args);
	}

}
