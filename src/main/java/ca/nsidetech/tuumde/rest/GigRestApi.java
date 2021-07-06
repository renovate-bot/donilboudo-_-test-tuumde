package ca.nsidetech.tuumde.rest;

import ca.nsidetech.tuumde.model.Gig;
import ca.nsidetech.tuumde.service.GigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class GigRestApi {
    private GigService gigService;

    @Autowired
    public GigRestApi(GigService gigService) {
        this.gigService = gigService;
    }

    @PostMapping(value = "/gigs")
    @ResponseStatus(value = HttpStatus.CREATED)
    public void createGig(@RequestBody Gig gig) {
        gigService.createGig(gig);
    }

    @GetMapping(value = "/gigs")
    public Iterable<Gig> getGigs() {
        return gigService.getGigs();
    }

    @GetMapping(value = "/gigs/{id}")
    public Gig findGig(@PathVariable Long id) {
        return gigService.getGigById(id).orElse(null);
    }

    @PutMapping(value = "/gigs")
    public void updateGig(@RequestBody Gig gig) {
        gigService.updateGig(gig);
    }
}
