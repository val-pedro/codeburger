package br.com.codeburger.codeburger.dto;

import br.com.codeburger.codeburger.model.Order;
import br.com.codeburger.codeburger.model.Sandwich;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderItemDTO {

    private Long id;

    private Integer quantity;

    private Double price;

    private Double discountValue;

    private Double discountPercentage;

    private Sandwich sandwich;

}
