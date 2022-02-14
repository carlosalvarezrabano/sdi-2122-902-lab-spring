package com.uniovi.sdi2122902spring.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Professor {
    @Id
    private String dni;
    private String name;
    private String surname;
    private String department;

    public Professor() { }

    public Professor(String dni, String name, String surname, String department) {
        this.dni = dni;
        this.name = name;
        this.surname = surname;
        this.department = department;
    }

    @Override
    public String toString() {
        return "Professor{" + "dni=" + dni + ", name=" + name + ", surname=" + surname + ", department= " + department + '}';
    }

    public String getDni() {
        return dni;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getDepartment() {
        return department;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
}
