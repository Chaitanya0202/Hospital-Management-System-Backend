                                        package com.qsp.hospital_management.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Entity
@Data
public class Person {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@NotBlank(message = "Name Can Not  be Blank")
	@NotNull(message = "Name Can not be Null")
	private String name;
	@Column(unique = true)
	@Min(value = 6000000000l)
	@Max(value = 9999999999l)
	private long phone;
	@NotBlank(message = "Email Can Not  be Blank")
	@NotNull(message = "Email Can not be Null")
	@Email(regexp = "[a-z0-9._+]+@[a-z0-9]+\\.[a-z]{2,3}",message = "Email Invalid")
	private String email;
	@NotBlank(message = "Name Can Not  be Blank")
	@NotNull(message = "Name Can not be Null")
	private String address;
	
}
