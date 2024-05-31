package com.techiteasy.controller.controllers;

import com.techiteasy.controller.exceptions.ProductNameTooLongException;
import com.techiteasy.controller.exceptions.RecordNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/televisions")
public class TelevisionController {

    ArrayList<String> televisionDataBase = new ArrayList<>();

    @GetMapping
    public ResponseEntity<Object> getAllTelevisions() {
        return ResponseEntity.ok(televisionDataBase);
    }

    @GetMapping("/{id}")
    public ResponseEntity<String> getTelevision(@PathVariable int id) {
        if (id >= 0 && id < televisionDataBase.size()) {
            return ResponseEntity.ok(televisionDataBase.get(id));
        } else {
            throw new RecordNotFoundException("No television in list with id " + id + "!");
        }
    }

    @PostMapping
    public ResponseEntity<String> createTelevision(@RequestBody String name) {
        if (name.length() < 21){
            televisionDataBase.add(name);
            return ResponseEntity.created(null).body("Created television " + name);
        } else {
            throw new ProductNameTooLongException("Name for new television exceeds 20 characters! Please use a shorter name.");
        }

    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateTelevision(@PathVariable int id, @RequestBody String updatedName) {
        if (id >= 0 && id < televisionDataBase.size()) {
            televisionDataBase.set(id, updatedName);
            return ResponseEntity.ok("Updated television #" + id + " to " + updatedName);
        } else {
            throw new RecordNotFoundException("No television in list with id " + id + "!");
        }

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTelevision(@PathVariable int id) {
        if (id >= 0 && id < televisionDataBase.size()) {
            televisionDataBase.remove(id);

//            Or if the list has to stay same size:
//            televisionDataBase.set(id, null);

            return ResponseEntity.noContent().build();
        } else {
            throw new RecordNotFoundException("No television in list with id " + id + "!");
        }

    }

}
