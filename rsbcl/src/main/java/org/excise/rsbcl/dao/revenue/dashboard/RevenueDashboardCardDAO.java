package org.excise.rsbcl.dao.revenue.dashboard;

import org.springframework.stereotype.Component;

import java.time.LocalTime;

@Component
public class RevenueDashboardCardDAO {
    private Double amount;
    private Double percentage;
    private String cardName;
    private LocalTime time;
    private int year;
}
