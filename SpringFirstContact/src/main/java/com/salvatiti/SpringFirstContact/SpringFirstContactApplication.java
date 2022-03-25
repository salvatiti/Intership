package com.salvatiti.SpringFirstContact;

import com.salvatiti.SpringFirstContact.student.Student;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@SpringBootApplication
@RestController //allow HTTP request using an API REST
public class SpringFirstContactApplication {

    public static void main(String[] args) {

        SpringApplication.run(SpringFirstContactApplication.class, args);

    }
    /*	@GetMapping //for getting something out from our server
	public String helloWorld(){
		return "Hello World";
	}*/


    @GetMapping //for getting something out from our server(it gives u back a JSON array back)
    public List<Student> studentData() {
        return List.of(
                new Student(
                        1111111L,
                        "Salva",
                        "salvatiti1@gmail.com",
                        LocalDate.of(1992, Month.SEPTEMBER,11),
                        29
                )
        );
    }

}
