package com.raj.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.raj.dto.StudentDto;
import com.raj.entity.Student;
import com.raj.exception.StudentResourse;
import com.raj.repositary.StudentRepositary;



@Service
public class StudnetService implements IStudent {
	
	@Autowired
	private StudentRepositary repo;

	@Override
	public StudentDto save(StudentDto s) {
		
		Student stud=new Student();
		
		BeanUtils.copyProperties(s, stud);
		Student save = repo.save(stud);
		s.setId(save.getId());
		return s;
	}
	@Override
	public String saveAll(List<StudentDto> list) {
		
		List<Student> stud=new ArrayList<>();
		
		for(StudentDto val:list) {
			Student s=new Student();
			BeanUtils.copyProperties(val, s);
			stud.add(s);
		}
		
		List<Student> saveAll = repo.saveAll(stud);
		
		return "Data is save "+saveAll.size();
	}
	@Override
	public List<StudentDto> show() {
		List<StudentDto> studdto=new ArrayList<>();
		
		List<Student> list = repo.findAll();
		for(Student val:list) {
			StudentDto vo=new StudentDto();
			BeanUtils.copyProperties(val, vo);
			studdto.add(vo);
		}
		
		return studdto;
	}
	
	@Override
	public String updateData(Integer id,StudentDto s) {
		Student byId = repo.findById(id).get();
		if(byId==null) {
			throw new StudentResourse("id is not Found");
		}
		s.setId(byId.getId());
		BeanUtils.copyProperties(s, byId);
		Student save = repo.save(byId);
		
		System.out.println(byId);
	    
		return "Data is update with id ";
	}
	@Override
	public String updateDataMarks(Integer id, Double marks) {
		Student byId = repo.findById(id).get();
		if(byId==null) {
			throw new StudentResourse("id is not Found");
		}
		
		byId.setMarks(marks);
		Student save = repo.save(byId);
		return save.getName()+" Marks is update";
	}

	@Override
	public StudentDto findById(Integer id) {
		Student byId = repo.findById(id).get();
		if(byId==null) {
			throw new StudentResourse("id is not Found");
		}
		
		StudentDto d=new StudentDto();
		BeanUtils.copyProperties(byId, d);
		return d;
	}
}
