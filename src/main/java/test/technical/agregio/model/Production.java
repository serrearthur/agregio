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

    /**
     * Une production correspond a :
     *  - un amountProduced d'éléctricité, en MW
     *  - pendant un timeBlock précis
     *  - avec un prix de vente minimal équivalent a la minimalRetailValue
     */

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "production_generator")
    @SequenceGenerator(name = "production_generator", sequenceName = "production_sequence", allocationSize = 1)
    private long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private Provider provider;

    // The amount of electricity produced, in MW
    @Column(name = "amount_produced")
    @Builder.Default
    private BigDecimal amountProduced = BigDecimal.ZERO;

    // The minimal retail value
    @Column(name = "minimal_retail_value")
    @Builder.Default
    private BigDecimal minimalRetailValue = BigDecimal.ZERO;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "time_block_id")
    private TimeBlock timeBlock;
}
