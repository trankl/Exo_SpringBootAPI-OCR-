package com.exo.WebStroreAPI.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table (name="user")
public class User {

	
	 @Id
	  @GeneratedValue(strategy=GenerationType.AUTO)
	  private Integer id;

	  private String name;

	  private String email;
}
