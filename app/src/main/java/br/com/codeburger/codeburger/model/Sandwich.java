package br.com.codeburger.codeburger.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "sandwich")
public class Sandwich {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String name;

    @OneToMany(mappedBy = "sandwich")
    private List<SandwichIngredient> sandwichIngredients;
}