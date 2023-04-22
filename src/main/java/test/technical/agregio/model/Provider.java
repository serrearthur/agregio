package test.technical.agregio.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class Provider {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "provider_generator")
    @SequenceGenerator(name = "provider_generator", sequenceName = "provider_sequence", allocationSize = 1)
    private long id;

    private String name;

    @Column(name="energy_type")
    @Enumerated(EnumType.STRING)
    private EnergyType energyType;

    @OneToMany
    @JoinColumn(name = "provider_id")
    @Builder.Default
    private Set<Production> production = new HashSet<>();
}
