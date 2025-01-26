package com.spring.Zoo.service;

import com.spring.Zoo.model.Animal;
import com.spring.Zoo.repository.AnimalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AnimalService {

    @Autowired
    private AnimalRepository animalRepository;

    // Obtener todos los animales
    public List<Animal> getAllAnimales() {
        return animalRepository.findAll();
    }

    // Obtener un animal por su ID
    public Animal getAnimalById(Integer id) {
        Optional<Animal> optionalAnimal = animalRepository.findById(id);
        return optionalAnimal.orElse(null);
    }

    // Crear o guardar un nuevo animal
    public Animal saveAnimal(Animal animal) {
        return animalRepository.save(animal);
    }

    // Actualizar un animal existente
    public Animal updateAnimal(Integer id, Animal updatedAnimal) {
        Optional<Animal> optionalAnimal = animalRepository.findById(id);
        if (optionalAnimal.isPresent()) {
            Animal existingAnimal = optionalAnimal.get();
            existingAnimal.setName(updatedAnimal.getName());
            existingAnimal.setClase(updatedAnimal.getClase());
            return animalRepository.save(existingAnimal);
        } else {
            return null;
        }
    }

    // Eliminar un animal por su ID
    public boolean deleteAnimal(Integer id) {
        if (animalRepository.existsById(id)) {
            animalRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}

