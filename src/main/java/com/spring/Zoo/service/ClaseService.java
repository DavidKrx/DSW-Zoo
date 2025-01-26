package com.spring.Zoo.service;

import com.spring.Zoo.model.Animal;
import com.spring.Zoo.model.Clase;
import com.spring.Zoo.repository.ClaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClaseService {

    @Autowired
    private ClaseRepository claseRepository;

    public List<Clase> getAllClases() {
        return claseRepository.findAll();
    }

    public Clase saveClase(Clase clase) {
        return claseRepository.save(clase);
    }
    public Clase getClaseById(Integer id) {
        Optional<Clase> optionalClase = claseRepository.findById(id);
        return optionalClase.orElse(null);
    }
}

