package io.thoughtscript.bootexample.services;

import io.thoughtscript.bootexample.domain.Example;
import io.thoughtscript.bootexample.repositories.ExampleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional(readOnly = true)
public class ExampleService {

    @Autowired
    ExampleRepository exampleRepository;

    @Cacheable("examples")
    public List<Example> getAllExamples() {
        List<Example> result = new ArrayList<>();
        exampleRepository.findAll().forEach(result::add);
        return result;
    }

}
