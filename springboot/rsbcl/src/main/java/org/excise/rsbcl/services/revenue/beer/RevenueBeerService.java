package org.excise.rsbcl.services.revenue.beer;

import org.excise.rsbcl.model.revenue.beer.RevenueBeer;
import org.excise.rsbcl.repository.revenue.beer.RevenueBeerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RevenueBeerService {
    @Autowired
    private final RevenueBeerRepo revenueBeerRepo;

    public RevenueBeerService(RevenueBeerRepo revenueBeerRepo) {
        this.revenueBeerRepo = revenueBeerRepo;
    }

    public List<RevenueBeer> getAll() {
        return revenueBeerRepo.findAll();
    }

    public List<RevenueBeer> getRevenueBeerByYear(int year) {
        List<RevenueBeer> revenueBeers = revenueBeerRepo.findAll();
        return revenueBeers.stream().filter(revenueBeer -> revenueBeer.getYear() == year).toList();
    }


}
