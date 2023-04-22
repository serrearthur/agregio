package test.technical.agregio.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import test.technical.agregio.dao.OfferDao;

@Service
@Transactional
@RequiredArgsConstructor //needed for constructor dependency injection
public class OfferService {

    private final OfferDao offerDao;

    /*
     * TODO: implémentation des différentes méthodes nécessaires au programme
     */
}
