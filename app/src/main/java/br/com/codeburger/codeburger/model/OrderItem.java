package br.com.codeburger.codeburger.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "order_item")
public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private Integer quantity;

    @Column
    private Double price;

    @Column
    private Double discountValue;

    @Column
    private Double discountPercentage;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id", referencedColumnName = "id")
    private Order order;

    @ManyToOne
    @JoinColumn(name = "sandwich_id", referencedColumnName = "id")
    private Sandwich sandwich;

    @OneToMany(mappedBy = "orderItem", fetch = FetchType.LAZY)
    private List<OrderItemAdditionalIngredient> orderItemAdditionalIngredients;
}
