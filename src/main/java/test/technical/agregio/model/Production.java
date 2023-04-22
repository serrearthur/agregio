package test.technical.agregio.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class Production {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private Provider provider;

    // The amount of electricity produced, in MW
    @Column(name = "amount_produced")
    private BigDecimal amountProduced;

    // The minimal retail value
    @Column(name = "minimal_retail_value")
    private BigDecimal minimalRetailValue;

    @ManyToOne(fetch = FetchType.LAZY)
    private TimeBlock timeBlock;
}
