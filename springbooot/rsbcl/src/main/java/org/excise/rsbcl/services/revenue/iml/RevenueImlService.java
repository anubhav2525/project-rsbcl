package org.excise.rsbcl.services.revenue.iml;

import org.excise.rsbcl.model.revenue.iml.RevenueIml;
import org.excise.rsbcl.repository.revenue.iml.RevenueImlRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RevenueImlService {
    @Autowired
    private RevenueImlRepo revenueImlRepo;

    public List<RevenueIml> getAll() {
        return revenueImlRepo.findAll();
    }

    public List<RevenueIml> getRevenueImlByYear(int year) {
        List<RevenueIml> revenueImls = revenueImlRepo.findAll();
        return revenueImls.stream().filter(revenueIml -> revenueIml.getYear() == year).toList();
    }
}
