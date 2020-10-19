package br.com.codeburger.codeburger.dto;

import br.com.codeburger.codeburger.model.OrderItem;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderDTO {

    private Long id;

    private Date date;

    private Double value;

    private List<OrderItemDTO> orderItems;

}
