package com.kma.saz_naukma;

import com.kma.saz_naukma.database.entity.StudentEntity;
import com.kma.saz_naukma.database.repository.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

@SpringBootApplication
public class SazNaukmaApplication {

	public static void main(String[] args) {
		SpringApplication.run(SazNaukmaApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(StudentRepository repository){
		StudentEntity studentEntity = new StudentEntity();
		studentEntity.setSurname("Kurash");
		studentEntity.setFirstName("Yaroslava");
		studentEntity.setEmail("yaroslava.kurash@ukma.edu.ua");
		studentEntity.setFaculty("ФІ");
		studentEntity.setLevel("бакалавр");
		studentEntity.setPassword("123");
		studentEntity.setSpecialization("Комп'ютерні науки");
		studentEntity.setStudyYear("3");

//		repository.save(studentEntity);

		return (args -> {
			System.err.println(repository.findByEmail("yaroslava.kurash@ukma.edu.ua"));
		});
	}
}
