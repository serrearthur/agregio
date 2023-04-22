package test.technical.agregio.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import test.technical.agregio.model.TimeBlock;

public interface TimeBlockDao extends JpaRepository<TimeBlock, Long> {
}
