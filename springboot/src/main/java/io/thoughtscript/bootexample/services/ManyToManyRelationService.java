package io.thoughtscript.bootexample.services;

import io.thoughtscript.bootexample.domain.ManyToManyRelation;
import io.thoughtscript.bootexample.repositories.ManyToManyRelationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional(readOnly = true)
public class ManyToManyRelationService {

    @Autowired
    ManyToManyRelationRepository manyToManyRelationRepository;

    @Cacheable("manytomany")
    public List<ManyToManyRelation> getAllManyToManyRelations() {
        List<ManyToManyRelation> result = new ArrayList<>();
        manyToManyRelationRepository.findAll().forEach(result::add);
        return result;
    }
}
