package io.thoughtscript.bootexample.services;

import io.thoughtscript.bootexample.domain.ManyToOneRelation;
import io.thoughtscript.bootexample.repositories.ManyToOneRelationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ManyToOneRelationService {

    @Autowired
    ManyToOneRelationRepository manyToOneRelationRepository;

    public List<ManyToOneRelation> getAllManyToOneRelations() {
        return (List<ManyToOneRelation>) manyToOneRelationRepository.findAll();
    }
}
