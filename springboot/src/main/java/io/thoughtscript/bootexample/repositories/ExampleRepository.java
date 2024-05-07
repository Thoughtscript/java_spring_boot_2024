package io.thoughtscript.bootexample.repositories;

import io.thoughtscript.bootexample.domain.Example;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExampleRepository extends CrudRepository<Example, Long> {
}