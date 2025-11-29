package com.raj.controler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.raj.dto.StudentDto;
import com.raj.exception.StudentResourse;
import com.raj.service.IStudent;

@RestController
@RequestMapping("/Student")
public class StudentContoler {

	
   @Autowired
   private IStudent service;
   
   @GetMapping("/find/{id}")
   public ResponseEntity<StudentDto>  findById(@PathVariable Integer id){
	   StudentDto byId = service.findById(id);
	return ResponseEntity.ok(byId);
	   
   }

	
    @PostMapping("/add")
	public ResponseEntity<StudentDto> add(@RequestBody StudentDto vo ){
		
		 StudentDto dto = service.save(vo);
		if(dto ==null) {
			throw new StudentResourse("Data is not save");
		}
		return ResponseEntity.ok(dto);
	}
    
    @PostMapping("/bulk")
	public ResponseEntity<String> addAll(@RequestBody List<StudentDto> vo ){
		
		  String saveAll = service.saveAll(vo);
		if(saveAll ==null) {
			throw new StudentResourse("Data is not save");
		}
		return ResponseEntity.ok(saveAll);
	}
    
    @GetMapping("/show")
    public ResponseEntity<List<StudentDto>> show(){
    	List<StudentDto> show = service.show();
    	
    	if(show==null) {
    		throw new StudentResourse("Data is not Found");
    	}
		return ResponseEntity.ok(show);
    	
    }
    
    @PutMapping("/fullUpdate/{id}")
    public ResponseEntity<String> fullUpdate(@PathVariable Integer id,@RequestBody StudentDto d){
    	String updateData = service.updateData(id, d);
		return ResponseEntity.ok(updateData);
    }
    
    @PatchMapping("/parUpdate/{id}/{marks}")
    public ResponseEntity<String> parUpdate(@PathVariable Integer id, @PathVariable Double marks){
    	String updateData = service.updateDataMarks(id, marks);
		return ResponseEntity.ok(updateData);
    }
    
    
    
    
}
