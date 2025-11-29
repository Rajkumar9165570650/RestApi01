package com.raj.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentDto {

	private Integer id;
	private String name;
	private String address;
	private Double marks;
}
