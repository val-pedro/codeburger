package br.com.codeburger.codeburger.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "sandwich")
public class Sandwich extends AbstractEntity{
    @Id

    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String name;

    @OneToMany(mappedBy = "sandwich")
    private List<SandwichIngredient> sandwichIngredients;

//    @OneToMany(mappedBy = "sandwich")
//    private List<OrderItem> orderItems;
}