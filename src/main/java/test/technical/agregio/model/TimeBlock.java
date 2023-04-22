package test.technical.agregio.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.OffsetTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class TimeBlock {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "time_block_generator")
    @SequenceGenerator(name = "time_block_generator", sequenceName = "time_block_sequence", allocationSize = 1)
    private long id;

    private OffsetTime startTime;

    private OffsetTime endTime;

}
