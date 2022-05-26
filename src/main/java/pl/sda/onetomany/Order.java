package pl.sda.onetomany;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Integer id;

    @Column(columnDefinition = "DECIMAL(7,2)")
    private BigDecimal totalAmount;

    private String products;

    private LocalDateTime date;

    @ManyToOne
    private Client client;


}
