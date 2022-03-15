package no.ntnu.IDATT2105.oving_5_backend.controller;

import no.ntnu.IDATT2105.oving_5_backend.models.Calculations;
import no.ntnu.IDATT2105.oving_5_backend.repo.CalculationsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

public class CalculationsController {
    @Autowired
    CalculationsRepo calculationsRepo;
    @GetMapping("/tutorials")
    public ResponseEntity<List<Calculations>> getAllCalculations(@RequestParam(required = false) String title) {
        try {
            List<Calculations> calculations = new ArrayList<Calculations>();
                calculationsRepo.findAll().forEach(calculations::add);
            return new ResponseEntity<>(calculations, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/tutorials/{id}")
    public ResponseEntity<Calculations> getTutorialById(@PathVariable("id") long id) {
        Calculations calculation = calculationsRepo.findById(id);
        if (calculation != null) {
            return new ResponseEntity<>(calculation, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @PostMapping("/tutorials")
    public ResponseEntity<String> createTutorial(@RequestBody Calculations tutorial) {
        try {
            calculationsRepo.save(new Calculations(tutorial.getFirstNumber(), tutorial.getOperator(), tutorial.getSecondNumber(), tutorial.getCalculation()));
            return new ResponseEntity<>("Tutorial was created successfully.", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PutMapping("/tutorials/{id}")
    public ResponseEntity<String> updateTutorial(@PathVariable("id") long id, @RequestBody Calculations tutorial) {
        Calculations _tutorial = calculationsRepo.findById(id);
        if (_tutorial != null) {
            _tutorial.setId(id);
            _tutorial.setFirstNumber(tutorial.getFirstNumber());
            _tutorial.setOperator(tutorial.getOperator());
            _tutorial.setSecondNumber(tutorial.getSecondNumber());
            _tutorial.setCalculation(tutorial.getCalculation());
            calculationsRepo.update(_tutorial);
            return new ResponseEntity<>("Tutorial was updated successfully.", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Cannot find Tutorial with id=" + id, HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping("/tutorials/{id}")
    public ResponseEntity<String> deleteTutorial(@PathVariable("id") long id) {
        try {
            int result = calculationsRepo.deleteById(id);
            if (result == 0) {
                return new ResponseEntity<>("Cannot find Tutorial with id=" + id, HttpStatus.OK);
            }
            return new ResponseEntity<>("Tutorial was deleted successfully.", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Cannot delete tutorial.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @DeleteMapping("/tutorials")
    public ResponseEntity<String> deleteAllTutorials() {
        try {
            int numRows = calculationsRepo.deleteAll();
            return new ResponseEntity<>("Deleted " + numRows + " Tutorial(s) successfully.", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Cannot delete tutorials.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
