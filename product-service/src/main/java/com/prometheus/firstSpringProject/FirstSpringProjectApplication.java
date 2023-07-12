package com.prometheus.firstSpringProject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@SpringBootApplication
@RestController
public class FirstSpringProjectApplication {

    private final UserRepository userRepository;

    @Autowired
    public FirstSpringProjectApplication(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public static void main(String[] args) {
		SpringApplication.run(FirstSpringProjectApplication.class, args);
	}

	@GetMapping("/")
	public GreetResponse greet(){
        GreetResponse response = new GreetResponse(
                "Hello there",
                List.of("Java", "GoLang", "Python"),
                new Person("Robin", 30, 90_000)
        );

        return response;
    }

    record Person(
            String name, int age, int savings
    ){}
    record GreetResponse(
            String welcomeText,
            List<String> Lang,
            Person person
    ){}

    @GetMapping("/get-users")
    public List<Admin> getUsers(){
        return userRepository.findAll();
    }

    @PostMapping("/create-admin")
    @ResponseStatus(HttpStatus.CREATED)
    public void createAdmin(@RequestBody Admin admin){
        userRepository.save(admin);
    }
}
