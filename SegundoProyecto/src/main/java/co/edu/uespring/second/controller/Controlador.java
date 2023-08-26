package co.edu.uespring.second.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import co.edu.uespring.second.model.Curso;

@RestController

public class Controlador {
	
	Curso curso;
	
	@PostConstruct
	public void init() {
		 curso = new Curso();
	}
	
	@GetMapping (value="cursos", produces=MediaType.APPLICATION_XML_VALUE)
	public List<Curso> getCursos() {
		return Curso.myListCourses();
			
	}		
	@GetMapping (value="Curso", produces=MediaType.APPLICATION_XML_VALUE)
	public 	Curso getCourse() {
		return new Curso( "NET",30.0,10,24);
			
	}	
	@GetMapping (value="cursos/{name}",produces=MediaType.APPLICATION_XML_VALUE)
	public List<Curso> searchCourse(@PathVariable("name") String nam) {
		return Curso.searchCourses(nam);
	
	}
	
	@PostMapping( value="Curso", consumes=MediaType.APPLICATION_XML_VALUE, produces=MediaType.APPLICATION_XML_VALUE)
	public List<Curso> postCourse(@RequestBody Curso c){
		return curso.postCurso(c);
	}

	@PutMapping(value = "cursos/{name}", consumes = MediaType.APPLICATION_XML_VALUE)
	public ArrayList<Curso> putCurso(@PathVariable("name") String name, @RequestBody Curso cursoToUpdate) {
	    ArrayList<Curso> cursos = Curso.myListCourses(); 

	    for (Curso curso : cursos) {
	        if (curso.getName().equals(name)) {
	        	curso.setName(cursoToUpdate.getName());
	            curso.setDuration(cursoToUpdate.getDuration());
	            curso.setCost(cursoToUpdate.getCost());
	            curso.setAbility(cursoToUpdate.getAbility());
	            break;
	        }
	    }

	    return cursos; 
	}


	@DeleteMapping(value="cursos/{name}")
	public List<Curso> deleteCurso(@PathVariable("name") String name) {
		return curso.deleteCurso(name);
	}
	
}