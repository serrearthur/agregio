package test.technical.agregio.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import test.technical.agregio.model.Offer;

public interface OfferDao extends JpaRepository<Offer, Long> {
}
