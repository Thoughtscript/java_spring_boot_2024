package io.thoughtscript.bootexample.repositories;

import io.thoughtscript.bootexample.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExampleJpaRepository extends JpaRepository<Example, Long> {

    @Query(value = "SELECT * FROM example AS e WHERE e.name LIKE %:name%", nativeQuery = true)
    Long customizedJpaQuery(@Param("name") String name);
}
