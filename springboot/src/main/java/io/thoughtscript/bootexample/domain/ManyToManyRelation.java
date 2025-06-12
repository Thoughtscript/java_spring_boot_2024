package io.thoughtscript.bootexample.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.BatchSize;

import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "manymanyrelation")
@AllArgsConstructor
@NoArgsConstructor
@BatchSize(size = 10)
@Cacheable // Hibernate Cache
public class ManyToManyRelation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;

    @Column(name = "name")
    private String name;

    // Use LAZY here - best practice
    // Use @JsonIgnore to avoid infinite JSON recursion - here
    @JsonIgnore
    @ManyToMany(mappedBy="manyToManyRelations", fetch = FetchType.LAZY)
    private Set<Example> examples; // Set is better

    public ManyToManyRelation(Long id, String name) {
        this.id = id;
        this.name = name;
    }
}
