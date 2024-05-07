package io.thoughtscript.bootexample.services;

import io.thoughtscript.bootexample.domain.Example;
import io.thoughtscript.bootexample.repositories.ExampleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExampleService {

    @Autowired
    ExampleRepository exampleRepository;

    public List<Example> getAllExamples() {
        return (List<Example>) exampleRepository.findAll();
    }

}
