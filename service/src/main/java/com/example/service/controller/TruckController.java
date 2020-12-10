package com.example.service.controller;

import com.example.service.model.Truck;
import com.example.service.repo.TruckRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*
 * Created by Aleksei Vekovshinin on 10.12.2020
 */
@RestController
@RequestMapping("/trucks")
public class TruckController {

    private final TruckRepository truckRepository;
    @Autowired
    public TruckController(TruckRepository truckRepository) {
        this.truckRepository = truckRepository;
    }

    @GetMapping
    public ResponseEntity<List<Truck>> getAll() {
        return new ResponseEntity<>(truckRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<Truck> getOne(@PathVariable("id") Truck truckFromDb) {
        return new ResponseEntity<>(truckFromDb, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Truck> create(@RequestBody Truck truck) {
        return new ResponseEntity<>(truckRepository.save(truck), HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<Truck> update(
            @PathVariable("id") Truck truckFromDb,
            @RequestBody Truck truck
    ) {
        BeanUtils.copyProperties(truck, truckFromDb, "id");
        return new ResponseEntity<>(truckRepository.save(truck), HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<?> deleteAll() {
        truckRepository.deleteAll();
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteOne(@PathVariable("id") Truck truck) {
        truckRepository.delete(truck);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
