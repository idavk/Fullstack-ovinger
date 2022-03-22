package no.ntnu.IDATT2105.oving_5_backend.controller;

import no.ntnu.IDATT2105.oving_5_backend.models.Calculator.CalculatorRequest;
import no.ntnu.IDATT2105.oving_5_backend.models.Calculator.CalculatorResponse;
import no.ntnu.IDATT2105.oving_5_backend.service.CalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/calculate")
@EnableAutoConfiguration
@CrossOrigin
public class CalculationsController {
    @Autowired
    CalculatorService calculatorService;

    @PostMapping(value = "", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.CREATED)
    public CalculatorResponse doCalculate(final @RequestBody CalculatorRequest calculatorRequest, HttpSession session) {
        Long userId = (Long)session.getAttribute("user_id");
        if(userId == null){
            return null;
        }

        return calculatorService.doCalculation(calculatorRequest, userId);
    }

    @GetMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.OK)
    public List<CalculatorResponse> getCalculations() {
        return calculatorService.getCalculations();
    }

    /**@GetMapping("")
    public ArrayList<CalculatorResponse> returnToJSON() {
        return calculatorService.
                returnInJson();
    }*/

}
