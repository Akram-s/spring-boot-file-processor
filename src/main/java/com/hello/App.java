package com.hello;


import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Hello world!
 *
 */
@SpringBootApplication
public class App implements CommandLineRunner
{
	@Autowired
	ObjectMapper mapper;

	@Autowired
	FileProcessorService service;
	
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        SpringApplication.run(App.class, args);
    }

	@Override
	public void run(String... args) throws Exception {
		List<JsonData> jsonDataList = mapper.readValue(App.class.getClassLoader()
				.getResource("file.json"),mapper.getTypeFactory()
				.constructCollectionType(List.class, JsonData.class));
		
		for(JsonData json: jsonDataList){
			System.out.println(json.toString());
		}
		service.saveToMemory(jsonDataList);
		
List<User> userList = mapper.readValue(App.class.getClassLoader().getResource("users.json"),mapper.getTypeFactory().constructCollectionType(List.class, User.class));
		
		for(User user: userList){
			System.out.println(user.toString());
			service.save(user);
		}
	
	}
}




