package io.thoughtscript.bootexample.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonView;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "example")
@AllArgsConstructor
@NoArgsConstructor
public class Example {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;

    @Column(name = "name")
    private String name;

    //@PrimaryKeyJoinColumn
    // Use EAGER here since OneToOne
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "oneonerelationfk")
    private OneToOneRelation oneToOneRelation;

    // Use LAZY here to avoid infinite JSON
    @OneToMany(fetch = FetchType.LAZY, mappedBy="examplefk")
    private List<OneToManyRelation> oneToManyRelations;

    @Column(name = "manyonerelationfk")
    private Long manyonerelationfk;

    // Use LAZY here - best practice
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name= "E_M", joinColumns = @JoinColumn(name = "eId"),inverseJoinColumns = @JoinColumn(name = "mmId"))
    private List<ManyToManyRelation> manyToManyRelations;

    public Example(Long id, String name) {
        this.id = id;
        this.name = name;
    }
}