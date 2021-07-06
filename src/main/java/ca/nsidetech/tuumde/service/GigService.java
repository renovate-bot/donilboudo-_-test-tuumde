package ca.nsidetech.tuumde.service;

import ca.nsidetech.tuumde.model.Gig;
import ca.nsidetech.tuumde.repository.GigRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GigService {
    private final GigRepository gigRepository;

    public GigService(GigRepository gigRepository) {
        this.gigRepository = gigRepository;
    }

    public void createGig(Gig gig) {
        gigRepository.save(gig);
    }

    public Iterable<Gig> getGigs() {
        return gigRepository.findAll();
    }

    public Optional<Gig> getGigById(Long id) {
        return gigRepository.findById(id);
    }

    public void updateGig(Gig gig) {
        gigRepository.save(gig);
    }
}
