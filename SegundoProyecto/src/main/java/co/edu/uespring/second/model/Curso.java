package co.edu.uespring.second.model;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlRootElement;

import co.edu.uespring.second.model.Curso;

@XmlRootElement

public class Curso {
	
	private String name;
	private double duration;
	private double cost;
	private int ability;
	

	public Curso(String name, double duration, double cost, int ability) {
		super();
		this.name = name;
		this.duration = duration;
		this.cost = cost;
		this.ability = ability;
	}
	
	public Curso() {
		super();
	}

	public static ArrayList<Curso> myListCourses(){
		ArrayList<Curso> cursos = new ArrayList<>();
		cursos.add(new Curso("JavaScript", 20.0, 10.0, 24));
		cursos.add(new Curso("Java", 40.0, 20.0, 24));
		cursos.add(new Curso("PHP", 40.0, 12.0, 24));
		return cursos;
	}
	
	public static ArrayList<Curso> searchCourses(String name){
		ArrayList<Curso> cursos_aux = myListCourses();
		ArrayList<Curso> cursos_return = new ArrayList<>();
		
		for (Curso curso : cursos_aux) {
			if (curso.getName().contains(name)) {
				cursos_return.add(curso);
			}
		}
		
		return cursos_return;
	}
	
	public ArrayList<Curso> postCurso(Curso curso){
		ArrayList<Curso> cursos = myListCourses();
		
		return cursos;
	}
	
	public ArrayList<Curso> putCurso(String name, double duration, double cost, int ability) {
	    ArrayList<Curso> cursos = myListCourses();

	    for (Curso curso : cursos) {
	        if (curso.getName().equals(name)) {
	            curso.setName(name);
	            curso.setDuration(duration);
	            curso.setCost(cost);
	            curso.setAbility(ability);
	            break;
	        }
	    }

	    return cursos;
	}

	
	public ArrayList<Curso> deleteCurso(String name){
		ArrayList<Curso> cursos = new ArrayList<>();
		cursos = myListCourses();
		cursos.removeIf(c->c.getName().equals(name));
		return cursos;
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public double getDuration() {
		return duration;
	}
	
	public void setDuration(double duration) {
		this.duration = duration;
	}
	
	public double getCost() {
		return cost;
	}
	
	public void setCost(double cost) {
		this.cost = cost;
	}
	
	public int getAbility() {
		return ability;
	}
	
	public void setAbility(int ability) {
		this.ability = ability;
	}
}
