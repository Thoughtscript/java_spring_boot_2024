package io.thoughtscript.bootexample.prepopulate;

import io.thoughtscript.bootexample.domain.*;
import io.thoughtscript.bootexample.repositories.*;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Slf4j
@Component
public class DatabaseInitialization {

    @Autowired
    ExampleRepository exampleRepository;

    @Autowired
    OneToOneRelationRepository oneToOneRelationRepository;

    @Autowired
    OneToManyRelationRepository oneToManyRelationRepository;

    @Autowired
    ManyToOneRelationRepository manyToOneRelationRepository;

    @Autowired
    ManyToManyRelationRepository manyToManyRelationRepository;

    @PostConstruct
    private void postConstruct() {
        /*
         * Remember null values in tandem with AutoIncrement will auto-populate id.
         */
        OneToOneRelation a = new OneToOneRelation(null, "a");
        OneToOneRelation b = new OneToOneRelation(null, "b");
        OneToOneRelation c = new OneToOneRelation(null, "c");
        OneToOneRelation d = new OneToOneRelation(null, "d");
        oneToOneRelationRepository.save(a);
        oneToOneRelationRepository.save(b);
        oneToOneRelationRepository.save(c);
        oneToOneRelationRepository.save(d);

        OneToManyRelation aaa = new OneToManyRelation(null,"aaa");
        OneToManyRelation bbb = new OneToManyRelation(null,"bbb");
        OneToManyRelation ccc = new OneToManyRelation(null,"ccc");
        OneToManyRelation ddd = new OneToManyRelation(null,"ddd");
        OneToManyRelation eee = new OneToManyRelation(null,"aaa");
        OneToManyRelation fff = new OneToManyRelation(null,"bbb");
        OneToManyRelation ggg = new OneToManyRelation(null,"ccc");
        OneToManyRelation hhh = new OneToManyRelation(null,"ddd");
        oneToManyRelationRepository.save(aaa);
        oneToManyRelationRepository.save(bbb);
        oneToManyRelationRepository.save(ccc);
        oneToManyRelationRepository.save(ddd);
        oneToManyRelationRepository.save(eee);
        oneToManyRelationRepository.save(fff);
        oneToManyRelationRepository.save(ggg);
        oneToManyRelationRepository.save(hhh);

        ManyToOneRelation aaaa = new ManyToOneRelation(null, "aaaa");
        ManyToOneRelation bbbb = new ManyToOneRelation(null, "bbbb");
        ManyToOneRelation cccc = new ManyToOneRelation(null, "cccc");
        ManyToOneRelation dddd = new ManyToOneRelation(null, "dddd");
        manyToOneRelationRepository.save(aaaa);
        manyToOneRelationRepository.save(bbbb);
        manyToOneRelationRepository.save(cccc);
        manyToOneRelationRepository.save(dddd);

        ManyToManyRelation aaaaa = new ManyToManyRelation(null, "aaaaa");
        ManyToManyRelation bbbbb = new ManyToManyRelation(null, "bbbbb");
        ManyToManyRelation ccccc = new ManyToManyRelation(null, "ccccc");
        ManyToManyRelation ddddd = new ManyToManyRelation(null, "ddddd");
        manyToManyRelationRepository.save(aaaaa);
        manyToManyRelationRepository.save(bbbbb);
        manyToManyRelationRepository.save(ccccc);
        manyToManyRelationRepository.save(ddddd);

        Example aa = new Example(null, "aa");
        Example bb = new Example(null, "bb");
        Example cc = new Example(null, "cc");
        Example dd = new Example(null, "dd");
        exampleRepository.save(aa);
        exampleRepository.save(bb);
        exampleRepository.save(cc);
        exampleRepository.save(dd);

        aa.setManyonerelationfk(aaaa.getId());
        aa.setOneToOneRelation(a);
        Set<OneToManyRelation> aaOneToManyRelations = new HashSet<>();
        aaOneToManyRelations.add(aaa);
        aaOneToManyRelations.add(bbb);
        aa.setOneToManyRelations(aaOneToManyRelations);
        aa.setManyonerelationfk(aaaa.getId());
        aaaa.setExample(aa);
        aaa.setExamplefk(aa.getId());
        bbb.setExamplefk(aa.getId());
        Set<ManyToManyRelation> aaManyToManyRelations = new HashSet<>();
        aaManyToManyRelations.add(aaaaa);
        aaManyToManyRelations.add(bbbbb);
        Set<Example> aaaaaExamples = new HashSet<>();
        aaaaaExamples.add(aa);
        aaaaaExamples.add(bb);
        aa.setManyToManyRelations(aaManyToManyRelations);
        aaaaa.setExamples(aaaaaExamples);

        bb.setManyonerelationfk(bbbb.getId());
        bb.setOneToOneRelation(b);
        Set<OneToManyRelation> bbOneToManyRelations = new HashSet<>();
        bbOneToManyRelations.add(ccc);
        bbOneToManyRelations.add(ddd);
        bb.setOneToManyRelations(aaOneToManyRelations);
        ccc.setExamplefk(bb.getId());
        ddd.setExamplefk(bb.getId());
        bb.setManyonerelationfk(bbbb.getId());
        bbbb.setExample(bb);

        cc.setManyonerelationfk(cccc.getId());
        cc.setOneToOneRelation(c);
        Set<OneToManyRelation> ccOneToManyRelations = new HashSet<>();
        ccOneToManyRelations.add(eee);
        ccOneToManyRelations.add(fff);
        cc.setOneToManyRelations(aaOneToManyRelations);
        eee.setExamplefk(cc.getId());
        fff.setExamplefk(cc.getId());
        cc.setManyonerelationfk(cccc.getId());
        cccc.setExample(cc);

        dd.setManyonerelationfk(dddd.getId());
        dd.setOneToOneRelation(d);
        Set<OneToManyRelation> ddOneToManyRelations = new HashSet<>();
        ddOneToManyRelations.add(ggg);
        ddOneToManyRelations.add(hhh);
        dd.setOneToManyRelations(aaOneToManyRelations);
        ggg.setExamplefk(dd.getId());
        hhh.setExamplefk(dd.getId());
        dd.setManyonerelationfk(dddd.getId());
        dddd.setExample(dd);

        exampleRepository.save(aa);
        exampleRepository.save(bb);
        exampleRepository.save(cc);
        exampleRepository.save(dd);
        oneToManyRelationRepository.save(aaa);
        oneToManyRelationRepository.save(bbb);
        oneToManyRelationRepository.save(ccc);
        oneToManyRelationRepository.save(ddd);
        oneToManyRelationRepository.save(eee);
        oneToManyRelationRepository.save(fff);
        oneToManyRelationRepository.save(ggg);
        oneToManyRelationRepository.save(hhh);
        manyToOneRelationRepository.save(aaaa);
        manyToOneRelationRepository.save(bbbb);
        manyToOneRelationRepository.save(cccc);
        manyToOneRelationRepository.save(dddd);

        /*
        a.setExample(aa);
        b.setExample(bb);
        c.setExample(cc);
        d.setExample(dd);
        oneToOneRelationRepository.save(a);
        oneToOneRelationRepository.save(b);
        oneToOneRelationRepository.save(c);
        oneToOneRelationRepository.save(d);
        */

        log.info("Pre-populating complete!");
    }
}
