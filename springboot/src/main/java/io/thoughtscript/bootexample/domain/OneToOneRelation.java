package io.thoughtscript.bootexample.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "onerelation")
@AllArgsConstructor
@NoArgsConstructor
public class OneToOneRelation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;

    @Column(name = "name")
    private String name;

    /*
    @PrimaryKeyJoinColumn
     Use EAGER here since OneToOne
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "examplefk")
    private Example example;

    public OneToOneRelation(Long id, String name) {
        this.id = id;
        this.name = name;
    }
    */
}
