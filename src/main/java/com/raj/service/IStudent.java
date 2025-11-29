package com.raj.service;

import java.util.List;

import com.raj.dto.StudentDto;

public interface IStudent {
	StudentDto save(StudentDto s);
	String saveAll(List<StudentDto> s);
	List<StudentDto> show();
	String updateData(Integer id,StudentDto s);
	String updateDataMarks(Integer id,Double marks);
	StudentDto findById(Integer id);

}
