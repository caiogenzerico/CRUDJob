package br.com.crudjob;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.crudjob.empresa.EmpresaRepository;

@SpringBootApplication
public class CrudJobApplication {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	EmpresaRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(CrudJobApplication.class, args);
	}

}
