package com.recipin.reciping_app.controller;

import com.recipin.reciping_app.model.Step;
import com.recipin.reciping_app.model.User;
import com.recipin.reciping_app.repository.StepRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/step")
public class StepControler {
    @Autowired
    private StepRepository stepRepo;

    @GetMapping
    public List<Step> getAllSteps() {
        return stepRepo.findAll();
    }

    @PostMapping
    public Step createStep(@RequestBody Step step) {
        return stepRepo.save(step);
    }

    @DeleteMapping("/{id}")
    public void deleteStep(@PathVariable Long id) {
        stepRepo.deleteById(id);
    }
}
