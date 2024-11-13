package com.exo1.exo1.controller;

import com.exo1.exo1.dto.ProjetDto;
import com.exo1.exo1.dto.ProjetTaskCountDto;
import com.exo1.exo1.service.ProjetTaskCountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/count")
public class ProjetTaskCountController {

    @Autowired
    private ProjetTaskCountService projetTaskCountService;

    @GetMapping
    public ResponseEntity<List<ProjetTaskCountDto>> findAll()
    {
        return ResponseEntity.ok(projetTaskCountService.findAll());
    }
}
