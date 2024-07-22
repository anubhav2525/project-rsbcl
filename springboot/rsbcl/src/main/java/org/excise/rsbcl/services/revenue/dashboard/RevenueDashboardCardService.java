package org.excise.rsbcl.services.revenue.dashboard;

import org.excise.rsbcl.dao.revenue.dashboard.RevenueDashboardCardDAO;
import org.excise.rsbcl.repository.revenue.beer.RevenueBeerRepo;
import org.excise.rsbcl.repository.revenue.countryLiquor.RevenueCountryLiquorRepo;
import org.excise.rsbcl.repository.revenue.iml.RevenueImlRepo;
import org.excise.rsbcl.repository.revenue.rml.RevenueRmlRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

@Service
public class RevenueDashboardCardService {
    @Autowired
    private final RevenueBeerRepo revenueBeerRepo;

    @Autowired
    private final RevenueCountryLiquorRepo revenueCountryLiquorRepo;

    @Autowired
    private final RevenueImlRepo revenueImlRepo;

    @Autowired
    private final RevenueRmlRepo revenueRmlRepo;

    @Autowired
    private final RevenueDashboardCardDAO revenueDashboardCardDAO;

    public RevenueDashboardCardService(RevenueBeerRepo revenueBeerRepo, RevenueCountryLiquorRepo revenueCountryLiquorRepo, RevenueImlRepo revenueImlRepo, RevenueRmlRepo revenueRmlRepo, RevenueDashboardCardDAO revenueDashboardCardDAO) {
        this.revenueBeerRepo = revenueBeerRepo;
        this.revenueCountryLiquorRepo = revenueCountryLiquorRepo;
        this.revenueImlRepo = revenueImlRepo;
        this.revenueRmlRepo = revenueRmlRepo;
        this.revenueDashboardCardDAO = revenueDashboardCardDAO;
    }

    
}
