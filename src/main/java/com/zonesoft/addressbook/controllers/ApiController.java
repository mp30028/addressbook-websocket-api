package com.zonesoft.addressbook.controllers;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.zonesoft.addressbook.entities.Person;
import com.zonesoft.addressbook.repositories.PersonRepository;

@RestController
@RequestMapping("/persons")
public class ApiController {
	private static final Logger LOGGER = LoggerFactory.getLogger(ApiController.class);
	
	private final PersonRepository personRepository;
	
	public ApiController(PersonRepository personRepository) {
		this.personRepository = personRepository;
	}
	
	
	@GetMapping("/get-all")
	@ResponseBody
	public List<Person> getAll(){
		return (List<Person>) personRepository.findAll();
	}
	
	@PostMapping("/add-new")
	@ResponseBody
	public Person addNew(@RequestBody  Person person) {
		LOGGER.debug("Adding new person {}", person.toString());
		return personRepository.save(person);
	}
	
	@GetMapping("/by-id/{id}")
	@ResponseBody
	public Optional<Person> getById(@PathVariable Long id) {
		Optional<Person> resultOfFind = personRepository.findById(id);
		return resultOfFind;
	}
	
	@DeleteMapping("delete/{id}")
	@ResponseBody
	public Optional<Person> delete(@PathVariable  Long id){
		Optional<Person> resultOfFind = getById(id);		
		if(resultOfFind.isPresent()) personRepository.deleteById(id);
		return resultOfFind;
	}
	
}
