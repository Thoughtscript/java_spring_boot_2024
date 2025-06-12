package io.thoughtscript.bootexample.services;

import io.thoughtscript.bootexample.domain.ManyToOneRelation;
import io.thoughtscript.bootexample.repositories.ManyToOneRelationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional(readOnly = true)
public class ManyToOneRelationService {

    @Autowired
    ManyToOneRelationRepository manyToOneRelationRepository;

    @Cacheable("manytoone")
    public List<ManyToOneRelation> getAllManyToOneRelations() {
        List<ManyToOneRelation> result = new ArrayList<>();
        manyToOneRelationRepository.findAll().forEach(result::add);
        return result;
    }
}
