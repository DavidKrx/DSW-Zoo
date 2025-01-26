package com.spring.Zoo.controller;

import com.spring.Zoo.model.Clase;
import com.spring.Zoo.service.ClaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clases")
public class ClaseController {

    @Autowired
    private ClaseService claseService;

    @GetMapping
    public List<Clase> getAllClases() {
        return claseService.getAllClases();
    }

    @PostMapping
    public Clase saveClase(@RequestBody Clase clase) {
        return claseService.saveClase(clase);
    }
}

