package io.thoughtscript.bootexample.repositories;

import io.thoughtscript.bootexample.domain.ManyToOneRelation;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ManyToOneRelationRepository extends CrudRepository<ManyToOneRelation, Long> {
}
