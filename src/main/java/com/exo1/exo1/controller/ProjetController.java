package com.exo1.exo1.controller;

import com.exo1.exo1.dto.ProjetDto;
import com.exo1.exo1.service.ProjetService;
import com.exo1.exo1.service.ProjetTaskCountService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/projets")
@AllArgsConstructor
public class ProjetController {
    @Autowired
    private ProjetService projetService;
    private ProjetTaskCountService projetTaskCountService;


    @GetMapping
    public ResponseEntity<List<ProjetDto>> findAll()
    {
        return ResponseEntity.ok(projetService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProjetDto> findById(@PathVariable Long id)
    {
        return ResponseEntity.ok(projetService.findById(id));
    }
    @GetMapping("/name/{name}")
    public ResponseEntity<List<ProjetDto>> findByName(@PathVariable String name)
    {
        return ResponseEntity.ok(projetService.findByName(name));
    }

    @GetMapping("/test/{name}")
    public ResponseEntity<List<ProjetDto>> findByTest(@PathVariable String name)
    {
        return ResponseEntity.ok(projetService.findByTest(name));
    }

    @PostMapping
    public ResponseEntity<ProjetDto> save(@RequestBody ProjetDto projetDto) {
        ProjetDto saved = projetService.save(projetDto);
        projetTaskCountService.refreshMaterializedView();
        return ResponseEntity.ok(saved);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProjetDto> update(@PathVariable Long id, @RequestBody ProjetDto projetDto) {
        return ResponseEntity.ok(projetService.update(id, projetDto));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        projetService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
