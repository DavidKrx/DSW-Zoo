package com.spring.Zoo.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.validation.constraints.*;

@Entity
public class Animal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull(message = "Este campo no puede quedar vacío")
    @NotBlank(message = "Este campo no puede estar en blanco")
    @Size(min=3,max=15, message = "Tiene que tener un valor comprendido entre 3 y 15")
    private String Name;
    @NotNull
    @Min(value = 1, message = "El minimo es 1")
    @Max(value = 10, message = "El maximo es 10")
    private Integer AverageLifeAge;
    @NotNull(message = "Este campo no puede ser vacío")
    private boolean Extinct;

    @ManyToOne
    @JoinColumn(name = "clase_id", nullable = false)
    private Clase clase;

    // Getters y Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public Integer getAverageLifeAge() {
        return AverageLifeAge;
    }

    public void setAverageLifeAge(Integer averageLifeAge) {
        AverageLifeAge = averageLifeAge;
    }

    public boolean isExtinct() {
        return Extinct;
    }

    public void setExtinct(boolean extinct) {
        Extinct = extinct;
    }

    public Clase getClase() {
        return clase;
    }

    public void setClase(Clase clase) {
        this.clase = clase;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "id=" + id +
                ", Name='" + Name + '\'' +
                ", AverageLifeAge=" + AverageLifeAge +
                ", Extinct=" + Extinct +
                ", clase=" + clase +
                '}';
    }
}

