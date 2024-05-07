package io.thoughtscript.bootexample.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "onemanyrelation")
@AllArgsConstructor
@NoArgsConstructor
public class OneToManyRelation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "examplefk")
    private Long examplefk;

    public OneToManyRelation(Long id, String name) {
        this.id = id;
        this.name = name;
    }
}
