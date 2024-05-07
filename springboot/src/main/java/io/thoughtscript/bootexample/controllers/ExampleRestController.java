package io.thoughtscript.bootexample.controllers;

import io.thoughtscript.bootexample.domain.Example;
import io.thoughtscript.bootexample.services.ExampleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/example")
public class ExampleRestController {

    @Autowired
    ExampleService exampleService;

    @GetMapping("/all")
    public ResponseEntity getAllExamples() {
        List<Example> result = exampleService.getAllExamples();
        return ResponseEntity.ok(result);
    }
}
