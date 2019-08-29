package com.hello;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class JsonData {
private Long id;
private String name;

@JsonCreator
public JsonData(@JsonProperty("id") Long id, @JsonProperty("name") String name){
	this.id = id;
	this.name = name;
}

/**
 * @return the id
 */
public Long getId() {
	return id;
}
/**
 * @param id the id to set
 */
public void setId(Long id) {
	this.id = id;
}
/**
 * @return the name
 */
public String getName() {
	return name;
}
/**
 * @param name the name to set
 */
public void setName(String name) {
	this.name = name;
}
@Override
public String toString(){
	
	return "{\"id\": " + getId() + ",\"name\": " + getName() + "}";
}

}
