package com.kma.saz_naukma;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SazNaukmaApplication {

	public static void main(String[] args) {
		SpringApplication.run(SazNaukmaApplication.class, args);
	}

//	@Bean
//	public CommandLineRunner demo(StudentRepository repository){
//		StudentEntity studentEntity = new StudentEntity();
//		studentEntity.setSurname("Kurash");
//		studentEntity.setFirstName("Yaroslava");
//		studentEntity.setEmail("yaroslava.kurash@ukma.edu.ua");
//		studentEntity.setFaculty("ФІ");
//		studentEntity.setLevel("бакалавр");
//		studentEntity.setPassword("123");
//		studentEntity.setSpecialization("Комп'ютерні науки");
//		studentEntity.setStudyYear("3");
//
////		repository.save(studentEntity);
//
//		return (args -> {
//			System.err.println(repository.findByEmail("yaroslava.kurash@ukma.edu.ua"));
//		});
//	}
}
