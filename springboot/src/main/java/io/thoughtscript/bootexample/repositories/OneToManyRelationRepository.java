package io.thoughtscript.bootexample.repositories;

import io.thoughtscript.bootexample.domain.OneToManyRelation;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OneToManyRelationRepository extends CrudRepository<OneToManyRelation, Long> {
}