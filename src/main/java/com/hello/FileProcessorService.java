package com.hello;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;
import java.util.Optional;
@Service
public class FileProcessorService {
	@Autowired
	UserRepository userRepository;
	
	List<JsonData> userList; 
	public List<JsonData> getList(){
		return userList;
	}
	
	public void saveToMemory(List<JsonData> jsonDataList){
		this.userList = jsonDataList;
	}
	
	public void save(User user){
		userRepository.save(user);
		
	}
	
	public List<User> getAll(){
		return userRepository.findAll();
	}
	public User getById(Long id){

		return userRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("Id: " + id + " not found."));
	}

	
}
