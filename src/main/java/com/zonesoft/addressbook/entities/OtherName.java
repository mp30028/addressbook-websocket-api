package com.zonesoft.addressbook.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Entity
@Table(name="t_other_name")
public class OtherName {
	private static final Logger LOGGER = LoggerFactory.getLogger(OtherName.class);
	private Long id;
	private String otherName;
	private Person person;
	private OtherNameType otherNameType;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "other_name_id")
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getOtherName() {
		return this.otherName;
	}

	public void setOtherName(String otherName) {
		this.otherName = otherName;
	}

	
	//JsonIgnore, So that when serialising this class to json using the jackson library 
	//we want to skip serialising this field, else we get a circular reference happening.
	//
	//FetchType.EAGER because we want to load person to whom the other-name belongs always.
	//
	//'name' is the name of the field in this entitie's table used to join with the referenced table
	//
	@JsonIgnore	
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "person_id", referencedColumnName = "person_id")
	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "other_name_type_id", referencedColumnName = "other_name_type_id")
	public OtherNameType getOtherNameType() {
		return this.otherNameType;
	}

	public void setOtherNameType(OtherNameType otherNameType) {
		this.otherNameType = otherNameType;
	}

	@JsonIgnore
	@Override
	public String toString() {
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.findAndRegisterModules();
		String json = null;
		try {
			json = objectMapper.writeValueAsString(this);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
			String message = "<EXCEPTION - whilst writing OtherName Object to JSON. " + e.getLocalizedMessage() + ">" ;
			LOGGER.error(message);
			return message;
		}
		return json;
	}
	
}
