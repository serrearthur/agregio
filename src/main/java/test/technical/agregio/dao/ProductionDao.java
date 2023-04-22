package test.technical.agregio.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import test.technical.agregio.model.Production;

import java.util.Optional;
import java.util.Set;

public interface ProductionDao extends JpaRepository<Production, Long> {
    Set<Production> findAllByProvider_Id(Long providerId);

    Optional<Production> findByProvider_IdAndId(Long providerId, Long id);
}
