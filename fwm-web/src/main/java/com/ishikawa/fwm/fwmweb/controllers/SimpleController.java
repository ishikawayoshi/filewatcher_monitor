package com.ishikawa.fwm.fwmweb.controllers;

import com.ishikawa.fwm.fwmcore.entities.SimpleEntity;
import com.ishikawa.fwm.fwmcore.services.SimpleEntityService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/")
public class SimpleController {

    private final SimpleEntityService simpleEntityService;

    public SimpleController(SimpleEntityService simpleEntityService) {
        this.simpleEntityService = simpleEntityService;
    }

    @GetMapping
    private ResponseEntity<List<SimpleEntity>> getAllSimpleEntities() {
        List<SimpleEntity> all = this.simpleEntityService.getAllEntities();
        return new ResponseEntity<>(all, HttpStatus.OK);
    }
}
