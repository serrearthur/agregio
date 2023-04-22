package test.technical.agregio.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;

    private OffsetTime startTime;

    private OffsetTime endTime;

}
