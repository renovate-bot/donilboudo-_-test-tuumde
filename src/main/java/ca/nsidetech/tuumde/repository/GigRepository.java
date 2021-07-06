package ca.nsidetech.tuumde.repository;

import ca.nsidetech.tuumde.model.Gig;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GigRepository extends CrudRepository<Gig, Long> {
}