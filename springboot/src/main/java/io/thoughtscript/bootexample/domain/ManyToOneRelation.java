package io.thoughtscript.bootexample.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.BatchSize;

@Entity
@Getter
@Setter
@Table(name = "manyonerelation")
@AllArgsConstructor
@NoArgsConstructor
@BatchSize(size = 10)
@Cacheable // Hibernate Cache
public class ManyToOneRelation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;

    @Column(name = "name")
    private String name;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="examplefk")
    private Example example;

    public ManyToOneRelation(Long id, String name) {
        this.id = id;
        this.name = name;
    }
}
