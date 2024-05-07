package io.thoughtscript.bootexample.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "manyonerelation")
@AllArgsConstructor
@NoArgsConstructor
public class ManyToOneRelation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;

    @Column(name = "name")
    private String name;

    @ManyToOne
    @JoinColumn(name="examplefk")
    private Example example;

    public ManyToOneRelation(Long id, String name) {
        this.id = id;
        this.name = name;
    }
}
