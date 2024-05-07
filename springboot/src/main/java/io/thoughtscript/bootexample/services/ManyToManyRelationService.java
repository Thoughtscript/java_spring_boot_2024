package io.thoughtscript.bootexample.services;

import io.thoughtscript.bootexample.domain.ManyToManyRelation;
import io.thoughtscript.bootexample.repositories.ManyToManyRelationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ManyToManyRelationService {

    @Autowired
    ManyToManyRelationRepository manyToManyRelationRepository;

    public List<ManyToManyRelation> getAllManyToManyRelations() {
        return (List<ManyToManyRelation>) manyToManyRelationRepository.findAll();
    }
}
