package com.qsp.hospital_management.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Entity
@Data
public class Hospital {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@NotBlank(message = "Name Can Not  be Blank")
	@NotNull(message = "Name Can not be Null")
	private String name;
	@NotBlank(message = "Address Can Not  be Blank")
	@NotNull(message = "Address Can not be Null")
	private String email;
	private String ceo;
}
