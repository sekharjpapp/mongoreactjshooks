package com.pixel;

import com.pixel.entity.*;
import com.pixel.repository.*;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import reactor.core.publisher.Flux;

import java.util.stream.IntStream;
import java.util.stream.Stream;

@SpringBootApplication
@Log4j2
public class MongoDbReactiveSampleApp {

	@Autowired
	private ReservationRepository reservationRepository;

	@Autowired
	private BookRepository bookRepository;

	@Autowired
	private StudentRepository studentRepository;
	@Autowired
	private TaskRepository taskRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

	public static void main(String[] args) {
		SpringApplication.run(MongoDbReactiveSampleApp.class, args);
	}

	@EventListener(ApplicationReadyEvent.class)
	public void go() {
		var names = Flux.just("Tom","Bob","Chris","Josh","Jerry")
				.map(name-> new Reservation(null,name))
				.flatMap(this.reservationRepository::save);
		this.reservationRepository.deleteAll().thenMany(names).thenMany(this.reservationRepository.findAll()).subscribe(log::info);

		bookRepository.deleteAll();
		taskRepository.deleteAll();
		var bookFlux = Flux.range(1, 5)
				.map(i -> new Book(i, "book Name" + i, "Author Name" + i));
		bookFlux.subscribe(log::info);
		/*var studentNames = Flux.range(1, 5)
				.map(e -> new Student(null, "Student firstName " + e, "Student lastnameName "+e))
				.flatMap(this.studentRepository::save);
		this.studentRepository.deleteAll()
				.thenMany(studentNames)
				.thenMany(this.studentRepository.findAll())
				.subscribe(log::info);*/
		employeeRepository.deleteAll();
		var employeeStream = Flux.range(1, 10)
				.map(i -> new Employee(null, "name " + i, "firstName " + i, i, "IT " + i))
				.flatMap(this.employeeRepository::save);
		employeeStream.subscribe(log::info);
		Book book = new Book();
		book.setBookName("Scala");
		book.setAuthorName("Martin Odersky");
		bookRepository.save(book);
		Task task = new Task();
		task.setTaskId(null);
		task.setDescription("add cronJobs");
		task.setSeverity(2);
		task.setAssignee("Bob");
		task.setStoryPoint(1);
		taskRepository.save(task);
		//Retain Only Digits and Decimal Separator in String
		String s = "Testing abc123.555abc";
		s = s.replaceAll("[^\\d.]", "");
		log.info(s);
	}
}
