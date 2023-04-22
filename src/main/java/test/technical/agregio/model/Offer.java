package test.technical.agregio.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashMap;
import java.util.Map;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class Offer {
    /**
     * Une offre commericale est modélisée comme une Map reliant des blocs horaires et des fournisseurs.
     * A partir de cette Map, on va pouvoir retrouver la production pour chaque bloc horaire, ainsi que le prix minimal.
     *
     * En faisant la somme de chaque entrySet de la Map, on va donc pouvoir trouver le prix total de l'offre.
     */

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "offer_generator")
    @SequenceGenerator(name = "offer_generator", sequenceName = "offer_sequence", allocationSize = 1)
    private long id;

    private String reference;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "offer_timeblock_provider",
            joinColumns = {@JoinColumn(name = "offer_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "provider_id", referencedColumnName = "id")})
    @MapKeyJoinColumn(name = "time_block_id")
    @Builder.Default
    private Map<TimeBlock, Provider> contract = new HashMap<>();

}
