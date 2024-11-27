package com.ntt.Catalogue.models;

public class Employee {
	private Long id;
	private String nom;
	private String label;
	private Integer salary;
	public Long getId() {
		return id;
	}
	public Employee(Long id, String nom, String label, Integer salary) {
        this.id = id;
        this.nom = nom;
        this.label = label;
        this.salary = salary;
    }
	public void setId(Long id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public Integer getSalary() {
		return salary;
	}
	public void setSalary(Integer salary) {
		this.salary = salary;
	}
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
}
