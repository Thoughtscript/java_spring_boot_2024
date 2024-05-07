package io.thoughtscript.bootexample.controllers;

import io.thoughtscript.bootexample.domain.ManyToManyRelation;
import io.thoughtscript.bootexample.domain.ManyToOneRelation;
import io.thoughtscript.bootexample.domain.OneToManyRelation;
import io.thoughtscript.bootexample.domain.OneToOneRelation;
import io.thoughtscript.bootexample.services.ManyToManyRelationService;
import io.thoughtscript.bootexample.services.ManyToOneRelationService;
import io.thoughtscript.bootexample.services.OneToManyRelationService;
import io.thoughtscript.bootexample.services.OneToOneRelationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Slf4j
@Controller
@RequestMapping("/api/relations")
public class RelationController {

    @Autowired
    OneToOneRelationService oneToOneRelationService;

    @Autowired
    OneToManyRelationService oneToManyRelationService;

    @Autowired
    ManyToOneRelationService manyToOneRelationService;

    @Autowired
    ManyToManyRelationService manyToManyRelationService;

    @GetMapping("/one/one/all")
    @ResponseBody
    public ResponseEntity getAllOneToOneRelations() {
        List<OneToOneRelation> result = oneToOneRelationService.getAllOneToOneRelations();
        return ResponseEntity.ok(result);
    }

    @GetMapping("/one/many/all")
    @ResponseBody
    public ResponseEntity getAllOneToManyRelations() {
        List<OneToManyRelation> result = oneToManyRelationService.getAllOneToManyRelations();
        return ResponseEntity.ok(result);
    }

    @GetMapping("/many/one/all")
    @ResponseBody
    public ResponseEntity getAllManyToOneRelations() {
        List<ManyToOneRelation> result = manyToOneRelationService.getAllManyToOneRelations();
        return ResponseEntity.ok(result);
    }

    @GetMapping("/many/many/all")
    @ResponseBody
    public ResponseEntity getAllManyToManyRelations() {
        List<ManyToManyRelation> result = manyToManyRelationService.getAllManyToManyRelations();
        return ResponseEntity.ok(result);
    }
}
