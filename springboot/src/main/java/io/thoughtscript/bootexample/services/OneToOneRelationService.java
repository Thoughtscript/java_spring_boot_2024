package io.thoughtscript.bootexample.services;

import io.thoughtscript.bootexample.domain.OneToOneRelation;
import io.thoughtscript.bootexample.repositories.OneToOneRelationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional(readOnly = true)
public class OneToOneRelationService {

    @Autowired
    OneToOneRelationRepository oneToOneRelationRepository;

    @Cacheable("onetoone")
    public List<OneToOneRelation> getAllOneToOneRelations() {
        List<OneToOneRelation> result = new ArrayList<>();
        oneToOneRelationRepository.findAll().forEach(result::add);
        return result;
    }

}
