package com.hello;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/demo")
@RestController
public class FileProcessor {
	
	@Autowired
	FileProcessorService fileProcessorService;
    @RequestMapping("/index")
    public String index() {
        return "Greetings from Spring Boot!";
    }
    
    @GetMapping("/get")
    public List<JsonData> getData(){
    	return fileProcessorService.getList();
    }
    
    @GetMapping("/getusers")
    public List<User> getUsers(){
    	return fileProcessorService.getAll();
    }

    @GetMapping("/getId")
    public User getById(@RequestParam Long id){
        return fileProcessorService.getById(id);
    }
    @GetMapping("/getId/{id}")
    public User getByPathVariableId(@PathVariable Long id){
        return fileProcessorService.getById(id);
    }
}
