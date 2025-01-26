package com.spring.Zoo.controller;

import com.spring.Zoo.model.Animal;
import com.spring.Zoo.service.AnimalService;
import com.spring.Zoo.service.ClaseService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/animal")
public class AnimalController {

    @Autowired
    private AnimalService animalService;

    @Autowired
    private ClaseService claseService;

    @GetMapping("/")
    public String animales(Model model){
        model.addAttribute("animales",animalService.getAllAnimales());
        return "index";
    }

    @GetMapping("/animal/details/{id}")
    public String detailsAnimal(@PathVariable Integer id,Model model){
        Integer a=id-1;
        model.addAttribute("animal",animalService.getAnimalById(a));
        return "animal/details";
    }
    @GetMapping("/animal/create")
    public String goCreateAnimal(Model model){
        model.addAttribute("animal",new Animal());
        model.addAttribute("clases",claseService.getAllClases());
        return "animal/create";
    }

    @PostMapping("/animal/create")
    public String createAnimal(@Valid @ModelAttribute("animal") Animal animal){
        animalService.saveAnimal(animal);
        return "redirect:/";
    }

    @GetMapping("/animal/update/{id}")
    public String goUpdateAnimal(@PathVariable Integer id,Model model){
        Integer a=id-1;
        model.addAttribute("animal",animalService.getAnimalById(a));
        return "animal/update";
    }

    @PutMapping("/animal/update/{id}")
    public String updateAnimal(@Valid @PathVariable Integer id,@ModelAttribute("animal") Animal animal){
        //animal.setId(id);
        animalService.updateAnimal(id,animal);
        return "redirect:/";
    }

    @GetMapping("/animal/delete/{id}")
    public String goDeleteAnimal(@PathVariable Integer id,Model model){
        model.addAttribute("animal",animalService.getAnimalById(id));
        return "animal/delete";
    }

    @DeleteMapping("/animal/delete/{id}")
    public String deleteAnimal(@PathVariable Integer id){
        animalService.deleteAnimal(id);
        return "redirect:/";
    }
}
    /*
    // Obtener todos los animales
    @GetMapping
    public List<Animal> getAllAnimales() {
        return animalService.getAllAnimales();
    }

    // Obtener un animal por su ID
    @GetMapping("/{id}")
    public ResponseEntity<Animal> getAnimalById(@PathVariable int id) {
        Animal animal = animalService.getAnimalById(id);
        if (animal != null) {
            return ResponseEntity.ok(animal);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Crear un nuevo animal
    @PostMapping
    public Animal saveAnimal(@RequestBody Animal animal) {
        return animalService.saveAnimal(animal);
    }

    // Actualizar un animal existente
    @PutMapping("/{id}")
    public ResponseEntity<Animal> updateAnimal(@PathVariable int id, @RequestBody Animal updatedAnimal) {
        Animal animal = animalService.updateAnimal(id, updatedAnimal);
        if (animal != null) {
            return ResponseEntity.ok(animal);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Eliminar un animal por su ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAnimal(@PathVariable int id) {
        if (animalService.deleteAnimal(id)) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    */

