package br.com.codeburger.codeburger.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "ingredient")
public class Ingredient {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String name;

    @Column
    private Double price;

    @OneToMany(mappedBy = "ingredient")
    private List<SandwichIngredient> sandwichIngredients;

//    @OneToMany(mappedBy = "ingredient")
//    private List<OrderItemAdditionalIngredient> orderItemAdditionalIngredients;
}