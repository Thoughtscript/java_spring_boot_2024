package io.thoughtscript.bootexample.repositories;

import io.thoughtscript.bootexample.domain.ManyToManyRelation;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ManyToManyRelationRepository extends CrudRepository<ManyToManyRelation, Long> {
}