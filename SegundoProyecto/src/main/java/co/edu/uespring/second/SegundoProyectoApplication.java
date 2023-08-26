package co.edu.uespring.second;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication

@ComponentScan(basePackages ={"co.edu.uespring.second.controller" } )
public class SegundoProyectoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SegundoProyectoApplication.class, args);
		
	}

}

