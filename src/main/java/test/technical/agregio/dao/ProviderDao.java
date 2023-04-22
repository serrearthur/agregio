package test.technical.agregio.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import test.technical.agregio.model.Provider;

public interface ProviderDao extends JpaRepository<Provider, Long> {
}
