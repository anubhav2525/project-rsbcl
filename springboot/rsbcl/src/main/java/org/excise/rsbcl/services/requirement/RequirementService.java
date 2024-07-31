package org.excise.rsbcl.services.requirement;

import org.excise.rsbcl.repository.requirement.RequirementRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RequirementService {
    @Autowired
    private final RequirementRepo requirementRepo;

    public RequirementService(RequirementRepo requirementRepo) {
        this.requirementRepo = requirementRepo;
    }
}
