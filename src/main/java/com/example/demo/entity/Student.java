package com.example.demo.entity;

import java.time.LocalDate; 

public class Studententity {
    
    private String name;
    private int id;
    private LocalDate date;
    private float cgpa;
    public void setName(String name) {
        this.name = name;
    }
    public void setId(int id) {
        this.id = id;
    }
    public void setDate(LocalDate date) {
        this.date = date;
    }
    public void setCgpa(float cgpa) {
        this.cgpa = cgpa;
    }
    public String getName() {
        return name;
    }
    public int getId() {
        return id;
    }
    public LocalDate getDate() {
        return date;
    }
    public float getCgpa() {
        return cgpa;
    }
    public Studententity(String name, int id, LocalDate date, float cgpa) {
        this.name = name;
        this.id = id;
        this.date = date;
        this.cgpa = cgpa;
    }
}
