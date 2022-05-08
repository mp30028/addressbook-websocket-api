package com.zonesoft.addressbook.repositories;

import org.springframework.data.repository.CrudRepository;

import com.zonesoft.addressbook.entities.Person;

public interface PersonRepository extends  CrudRepository<Person, Long> {

}
