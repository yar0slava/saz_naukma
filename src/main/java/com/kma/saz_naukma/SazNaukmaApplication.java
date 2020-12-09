package com.kma.saz_naukma;

import com.kma.saz_naukma.core.database.repository.DisciplineRepository;
import com.kma.saz_naukma.core.database.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@EnableMongoRepositories(basePackageClasses = DisciplineRepository.class)
@EnableJpaRepositories(basePackageClasses = StudentRepository.class)
@SpringBootApplication
public class SazNaukmaApplication implements CommandLineRunner {

	@Autowired
	private DisciplineRepository disciplineRepository;

	@Autowired
	private StudentRepository studentRepository;

	public static void main(String[] args) {
		SpringApplication.run(SazNaukmaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

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
