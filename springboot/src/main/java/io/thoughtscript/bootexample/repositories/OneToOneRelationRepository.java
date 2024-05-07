package io.thoughtscript.bootexample.repositories;

import io.thoughtscript.bootexample.domain.OneToOneRelation;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OneToOneRelationRepository extends CrudRepository<OneToOneRelation, Long> {
}
