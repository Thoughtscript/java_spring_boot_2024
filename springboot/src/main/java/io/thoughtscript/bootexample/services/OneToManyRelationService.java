package io.thoughtscript.bootexample.services;

import io.thoughtscript.bootexample.domain.OneToManyRelation;
import io.thoughtscript.bootexample.repositories.OneToManyRelationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional(readOnly = true)
public class OneToManyRelationService {

    @Autowired
    OneToManyRelationRepository oneToManyRelationRepository;

    @Cacheable("onetomany")
    public List<OneToManyRelation> getAllOneToManyRelations() {
        List<OneToManyRelation> result = new ArrayList<>();
        oneToManyRelationRepository.findAll().forEach(result::add);
        return result;
    }
}
